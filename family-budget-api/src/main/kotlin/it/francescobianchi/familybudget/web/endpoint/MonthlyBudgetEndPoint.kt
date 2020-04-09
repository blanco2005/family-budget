package it.francescobianchi.familybudget.web.endpoint

import it.francescobianchi.familybudget.model.MonthlyBudget
import it.francescobianchi.familybudget.model.request.MonthlyBudgetRequest
import it.francescobianchi.familybudget.usecase.CreateMonthlyBudgetUseCase
import it.francescobianchi.familybudget.usecase.GetAllMonthlyBudgetUseCase
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/monthlybudget")
class MonthlyBudgetEndPoint(
        private val createMonthlyBudgetUseCase: CreateMonthlyBudgetUseCase,
        private val getAllMonthlyBudgetUseCase: GetAllMonthlyBudgetUseCase
) {

    @PostMapping
    fun createMonthlyBudget(@RequestBody monthlyBudgetRequest: MonthlyBudgetRequest): ResponseEntity<Unit> {
        createMonthlyBudgetUseCase.createNewMonthlyBudget(monthlyBudgetRequest)
        return ResponseEntity.status(HttpStatus.OK).build()
    }

    @GetMapping
    fun getAllMonthlyBudget(): ResponseEntity<Set<MonthlyBudget>> {
        return ResponseEntity.ok(getAllMonthlyBudgetUseCase.getAllMonthlyBudgets())
    }

}