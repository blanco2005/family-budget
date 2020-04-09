package it.francescobianchi.familybudget.repository

import it.francescobianchi.familybudget.model.MonthlyBudget

interface MonthlyBudgetRepository {

    fun createMonthlyBudget(monthlyBudget: MonthlyBudget)
    fun findAll(): Set<MonthlyBudget>
}