package com.andalus.abo_med7at.analyticalgeometry.utils

import kotlin.math.ceil
import kotlin.math.floor

class FormulaBuilder {

    companion object {

        private fun formatEqnTerm(n: Double, c: String, isStarting: Boolean): String {
            if (n == 0.0) return ""
            if (n == 1.0 && !isStarting) return " +$c"
            if (n == 1.0 && isStarting) return c
            if (n == -1.0) return " -$c"

            if (n.isInt()) {
                return if (n > 0) {
                    if (!isStarting) {
                        " +${n.toInt()}$c"
                    } else {
                        "${n.toInt()}$c"
                    }
                } else {
                    " ${n.toInt()}$c"
                }
            } else {
                return if (n > 0) {
                    if (!isStarting) {
                        " +$n$c"
                    } else {
                        "$n$c"
                    }
                } else {
                    " $n$c"
                }
            }
        }

        private fun Double.isInt(): Boolean {
            return ceil(this) == floor(this)
        }

        fun number(n: Double, canBeZero: Boolean = true, isInverse: Boolean = false, hasSign: Boolean = false, canBeOne: Boolean = true): String {
            if (!canBeZero) if (n == 0.0) return ""
            if (!canBeOne) if (n == 1.0) return "" else if (n == -1.0) return "-"
            var num = n
            var sign = ""
            if (isInverse) num *= -1

            val number = if (num.isInt())
                "${num.toInt()}"
            else
                "$num"

            if (hasSign && num > 0) sign = "+"

            return "$sign$number"
        }

        fun x(n: Double, isStarting: Boolean = false): String {
            return formatEqnTerm(n, "x", isStarting)
        }

        fun y(n: Double, isStarting: Boolean = false): String {
            return formatEqnTerm(n, "y", isStarting)
        }

        fun xSquare(n: Double, isStarting: Boolean = false): String {
            return formatEqnTerm(n, "x^2", isStarting)
        }

        fun ySquare(n: Double, isStarting: Boolean = false): String {
            return formatEqnTerm(n, "y^2", isStarting)
        }

        fun xy(n: Double, isStarting: Boolean = false): String {
            return formatEqnTerm(n, "xy", isStarting)
        }

        fun freeTerm(n: Double, isStarting: Boolean = false): String {
            return formatEqnTerm(n, "", isStarting)
        }

    }

}