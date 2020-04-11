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
import java.util.*

@RunWith(MockitoJUnitRunner::class)
class GetCurrentMonthlyBudgetUseCaseTest {

    @Mock
    private lateinit var monthlyBudgetRepository: MonthlyBudgetRepository;
    private lateinit var getCurrentMonthlyBudgetUseCase: GetCurrentMonthlyBudgetUseCase

    @Before
    fun setUp() {
        getCurrentMonthlyBudgetUseCase = GetCurrentMonthlyBudgetUseCase(monthlyBudgetRepository)
    }

    @Test
    fun `get current monthly budget when already exists`() {
        val expectedResult = MonthlyBudget(Year.currentYear(), Month.currentMonth(), emptyMap(), arrayListOf())

        `when`(monthlyBudgetRepository.findByYearAndMonth(Year.currentYear(), Month.currentMonth()))
                .thenReturn(Optional.of(expectedResult))

        val result = getCurrentMonthlyBudgetUseCase.getCurrentMonthlyBudget()

        assertThat(result, `is`(expectedResult))
        verify(monthlyBudgetRepository).findByYearAndMonth(Year.currentYear(), Month.currentMonth())
    }

    @Test
    fun `get current monthly budget when deos not exist`() {
        val expectedResult = MonthlyBudget(Year.currentYear(), Month.currentMonth(), emptyMap(), arrayListOf())

        `when`(monthlyBudgetRepository.findByYearAndMonth(Year.currentYear(), Month.currentMonth()))
                .thenReturn(Optional.empty())

        val result = getCurrentMonthlyBudgetUseCase.getCurrentMonthlyBudget()

        assertThat(result, `is`(expectedResult))
        verify(monthlyBudgetRepository).findByYearAndMonth(Year.currentYear(), Month.currentMonth())
        verify(monthlyBudgetRepository).createMonthlyBudget(MonthlyBudget())
    }
}