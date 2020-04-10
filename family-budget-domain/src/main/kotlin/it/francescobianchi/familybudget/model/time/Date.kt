package it.francescobianchi.familybudget.model.time

import java.time.LocalDate
import java.time.format.DateTimeFormatter

data class Date(val localDate: LocalDate){

    companion object {
        val DEFAULT_DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy/mm/dd")

        fun of(date: String) = Date(LocalDate.parse(date, DEFAULT_DATE_TIME_FORMATTER))

        fun today() = Date(LocalDate.now())
    }

    fun month() = Month.of(localDate.monthValue)

    fun year() = Year.of(localDate.year)

    override fun toString() = DEFAULT_DATE_TIME_FORMATTER.format(localDate)

}