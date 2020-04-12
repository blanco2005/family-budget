package it.francescobianchi.familybudget.web.model

import it.francescobianchi.familybudget.model.expense.Expense

class MonthlyBudgetResponse (
        val year: Int,
        val month: Int,
        val categories2budget: Map<String, String>,
        val expenses: List<ExpenseResponse>
)