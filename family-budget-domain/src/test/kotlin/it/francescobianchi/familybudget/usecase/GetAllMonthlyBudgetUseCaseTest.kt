package it.francescobianchi.familybudget.usecase

import it.francescobianchi.familybudget.model.MonthlyBudget
import it.francescobianchi.familybudget.model.time.Month
import it.francescobianchi.familybudget.model.time.Year
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
                        MonthlyBudget(Year.of(2020), Month.of(1), emptyMap(), arrayListOf()),
                        MonthlyBudget(Year.of(2020), Month.of(2), emptyMap(), arrayListOf())
                ))

        val result = getAllMonthlyBudgetUseCase.getAllMonthlyBudgets()

        assertThat(result, `is`(setOf(
                MonthlyBudget(Year.of(2020), Month.of(1), emptyMap(), arrayListOf()),
                MonthlyBudget(Year.of(2020), Month.of(2), emptyMap(), arrayListOf())
        )))

        verify(monthlyBudgetRepository).findAll()
    }
}