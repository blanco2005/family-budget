package it.francescobianchi.familybudget.web.model

class MonthlyBudgetResponse (
        val year: Int,
        val month: Int,
        val categories2budget: List<CategoryToBudget>,
        val expenses: List<ExpenseResponse>

)

class CategoryToBudget(val name: String, val money: String)