package com.andalus.abo_med7at.analyticalgeometry.models.ellipse

import android.graphics.Canvas
import android.graphics.RectF
import android.view.View
import com.andalus.abo_med7at.analyticalgeometry.utils.ColorPicker
import com.andalus.abo_med7at.analyticalgeometry.utils.FormulaBuilder.Companion.freeTerm
import com.andalus.abo_med7at.analyticalgeometry.utils.FormulaBuilder.Companion.x
import com.andalus.abo_med7at.analyticalgeometry.utils.FormulaBuilder.Companion.xSquare
import com.andalus.abo_med7at.analyticalgeometry.utils.FormulaBuilder.Companion.y
import com.andalus.abo_med7at.analyticalgeometry.utils.FormulaBuilder.Companion.ySquare
import kotlin.math.pow
import kotlin.math.sqrt

class GeneralEllipse(val a: Double, val c: Double, val d: Double, val e: Double, val f: Double) : Ellipse() {
    override val formula: String
        get() = "${xSquare(a, isStarting = true)}${ySquare(c)}${x(d)}${y(e)}${freeTerm(f)} = 0".trim().removePrefix("+")

    override fun draw(canvas: Canvas, view: View) {
        if (canDraw()) {
            val denominator = -f + d.pow(2) / (4 * a) + e.pow(2) / (4 * c)
            val aStandard = sqrt(denominator / a)
            val bStandard = sqrt(denominator / c)
            val shiftX = -d / (2 * a)
            val shiftY = -e / (2 * c)

            val rectF = RectF(
                    (view.width / 2 - (aStandard - shiftX) * 20).toFloat(),
                    (view.height / 2 - (bStandard + shiftY) * 20).toFloat(),
                    (view.width / 2 + (aStandard + shiftX) * 20).toFloat(),
                    (view.height / 2 + (bStandard - shiftY) * 20).toFloat())

            canvas.drawOval(rectF, ColorPicker.pickDefault())

        }
    }

    override fun canDraw(): Boolean {
        if (d == 0.0 && e == 0.0 && f >= 0) return false
        if (a > 0 && c < 0 || a < 0 && c > 0) return false
        return true
    }

}