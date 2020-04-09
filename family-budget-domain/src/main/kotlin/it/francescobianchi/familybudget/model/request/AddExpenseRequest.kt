package it.francescobianchi.familybudget.model.request

import it.francescobianchi.familybudget.model.Money
import it.francescobianchi.familybudget.model.expense.Category

data class AddExpenseRequest(
        val category: Category,
        val money: Money,
        val description: String
)
