package it.francescobianchi.familybudget.usecase

import it.francescobianchi.familybudget.model.Money
import it.francescobianchi.familybudget.model.MonthlyBudget
import it.francescobianchi.familybudget.model.expense.Category
import it.francescobianchi.familybudget.model.time.Year
import it.francescobianchi.familybudget.model.request.MonthlyBudgetRequest
import it.francescobianchi.familybudget.model.time.Month
import it.francescobianchi.familybudget.repository.MonthlyBudgetRepository

class CreateMonthlyBudgetUseCase(private val monthlyBudgetRepository: MonthlyBudgetRepository) {

    fun createNewMonthlyBudget(request: MonthlyBudgetRequest) {
        monthlyBudgetRepository.createMonthlyBudget(
                MonthlyBudget(
                        year = Year.of(request.year.toInt()),
                        month = Month.of(request.month),
                        categories2budget =  request.categories2budget.entries.associate{
                            Category(it.key) to Money.of(it.value)
                        },
                        expenses = ArrayList(request.expenses)
                )
        )
    }
}