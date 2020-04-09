package it.francescobianchi.familybudget.usecase

import it.francescobianchi.familybudget.model.Month
import it.francescobianchi.familybudget.model.MonthlyBudget
import it.francescobianchi.familybudget.model.Year
import it.francescobianchi.familybudget.repository.MonthlyBudgetRepository

class CreateMonthlyBudgetUseCase(private val monthlyBudgetRepository: MonthlyBudgetRepository) {

    fun createNewMonthlyBudget(year: Year, month: Month) : MonthlyBudget {
        return monthlyBudgetRepository.createMonthlyBudget(year, month)
    }
}