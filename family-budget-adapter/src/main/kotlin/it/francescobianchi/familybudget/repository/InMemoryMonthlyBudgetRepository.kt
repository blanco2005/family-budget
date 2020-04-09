package it.francescobianchi.familybudget.repository

import it.francescobianchi.familybudget.model.MonthlyBudget

class InMemoryMonthlyBudgetRepository(
        private val repository: MutableSet<MonthlyBudget>
    ): MonthlyBudgetRepository {

    override fun createMonthlyBudget(monthlyBudget: MonthlyBudget) {
        repository.add(monthlyBudget)
    }

    override fun findAll(): Set<MonthlyBudget> {
        return repository
    }
}