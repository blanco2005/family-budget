package it.francescobianchi.familybudget.usecase

import it.francescobianchi.familybudget.model.Month.JANUARY
import it.francescobianchi.familybudget.model.MonthlyBudget
import it.francescobianchi.familybudget.model.Year
import it.francescobianchi.familybudget.model.request.MonthlyBudgetRequest
import it.francescobianchi.familybudget.repository.MonthlyBudgetRepository
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class CreateMonthlyBudgetUseCaseTest {

    @Mock
    private lateinit var monthlyBudgetRepository: MonthlyBudgetRepository;
    private lateinit var createMonthlyBudgetUseCase: CreateMonthlyBudgetUseCase

    @Before
    fun setUp() {
        createMonthlyBudgetUseCase = CreateMonthlyBudgetUseCase(monthlyBudgetRepository);
    }

    @Test
    fun `create monthly budget happy path`() {
        createMonthlyBudgetUseCase.createNewMonthlyBudget(MonthlyBudgetRequest("january", "2020"))
        verify(monthlyBudgetRepository).createMonthlyBudget(MonthlyBudget(Year("2020"), JANUARY))
    }
}