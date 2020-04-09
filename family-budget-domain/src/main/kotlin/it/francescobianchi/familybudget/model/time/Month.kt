package it.francescobianchi.familybudget.model.time

class Month private constructor(month: Int) {

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
            "january" -> JANUARY
            "february" -> FEBRUARY
            "march" -> MARCH
            "april" -> APRIL
            "may" -> MAY
            "june" -> JUNE
            "july" -> JULY
            "august" -> AUGUST
            "september" -> SEPTEMBER
            "october" -> OCTOBER
            "november" -> NOVEMBER
            "december" -> DECEMBER
            else -> throw NotAValidMonthException()
        }
    }

}