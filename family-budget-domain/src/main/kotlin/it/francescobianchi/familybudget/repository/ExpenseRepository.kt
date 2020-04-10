package it.francescobianchi.familybudget.repository

import it.francescobianchi.familybudget.model.expense.Expense

interface ExpenseRepository {

    fun createExpense(expense: Expense)
}