package it.francescobianchi.familybudget.model

import it.francescobianchi.familybudget.model.expense.Category
import it.francescobianchi.familybudget.model.expense.Expense
import it.francescobianchi.familybudget.model.time.Month
import it.francescobianchi.familybudget.model.time.Year

data class MonthlyBudget (
        val year: Year = Year.currentYear(),
        val month: Month = Month.currentMonth(),
        val categories2budget: Map<Category, Money> = hashMapOf(),
        val expenses: MutableList<Expense> = arrayListOf()) {

}