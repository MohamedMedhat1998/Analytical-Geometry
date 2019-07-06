package com.andalus.abo_med7at.analyticalgeometry.models.hyperbola

import android.graphics.Canvas
import android.view.View
import com.andalus.abo_med7at.analyticalgeometry.utils.ArithmeticUtils.Companion.invertY
import com.andalus.abo_med7at.analyticalgeometry.utils.ColorPicker
import com.andalus.abo_med7at.analyticalgeometry.utils.FormulaBuilder.Companion.number
import kotlin.math.sqrt

class StandardXHyperbola : Hyperbola() {
    override val formula: String
        get() = "(x^2/${number(a)}) - (y^2/${number(b)}) = 1"

    var a: Double = 0.0
    var b: Double = 0.0

    private var canEdit = true

    override fun draw(canvas: Canvas, view: View) {
        if (canEdit) {
            a = sqrt(a)
            b = sqrt(b)
            canEdit = false
        }

        if (a > 0 && b > 0) {
            //-----------------ACTUAL DRAWING------------------
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
            //-----------------END OF DRAWING------------------
        } else {
            //TODO show error message
            canvas.drawText("Unable to draw", 50f, 50f, ColorPicker.pickDefault())
        }
    }
}