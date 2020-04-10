package it.francescobianchi.familybudget.model

import it.francescobianchi.familybudget.model.expense.Category
import it.francescobianchi.familybudget.model.expense.Expense
import it.francescobianchi.familybudget.model.time.Month
import it.francescobianchi.familybudget.model.time.Year

data class MonthlyBudget (
        val year: Year,
        val month: Month,
        val categories2budget: Map<Category, Money>,
        val expenses: MutableList<Expense>) {

}