package it.francescobianchi.familybudget.web.endpoint

import it.francescobianchi.familybudget.model.request.AddExpenseRequest
import it.francescobianchi.familybudget.usecase.AddExpenseUseCase
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/expenses")
class ExpenseEndPoint(val addExpenseUseCase: AddExpenseUseCase) {

    @PostMapping
    fun createNewExpense(@RequestBody request: AddExpenseRequest): ResponseEntity<Unit> {
        addExpenseUseCase.addExpense(request)
        return ResponseEntity.status(HttpStatus.OK).build()
    }
}