package it.francescobianchi.familybudget.web.configuration

import it.francescobianchi.familybudget.web.adapter.ExpenseAdapter
import it.francescobianchi.familybudget.web.adapter.MonthlyBudgetAdapter
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class AdapterConfiguration {

    @Bean
    fun monthlyBudgetAdapter() = MonthlyBudgetAdapter(expenseAdapter())

    @Bean
    fun expenseAdapter() = ExpenseAdapter()
}