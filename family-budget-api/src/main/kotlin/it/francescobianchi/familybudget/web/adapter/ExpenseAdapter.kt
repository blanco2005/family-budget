package it.francescobianchi.familybudget.web.adapter

import it.francescobianchi.familybudget.model.expense.Expense
import it.francescobianchi.familybudget.web.model.ExpenseResponse

class ExpenseAdapter {

    fun responseFor(expense: Expense) = ExpenseResponse(
            category = expense.category,
            money = expense.money,
            description = expense.description,
            date = expense.date
    )
}