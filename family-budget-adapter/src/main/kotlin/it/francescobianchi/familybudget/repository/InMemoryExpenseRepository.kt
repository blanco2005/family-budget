package it.francescobianchi.familybudget.repository

import it.francescobianchi.familybudget.model.expense.Expense

class InMemoryExpenseRepository(
        private val repository: MutableList<Expense>
    ): ExpenseRepository {

}