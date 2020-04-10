package it.francescobianchi.familybudget.repository

import it.francescobianchi.familybudget.model.MonthlyBudget
import it.francescobianchi.familybudget.model.time.Month
import it.francescobianchi.familybudget.model.time.Year
import java.util.*

class InMemoryMonthlyBudgetRepository(
        private val repository: MutableSet<MonthlyBudget>
    ): MonthlyBudgetRepository {

    override fun createMonthlyBudget(monthlyBudget: MonthlyBudget) {
        repository.add(monthlyBudget)
    }

    override fun findAll(): Set<MonthlyBudget> {
        return repository
    }

    override fun findByYearAndMonth(year: Year, month: Month): Optional<MonthlyBudget> {
        return repository.stream().filter { it -> it.year == year && it.month == month }.findFirst()
    }
}