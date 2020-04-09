package it.francescobianchi.familybudget.model.expense

import it.francescobianchi.familybudget.model.Money

data class Expense(
        val category: Category,
        val money: Money,
        val description: String)