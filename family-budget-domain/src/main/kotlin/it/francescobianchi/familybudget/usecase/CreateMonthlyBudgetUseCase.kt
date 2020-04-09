package it.francescobianchi.familybudget.usecase

import it.francescobianchi.familybudget.model.Month
import it.francescobianchi.familybudget.model.MonthlyBudget
import it.francescobianchi.familybudget.model.Year
import it.francescobianchi.familybudget.model.request.MonthlyBudgetRequest
import it.francescobianchi.familybudget.repository.MonthlyBudgetRepository

class CreateMonthlyBudgetUseCase(private val monthlyBudgetRepository: MonthlyBudgetRepository) {

    fun createNewMonthlyBudget(request: MonthlyBudgetRequest) {
        monthlyBudgetRepository.createMonthlyBudget(
                MonthlyBudget(
                        year = Year(request.year),
                        month = Month.valueOf(request.month.toUpperCase())
                )
        )
    }
}