package com.andalus.abo_med7at.analyticalgeometry.models.hyperbola

import android.graphics.Canvas
import android.view.View
import com.andalus.abo_med7at.analyticalgeometry.utils.ArithmeticUtils.Companion.invertY
import com.andalus.abo_med7at.analyticalgeometry.utils.ColorPicker
import com.andalus.abo_med7at.analyticalgeometry.utils.FormulaBuilder.Companion.freeTerm
import com.andalus.abo_med7at.analyticalgeometry.utils.FormulaBuilder.Companion.x
import com.andalus.abo_med7at.analyticalgeometry.utils.FormulaBuilder.Companion.xSquare
import com.andalus.abo_med7at.analyticalgeometry.utils.FormulaBuilder.Companion.y
import com.andalus.abo_med7at.analyticalgeometry.utils.FormulaBuilder.Companion.ySquare
import kotlin.math.sqrt

class GeneralHyperbola(val a: Double, val b: Double, val d: Double, val e: Double, val f: Double) : Hyperbola() {
    override val formula: String
        get() = "${xSquare(a, isStarting = true)}${ySquare(b)}${x(d)}${y(e)}${freeTerm(f)} = 0".trim().removePrefix("+")

    override fun draw(canvas: Canvas, view: View) {
        if (canDraw()) {
            var xCoordinate: Float
            var yCoordinate: Float

            run {
                var i = (-view.height).toFloat()
                while (i < view.height) {
                    yCoordinate = i
                    xCoordinate = ((-d - sqrt(d * d - 4.0 * a * (b * yCoordinate.toDouble() * yCoordinate.toDouble() + e * yCoordinate + f))) / (2 * a)).toFloat()
                    if (!xCoordinate.isNaN())
                        canvas.drawPoint(xCoordinate * 20 + view.width / 2f,
                                invertY(yCoordinate, view.height),
                                ColorPicker.pickDefault())
                    i += 0.05f
                }
            }
            var i = (-view.height).toFloat()
            while (i < view.height) {
                yCoordinate = i
                xCoordinate = ((-d + sqrt(d * d - 4.0 * a * (b * yCoordinate.toDouble() * yCoordinate.toDouble() + e * yCoordinate + f))) / (2 * a)).toFloat()
                if (!xCoordinate.isNaN())
                    canvas.drawPoint(xCoordinate * 20 + view.width / 2f,
                            invertY(yCoordinate, view.height),
                            ColorPicker.pickDefault())
                i += 0.05f
            }
        }
    }

    override fun canDraw(): Boolean {
        if (a >= 0 && b >= 0 || a <= 0 && b <= 0) return false
        return true
    }
}