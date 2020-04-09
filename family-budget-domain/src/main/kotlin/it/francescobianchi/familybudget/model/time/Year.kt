package it.francescobianchi.familybudget.model.time

import java.time.LocalDate

data class Year private constructor(val year: Int) {

    companion object {
        fun of(year: Int) = Year(year)
        fun currentYear() = Year(LocalDate.now().year)
    }
}