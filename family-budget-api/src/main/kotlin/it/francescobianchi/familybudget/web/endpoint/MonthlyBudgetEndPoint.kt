package it.francescobianchi.familybudget.web.endpoint

import it.francescobianchi.familybudget.model.MonthlyBudget
import it.francescobianchi.familybudget.model.request.MonthlyBudgetRequest
import it.francescobianchi.familybudget.usecase.CreateMonthlyBudgetUseCase
import it.francescobianchi.familybudget.usecase.GetAllMonthlyBudgetUseCase
import it.francescobianchi.familybudget.usecase.GetCurrentMonthlyBudgetUseCase
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/monthlybudget")
class MonthlyBudgetEndPoint(
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
    fun getAllMonthlyBudget(): ResponseEntity<Set<MonthlyBudget>> {
        return ResponseEntity.ok(getAllMonthlyBudgetUseCase.getAllMonthlyBudgets())
    }

    @GetMapping("/current")
    fun getCurrentMonthlyBudget(): ResponseEntity<MonthlyBudget> {
        return ResponseEntity.ok(getCurrentMonthlyBudgetUseCase.getCurrentMonthlyBudget())
    }



}