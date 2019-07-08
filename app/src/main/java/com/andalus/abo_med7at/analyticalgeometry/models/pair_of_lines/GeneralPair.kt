package com.andalus.abo_med7at.analyticalgeometry.models.pair_of_lines

import android.graphics.Canvas
import android.view.View
import com.andalus.abo_med7at.analyticalgeometry.utils.ArithmeticUtils.Companion.invertY
import com.andalus.abo_med7at.analyticalgeometry.utils.ColorPicker
import com.andalus.abo_med7at.analyticalgeometry.utils.FormulaBuilder.Companion.freeTerm
import com.andalus.abo_med7at.analyticalgeometry.utils.FormulaBuilder.Companion.x
import com.andalus.abo_med7at.analyticalgeometry.utils.FormulaBuilder.Companion.xSquare
import com.andalus.abo_med7at.analyticalgeometry.utils.FormulaBuilder.Companion.xy
import com.andalus.abo_med7at.analyticalgeometry.utils.FormulaBuilder.Companion.y
import com.andalus.abo_med7at.analyticalgeometry.utils.FormulaBuilder.Companion.ySquare
import kotlin.math.sqrt

class GeneralPair(val a: Double, val h: Double, val b: Double, val g: Double, val f: Double, val c: Double) : PairOfLines() {
    override val formula: String
        get() = "${xSquare(a)}${xy(h)}${ySquare(b)}${x(g)}${y(f)}${freeTerm(c)} = 0".trim().removePrefix("+")

    override fun draw(canvas: Canvas, view: View) {
        if (canDraw()) {
            val h = this.h / 2.0
            val g = this.g / 2.0
            val f = this.f / 2.0

            var xCoordinate: Float
            var yCoordinate: Float

            run {
                var i = (-view.height).toFloat()
                while (i < view.height) {
                    yCoordinate = i
                    xCoordinate = ((-(2.0 * h * i.toDouble() + 2.0 * g) + sqrt((2.0 * h * i.toDouble() + 2.0 * g) * (2.0 * h * i.toDouble() + 2.0 * g) - 4.0 * a * (b * i.toDouble() * i.toDouble() + 2.0 * f * i.toDouble() + c))) / (2.0 * a)).toFloat()
                    canvas.drawPoint(xCoordinate * 20 + view.width / 2f,
                            invertY(yCoordinate, view.height),
                            ColorPicker.pickDefault())
                    i += 0.05f
                }
            }
            var i = (-view.height).toFloat()
            while (i < view.height) {
                yCoordinate = i
                xCoordinate = ((-(2.0 * h * i.toDouble() + 2.0 * g) - sqrt((2.0 * h * i.toDouble() + 2.0 * g) * (2.0 * h * i.toDouble() + 2.0 * g) - 4.0 * a * (b * i.toDouble() * i.toDouble() + 2.0 * f * i.toDouble() + c))) / (2.0 * a)).toFloat()
                canvas.drawPoint(xCoordinate * 20 + view.width / 2f,
                        invertY(yCoordinate, view.height),
                        ColorPicker.pickDefault())
                i += 0.05f
            }
        }

    }

    override fun canDraw(): Boolean {
        val h = this.h / 2.0
        val g = this.g / 2.0
        val f = this.f / 2.0
        if (h * h - a * b >= 0 && a * b * c + 2.0 * f * g * h - a * f * f - b * g * g - c * h * h == 0.0)
            if (a != 0.0 && b != 0.0) return true
        return false
    }
}