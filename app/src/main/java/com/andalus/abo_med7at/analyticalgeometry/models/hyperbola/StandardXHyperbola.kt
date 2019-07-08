package com.andalus.abo_med7at.analyticalgeometry.models.hyperbola

import android.graphics.Canvas
import android.view.View
import com.andalus.abo_med7at.analyticalgeometry.utils.ArithmeticUtils.Companion.invertY
import com.andalus.abo_med7at.analyticalgeometry.utils.ColorPicker
import com.andalus.abo_med7at.analyticalgeometry.utils.FormulaBuilder.Companion.number
import kotlin.math.sqrt

class StandardXHyperbola(val a: Double, val b: Double) : Hyperbola() {
    override val formula: String
        get() = "(x^2/${number(a)}) - (y^2/${number(b)}) = 1"

    override fun draw(canvas: Canvas, view: View) {
        if (canDraw()) {
            val a = sqrt(a)
            val b = sqrt(b)

            var xCoordinate: Float
            var yCoordinate: Float

            run {
                var i = (-view.height).toFloat()
                while (i < view.height) {
                    yCoordinate = i
                    xCoordinate = (a * sqrt(1 + yCoordinate * yCoordinate / (b * b))).toFloat()
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
                xCoordinate = (-a * sqrt(1 + yCoordinate * yCoordinate / (b * b))).toFloat()
                if (!xCoordinate.isNaN())
                    canvas.drawPoint(xCoordinate * 20 + view.width / 2f,
                            invertY(yCoordinate, view.height),
                            ColorPicker.pickDefault())
                i += 0.05f
            }
        }

    }

    override fun canDraw(): Boolean {
        if (a > 0 && b > 0) return true
        return false
    }
}