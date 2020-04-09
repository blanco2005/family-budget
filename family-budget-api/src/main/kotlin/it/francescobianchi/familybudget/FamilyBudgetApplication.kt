package it.francescobianchi.familybudget

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class FamilyBudgetApplication

fun main(args: Array<String>) {
    runApplication<FamilyBudgetApplication>(*args)
}