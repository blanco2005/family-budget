package it.francescobianchi.familybudget.web.endpoint

import it.francescobianchi.familybudget.model.request.MonthlyBudgetRequest
import it.francescobianchi.familybudget.usecase.CreateMonthlyBudgetUseCase
import it.francescobianchi.familybudget.usecase.GetAllMonthlyBudgetUseCase
import it.francescobianchi.familybudget.usecase.GetCurrentMonthlyBudgetUseCase
import it.francescobianchi.familybudget.web.adapter.MonthlyBudgetAdapter
import it.francescobianchi.familybudget.web.model.MonthlyBudgetResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/monthlybudget")
class MonthlyBudgetEndPoint(
        private val monthlyBudgetAdapter: MonthlyBudgetAdapter,
        private val createMonthlyBudgetUseCase: CreateMonthlyBudgetUseCase,
        private val getAllMonthlyBudgetUseCase: GetAllMonthlyBudgetUseCase,
        private val getCurrentMonthlyBudgetUseCase: GetCurrentMonthlyBudgetUseCase
) {

    @PostMapping
    fun createMonthlyBudget(@RequestBody monthlyBudgetRequest: MonthlyBudgetRequest): ResponseEntity<Unit> {
        createMonthlyBudgetUseCase.createNewMonthlyBudget(monthlyBudgetRequest)
        return ResponseEntity.status(HttpStatus.OK).build()
    }

    @GetMapping("/all")
    fun getAllMonthlyBudget(): ResponseEntity<Set<MonthlyBudgetResponse>> {
        val result = getAllMonthlyBudgetUseCase.getAllMonthlyBudgets()
                .map { monthlyBudgetAdapter.responseFor(it) }
                .toCollection(hashSetOf())
        return ResponseEntity.ok(result)
    }

    @GetMapping("/current")
    fun getCurrentMonthlyBudget(): ResponseEntity<MonthlyBudgetResponse> {
        val result = monthlyBudgetAdapter.responseFor(getCurrentMonthlyBudgetUseCase.getCurrentMonthlyBudget())
        return ResponseEntity.ok(result)
    }
}