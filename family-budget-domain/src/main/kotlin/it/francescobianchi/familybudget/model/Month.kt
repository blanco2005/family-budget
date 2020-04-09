package it.francescobianchi.familybudget.model

enum class Month(val month: String, val numberOfDays: Int) {
    JANUARY("january", 31),
    FEBRUARY("february", 28),
    MARCH("march", 31),
    APRIL("april", 30),
    MAY("may", 31),
    JUNE("june", 30),
    JULY("july", 31),
    AUGUST("august", 31),
    SEPTEMBER("september", 30),
    OCTOBER("october", 31),
    NOVEMBER("november", 30),
    DECEMBER("december",31)
}