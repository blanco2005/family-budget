package it.francescobianchi.familybudget.web.model

import com.fasterxml.jackson.annotation.JsonUnwrapped
import it.francescobianchi.familybudget.model.Money
import it.francescobianchi.familybudget.model.expense.Category
import it.francescobianchi.familybudget.model.time.Date

class ExpenseResponse(
        @JsonUnwrapped
        val category: Category,
        @JsonUnwrapped
        val money: Money,
        val description: String,
        @JsonUnwrapped
        val date: Date) {
}