package it.francescobianchi.familybudget.web.configuration

import it.francescobianchi.familybudget.repository.ExpenseRepository
import it.francescobianchi.familybudget.repository.InMemoryExpenseRepository
import it.francescobianchi.familybudget.repository.MonthlyBudgetRepository
import it.francescobianchi.familybudget.usecase.AddExpenseUseCase
import it.francescobianchi.familybudget.usecase.CreateMonthlyBudgetUseCase
import it.francescobianchi.familybudget.usecase.GetAllMonthlyBudgetUseCase
import it.francescobianchi.familybudget.usecase.GetCurrentMonthlyBudgetUseCase
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class UseCaseConfiguration {

    @Bean
    fun createMonthlyBudgetUseCase(monthlyBudgetRepository: MonthlyBudgetRepository): CreateMonthlyBudgetUseCase {
        return CreateMonthlyBudgetUseCase(monthlyBudgetRepository)
    }

    @Bean
    fun getAllMonthlyBudgetUseCase(monthlyBudgetRepository: MonthlyBudgetRepository): GetAllMonthlyBudgetUseCase {
        return GetAllMonthlyBudgetUseCase(monthlyBudgetRepository)
    }

    @Bean
    fun getCurrentMonthlyBudgetUseCase(monthlyBudgetRepository: MonthlyBudgetRepository): GetCurrentMonthlyBudgetUseCase {
        return GetCurrentMonthlyBudgetUseCase(monthlyBudgetRepository)
    }

    @Bean
    fun addExpenseUseCase(monthlyBudgetRepository: MonthlyBudgetRepository, expenseRepository: ExpenseRepository): AddExpenseUseCase {
        return AddExpenseUseCase(monthlyBudgetRepository, expenseRepository)
    }
}