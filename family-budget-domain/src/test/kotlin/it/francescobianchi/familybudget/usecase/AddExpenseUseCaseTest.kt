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
import org.hamcrest.CoreMatchers.*
import org.hamcrest.MatcherAssert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner
import java.util.*

@RunWith(MockitoJUnitRunner::class)
class AddExpenseUseCaseTest {

    @Mock
    private lateinit var monthlyBudgetRepository: MonthlyBudgetRepository
    @Mock
    private lateinit var expenseRepository: ExpenseRepository

    private lateinit var addExpenseUseCase: AddExpenseUseCase

    @Before
    fun setUp() {
        addExpenseUseCase = AddExpenseUseCase(monthlyBudgetRepository, expenseRepository)
    }

    @Test
    fun `create new expense when mounthly budget already exists`() {

        val monthlyBudgetToUpdate = MonthlyBudget(Year.currentYear(), Month.currentMonth(), emptyMap(), arrayListOf())
        val expectedExpense = Expense(Category("Dinner"), Money.of("95.66"), "desc", Date.today())

        `when`(monthlyBudgetRepository.findByYearAndMonth(Year.currentYear(), Month.currentMonth()))
                .thenReturn(Optional.of(monthlyBudgetToUpdate))

        addExpenseUseCase.addExpense(
                AddExpenseRequest("Dinner", "95.66", "desc")
        )

        assertThat(monthlyBudgetToUpdate.expenses, hasItem(expectedExpense))

        verify(expenseRepository).createExpense(expectedExpense)
        verify(monthlyBudgetRepository).findByYearAndMonth(Year.currentYear(), Month.currentMonth())
    }

    @Test
    fun `create new expense when mounthly budget does not exist`() {
        val expectedExpense = Expense(Category("Dinner"), Money.of("95.66"), "desc", Date.today())
        val newMonthlyBudgetToUpdate = MonthlyBudget(Year.currentYear(), Month.currentMonth(), emptyMap(), arrayListOf(expectedExpense))

        `when`(monthlyBudgetRepository.findByYearAndMonth(Year.currentYear(), Month.currentMonth()))
                .thenReturn(Optional.empty())

        addExpenseUseCase.addExpense(AddExpenseRequest("Dinner", "95.66", "desc"))

        verify(expenseRepository).createExpense(expectedExpense)
        verify(monthlyBudgetRepository).findByYearAndMonth(Year.currentYear(), Month.currentMonth())
        verify(monthlyBudgetRepository).createMonthlyBudget(newMonthlyBudgetToUpdate)
    }
}