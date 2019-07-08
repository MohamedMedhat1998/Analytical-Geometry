package com.andalus.abo_med7at.analyticalgeometry.models.parabola

import android.graphics.Canvas
import android.view.View
import com.andalus.abo_med7at.analyticalgeometry.utils.ArithmeticUtils.Companion.invertY
import com.andalus.abo_med7at.analyticalgeometry.utils.ColorPicker
import com.andalus.abo_med7at.analyticalgeometry.utils.FormulaBuilder.Companion.freeTerm
import com.andalus.abo_med7at.analyticalgeometry.utils.FormulaBuilder.Companion.x
import com.andalus.abo_med7at.analyticalgeometry.utils.FormulaBuilder.Companion.y
import kotlin.math.sqrt

class GeneralXParabola(val d: Double, val e: Double, val f: Double) : Parabola() {

    override val formula: String
        get() = "y^2${x(d)}${y(e)}${freeTerm(f)} = 0"

    override fun draw(canvas: Canvas, view: View) {
        if (canDraw()) {
            var xCoordinate: Float
            var yCoordinate: Float
            run {
                var i = (-view.width).toFloat()
                while (i < view.width) {
                    xCoordinate = i
                    yCoordinate = (0.5 * (-e + sqrt(e * e - 4 * (d * xCoordinate + f)))).toFloat()
                    if (!yCoordinate.isNaN())
                        canvas.drawPoint(xCoordinate * 20 + view.width / 2f,
                                invertY(yCoordinate, view.height),
                                ColorPicker.pickDefault())
                    i += 0.05f
                }
            }
            var i = (-view.width).toFloat()
            while (i < view.width) {
                xCoordinate = i
                yCoordinate = (0.5 * (-e - sqrt(e * e - 4 * (d * xCoordinate + f)))).toFloat()
                if (!yCoordinate.isNaN())
                    canvas.drawPoint(xCoordinate * 20 + view.width / 2f,
                            invertY(yCoordinate, view.height),
                            ColorPicker.pickDefault())
                i += 0.05f
            }
        }
    }

    override fun canDraw(): Boolean {
        if (d == 0.0) return false
        return true
    }

}