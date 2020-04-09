package it.francescobianchi.familybudget.web.configuration

import it.francescobianchi.familybudget.repository.MonthlyBudgetRepository
import it.francescobianchi.familybudget.usecase.CreateMonthlyBudgetUseCase
import it.francescobianchi.familybudget.usecase.GetAllMonthlyBudgetUseCase
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
}