package com.andalus.abo_med7at.analyticalgeometry.models.circle

import android.graphics.Canvas
import android.view.View
import com.andalus.abo_med7at.analyticalgeometry.utils.ArithmeticUtils
import com.andalus.abo_med7at.analyticalgeometry.utils.ColorPicker
import com.andalus.abo_med7at.analyticalgeometry.utils.FormulaBuilder.Companion.freeTerm
import com.andalus.abo_med7at.analyticalgeometry.utils.FormulaBuilder.Companion.x
import com.andalus.abo_med7at.analyticalgeometry.utils.FormulaBuilder.Companion.xSquare
import com.andalus.abo_med7at.analyticalgeometry.utils.FormulaBuilder.Companion.y
import com.andalus.abo_med7at.analyticalgeometry.utils.FormulaBuilder.Companion.ySquare
import kotlin.math.sqrt

class GeneralCircle(val a: Double, val b: Double, private val g: Double, val f: Double, val c: Double) : Circle() {

    override val formula: String
        get() = "${xSquare(a, isStarting = true)}${ySquare(b)}${x(g)}${y(f)}${freeTerm(c)} = 0".trim().removePrefix("+")

    override fun draw(canvas: Canvas, view: View) {
        if (canDraw()) {
            val g = this.g / 2.0 / a
            val f = this.f / 2.0 / a
            val c = this.c / a

            val h = -g
            val k = -f
            val r = sqrt(g * g + f * f - c)

            canvas.drawCircle((view.width / 2 + h * 20).toFloat(),
                    ArithmeticUtils.invertY(k.toFloat(), view.height),
                    r.toFloat() * 20,
                    ColorPicker.pickDefault())

        }

    }

    override fun canDraw(): Boolean {
        if (a == 0.0) return false
        val g = this.g / 2.0 / a
        val f = this.f / 2.0 / a
        val c = this.c / a
        if (a == b && g * g + f * f - c >= 0.0) return true
        return false
    }
}