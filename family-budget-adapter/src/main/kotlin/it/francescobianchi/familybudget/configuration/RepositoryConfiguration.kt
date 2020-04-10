package it.francescobianchi.familybudget.configuration

import it.francescobianchi.familybudget.repository.InMemoryExpenseRepository
import it.francescobianchi.familybudget.repository.InMemoryMonthlyBudgetRepository
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class RepositoryConfiguration {

    @Bean
    fun inMemoryMonthlyBudgetRepository() = InMemoryMonthlyBudgetRepository(HashSet())

    @Bean
    fun inMemoryExpenseRepository() = InMemoryExpenseRepository(ArrayList())
}