package it.francescobianchi.familybudget.model

import it.francescobianchi.familybudget.model.expense.Category
import it.francescobianchi.familybudget.model.expense.Expense
import it.francescobianchi.familybudget.model.time.Month
import it.francescobianchi.familybudget.model.time.Year

data class MonthlyBudget (
        val year: Year = Year.currentYear(),
        val month: Month = Month.currentMonth(),
        val categories2budget: Map<Category, Money> = defaultCategories(),
        val expenses: MutableList<Expense> = arrayListOf()) {

    companion object {
        fun defaultCategories(): HashMap<Category, Money> {
            return hashMapOf(
                    Category("Carburante") to Money.of("120"),
                    Category("Cene") to Money.of("200"),
                    Category("Spesa") to Money.of("200"),
                    Category("Casa") to Money.of("80"),
                    Category("Altro") to Money.of("150")
            )
        }
    }

}