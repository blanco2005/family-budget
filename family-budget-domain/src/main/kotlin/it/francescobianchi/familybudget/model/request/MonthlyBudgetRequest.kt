package it.francescobianchi.familybudget.model.request

import it.francescobianchi.familybudget.model.expense.Expense

data class MonthlyBudgetRequest (
        val year: String,
        val month: String,
        val categories2budget: Map<String, String>,
        val expenses: List<Expense>
)