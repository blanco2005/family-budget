package it.francescobianchi.familybudget.repository

import it.francescobianchi.familybudget.model.MonthlyBudget
import it.francescobianchi.familybudget.model.time.Month
import it.francescobianchi.familybudget.model.time.Year
import java.util.*

interface MonthlyBudgetRepository {

    fun createMonthlyBudget(monthlyBudget: MonthlyBudget)
    fun findAll(): Set<MonthlyBudget>
    fun findByYearAndMonth(year: Year, month: Month): Optional<MonthlyBudget>
}