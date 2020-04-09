package it.francescobianchi.familybudget.usecase

import it.francescobianchi.familybudget.model.MonthlyBudget
import it.francescobianchi.familybudget.repository.MonthlyBudgetRepository

class GetAllMonthlyBudgetUseCase(
        private val monthlyBudgetRepository: MonthlyBudgetRepository
) {
    fun getAllMonthlyBudgets(): Set<MonthlyBudget> {
        return monthlyBudgetRepository.findAll();
    }
}