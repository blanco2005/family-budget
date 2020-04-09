package it.francescobianchi.familybudget.model

import it.francescobianchi.familybudget.model.time.Month
import it.francescobianchi.familybudget.model.time.Year

data class MonthlyBudget (
        val year: Year,
        val month: Month,
        val budget: Money) {

}