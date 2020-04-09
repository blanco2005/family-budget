package it.francescobianchi.familybudget.model.time

class NotAValidMonthException: RuntimeException("The given string does not map a valid month!") {
}