package it.francescobianchi.familybudget.web.adapter

import it.francescobianchi.familybudget.model.MonthlyBudget
import it.francescobianchi.familybudget.web.model.MonthlyBudgetResponse

class MonthlyBudgetAdapter(val expenseAdapter: ExpenseAdapter) {

    fun responseFor(monthlyBudget: MonthlyBudget): MonthlyBudgetResponse  =
        MonthlyBudgetResponse(
                year = monthlyBudget.year.year,
                month = monthlyBudget.month.month,
                categories2budget = monthlyBudget.categories2budget.entries.associate {
                    it.key.name to it.value.toString()
                },
                expenses = monthlyBudget.expenses.map { expenseAdapter.responseFor(it) }
        )

}