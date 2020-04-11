package it.francescobianchi.familybudget.usecase

import it.francescobianchi.familybudget.model.MonthlyBudget
import it.francescobianchi.familybudget.model.time.Month
import it.francescobianchi.familybudget.model.time.Year
import it.francescobianchi.familybudget.repository.MonthlyBudgetRepository

class GetCurrentMonthlyBudgetUseCase(val monthlyBudgetRepository: MonthlyBudgetRepository) {

    fun getCurrentMonthlyBudget(): MonthlyBudget {
        val monthlyBudget = monthlyBudgetRepository.findByYearAndMonth(Year.currentYear(), Month.currentMonth())

        return monthlyBudget.orElseGet {
            val newMonthlyBudget = MonthlyBudget()
            monthlyBudgetRepository.createMonthlyBudget(newMonthlyBudget)
            newMonthlyBudget
        }
    }
}