package it.francescobianchi.familybudget.usecase

import it.francescobianchi.familybudget.model.Month.JANUARY
import it.francescobianchi.familybudget.model.MonthlyBudget
import it.francescobianchi.familybudget.model.Year
import it.francescobianchi.familybudget.repository.MonthlyBudgetRepository
import org.hamcrest.Matchers.`is`
import org.junit.Assert
import org.junit.Assert.assertThat
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.BDDMockito
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
        BDDMockito.given(monthlyBudgetRepository.createMonthlyBudget(Year("2020"), JANUARY))
                .willReturn(MonthlyBudget(JANUARY, Year("2020")))

        val createdMonthlyBudget = createMonthlyBudgetUseCase.createNewMonthlyBudget(Year("2020"), JANUARY)

        assertThat(createdMonthlyBudget, `is`(MonthlyBudget(JANUARY, Year("2020"))))

        verify(monthlyBudgetRepository).createMonthlyBudget(Year("2020"), JANUARY)
    }
}