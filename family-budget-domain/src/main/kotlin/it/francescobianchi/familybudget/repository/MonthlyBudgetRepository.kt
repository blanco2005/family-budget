package it.francescobianchi.familybudget.repository

import it.francescobianchi.familybudget.model.Month
import it.francescobianchi.familybudget.model.MonthlyBudget
import it.francescobianchi.familybudget.model.Year

interface MonthlyBudgetRepository {

    fun createMonthlyBudget(year: Year, month: Month): MonthlyBudget
}