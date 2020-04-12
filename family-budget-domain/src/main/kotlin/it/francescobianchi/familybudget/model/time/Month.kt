package it.francescobianchi.familybudget.model.time

import java.time.LocalDate

data class Month private constructor(val month: Int) {

    companion object {

        private val JANUARY = Month(1)
        private val FEBRUARY = Month(2)
        private val MARCH = Month(3)
        private val APRIL = Month(4)
        private val MAY = Month(5)
        private val JUNE = Month(6)
        private val JULY = Month(7)
        private val AUGUST = Month(8)
        private val SEPTEMBER = Month(9)
        private val OCTOBER = Month(10)
        private val NOVEMBER = Month(11)
        private val DECEMBER = Month(12)

        fun of(month: Int) = Month(month);

        fun of(month: String) = when(month.toLowerCase()) {
            "january", "01" -> JANUARY
            "february", "02" -> FEBRUARY
            "march", "03" -> MARCH
            "april", "04" -> APRIL
            "may", "05" -> MAY
            "june", "06" -> JUNE
            "july", "07" -> JULY
            "august", "08" -> AUGUST
            "september", "09" -> SEPTEMBER
            "october", "10" -> OCTOBER
            "november", "11" -> NOVEMBER
            "december", "12" -> DECEMBER
            else -> throw InvalidMonthException()
        }

        fun currentMonth() = Month(LocalDate.now().monthValue)
    }
}