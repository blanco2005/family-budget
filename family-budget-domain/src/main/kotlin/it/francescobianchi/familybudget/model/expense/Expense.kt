package it.francescobianchi.familybudget.model.expense

import it.francescobianchi.familybudget.model.Money
import it.francescobianchi.familybudget.model.time.Date

data class Expense(
        val category: Category,
        val money: Money,
        val description: String,
        val date: Date)