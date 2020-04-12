package it.francescobianchi.familybudget.model

import java.math.BigDecimal
import java.math.RoundingMode

data class Money(val amount: BigDecimal) {

    companion object {
        fun of(amount: String) = Money(BigDecimal(amount).setScale(2, RoundingMode.DOWN))
    }

    override fun toString() = amount.toString()
}