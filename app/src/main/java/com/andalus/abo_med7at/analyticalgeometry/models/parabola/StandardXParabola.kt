package com.andalus.abo_med7at.analyticalgeometry.models.parabola

import android.graphics.Canvas
import android.view.View
import com.andalus.abo_med7at.analyticalgeometry.utils.ArithmeticUtils.Companion.invertY
import com.andalus.abo_med7at.analyticalgeometry.utils.ColorPicker
import com.andalus.abo_med7at.analyticalgeometry.utils.FormulaBuilder.Companion.number
import kotlin.math.sqrt

class StandardXParabola : Parabola() {

    override val formula: String
        get() = "(y${number(k, isInverse = true, hasSign = true, canBeZero = false)})^2 = ${number(a,canBeOne = false)}(x${number(h, isInverse = true, hasSign = true, canBeZero = false)})"
    var k: Double = 0.0
    var a: Double = 0.0
    var h: Double = 0.0

    override fun draw(canvas: Canvas, view: View) {

        var xCoordinate: Float
        var yCoordinate: Float

        if (a == 0.0) {
            //TODO show error message
            canvas.drawText("Unable to draw", 50f, 50f, ColorPicker.pickDefault())
        } else {
            //---------ACTUAL DRAWING--------------
            run {
                var i = (-view.width).toFloat()
                while (i < view.width) {
                    xCoordinate = i
                    yCoordinate = (k + sqrt(a * xCoordinate - a * h)).toFloat()
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
                yCoordinate = (k - sqrt(a * xCoordinate - a * h)).toFloat()
                if (!yCoordinate.isNaN())
                    canvas.drawPoint(xCoordinate * 20 + view.width / 2f,
                            invertY(yCoordinate, view.height),
                            ColorPicker.pickDefault())
                i += 0.05f
            }
            //---------END OF DRAWING--------------
        }
    }
}