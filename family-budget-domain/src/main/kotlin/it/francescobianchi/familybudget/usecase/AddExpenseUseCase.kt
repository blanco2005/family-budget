package it.francescobianchi.familybudget.usecase

import it.francescobianchi.familybudget.model.Money
import it.francescobianchi.familybudget.model.MonthlyBudget
import it.francescobianchi.familybudget.model.expense.Category
import it.francescobianchi.familybudget.model.expense.Expense
import it.francescobianchi.familybudget.model.request.AddExpenseRequest
import it.francescobianchi.familybudget.model.time.Date
import it.francescobianchi.familybudget.model.time.Month
import it.francescobianchi.familybudget.model.time.Year
import it.francescobianchi.familybudget.repository.ExpenseRepository
import it.francescobianchi.familybudget.repository.MonthlyBudgetRepository

class AddExpenseUseCase(val monthlyBudgetRepository: MonthlyBudgetRepository, val expenseRepository: ExpenseRepository) {

    fun addExpense(addExpenseRequest: AddExpenseRequest) {
        val expense = Expense(
                Category(addExpenseRequest.category),
                Money.of(addExpenseRequest.money),
                addExpenseRequest.description,
                Date.today()
        )

        val monthlyBudget = monthlyBudgetRepository.findByYearAndMonth(Year.currentYear(), Month.currentMonth())

        monthlyBudget.ifPresentOrElse(
                { monthlyBudget -> monthlyBudget.expenses.add(expense) },
                { monthlyBudgetRepository.createMonthlyBudget(MonthlyBudget(expenses =  arrayListOf(expense))) }
        )

        expenseRepository.createExpense(expense)
    }
}