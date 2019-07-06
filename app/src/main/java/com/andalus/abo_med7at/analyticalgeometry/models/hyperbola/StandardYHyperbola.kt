package com.andalus.abo_med7at.analyticalgeometry.models.hyperbola

import android.graphics.Canvas
import android.view.View
import com.andalus.abo_med7at.analyticalgeometry.utils.ArithmeticUtils.Companion.invertY
import com.andalus.abo_med7at.analyticalgeometry.utils.ColorPicker
import com.andalus.abo_med7at.analyticalgeometry.utils.FormulaBuilder.Companion.number
import kotlin.math.sqrt

class StandardYHyperbola : Hyperbola() {
    override val formula: String
        get() = "(y^2/${number(a)}) - (x^2/${number(b)}) = 1"

    var a: Double = 0.0
    var b: Double = 0.0

    private var flag = 1

    override fun draw(canvas: Canvas, view: View) {
        if (flag == 1) {
            a = sqrt(a)
            b = sqrt(b)
            flag = 0
        }

        if (a > 0 && b > 0) {
            //------------ACTUAL DRAWING---------------
            var xCoordinate: Float
            var yCoordinate: Float

            run {
                var i = (-view.width).toFloat()
                while (i < view.width) {
                    xCoordinate = i
                    yCoordinate = (b * sqrt(1 + xCoordinate * xCoordinate / (a * a))).toFloat()
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
                yCoordinate = (-b * sqrt(1 + xCoordinate * xCoordinate / (a * a))).toFloat()
                if (!yCoordinate.isNaN())
                    canvas.drawPoint(xCoordinate * 20 + view.width / 2f,
                            invertY(yCoordinate, view.height),
                            ColorPicker.pickDefault())
                i += 0.05f
            }
            //------------END OF DRAWING---------------
        } else {
            //TODO show error message
            canvas.drawText("Unable to draw", 50f, 50f, ColorPicker.pickDefault())
        }
    }
}