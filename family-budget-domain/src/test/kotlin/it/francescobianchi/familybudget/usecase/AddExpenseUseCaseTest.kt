package it.francescobianchi.familybudget.usecase

import it.francescobianchi.familybudget.model.Money
import it.francescobianchi.familybudget.model.MonthlyBudget
import it.francescobianchi.familybudget.model.expense.Category
import it.francescobianchi.familybudget.model.request.AddExpenseRequest
import it.francescobianchi.familybudget.model.request.MonthlyBudgetRequest
import it.francescobianchi.familybudget.model.time.Month
import it.francescobianchi.familybudget.model.time.Year
import it.francescobianchi.familybudget.repository.MonthlyBudgetRepository
import org.junit.Before
import org.junit.Ignore
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.*

class AddExpenseUseCaseTest {

    @Mock
    private lateinit var monthlyBudgetRepository: MonthlyBudgetRepository;
    private lateinit var addExpenseUseCase: AddExpenseUseCase

    @Before
    fun setUp() {

    }

    @Test
    @Ignore
    fun `create monthly budget happy path`() {

        addExpenseUseCase.addExpense(
                AddExpenseRequest(Category("Dinner"), Money.of("95.66"), "ristorante")
        )

        verify(monthlyBudgetRepository).createMonthlyBudget(MonthlyBudget(Year.currentYear(), Month.of(1), Money.of("100.000")))
    }
}