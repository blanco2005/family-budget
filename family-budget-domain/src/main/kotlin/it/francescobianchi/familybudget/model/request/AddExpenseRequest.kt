package it.francescobianchi.familybudget.model.request

import it.francescobianchi.familybudget.model.time.Date

data class AddExpenseRequest(
        val category: String,
        val money: String,
        val description: String,
        val date: Date = Date.today()
)
