package it.francescobianchi.familybudget.usecase

import it.francescobianchi.familybudget.model.Month
import it.francescobianchi.familybudget.model.MonthlyBudget
import it.francescobianchi.familybudget.model.Year
import it.francescobianchi.familybudget.repository.MonthlyBudgetRepository
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class GetAllMonthlyBudgetUseCaseTest {

    @Mock
    private lateinit var monthlyBudgetRepository: MonthlyBudgetRepository;
    private lateinit var getAllMonthlyBudgetUseCase: GetAllMonthlyBudgetUseCase

    @Before
    fun setUp() {
        getAllMonthlyBudgetUseCase = GetAllMonthlyBudgetUseCase(monthlyBudgetRepository)
    }

    @Test
    fun `get all monthly budgets happy path`() {
        `when`(monthlyBudgetRepository.findAll())
                .thenReturn(setOf(
                        MonthlyBudget(Year("2020"), Month.JANUARY),
                        MonthlyBudget(Year("2020"), Month.FEBRUARY)
                ))

        val result = getAllMonthlyBudgetUseCase.getAllMonthlyBudgets()

        assertThat(result, `is`(setOf(
                MonthlyBudget(Year("2020"), Month.JANUARY),
                MonthlyBudget(Year("2020"), Month.FEBRUARY)
        )))

        verify(monthlyBudgetRepository).findAll()
    }
}