package com.andalus.abo_med7at.analyticalgeometry.models.parabola

import android.graphics.Canvas
import android.view.View
import com.andalus.abo_med7at.analyticalgeometry.utils.ArithmeticUtils.Companion.invertY
import com.andalus.abo_med7at.analyticalgeometry.utils.ColorPicker
import kotlin.math.sqrt

class GeneralXParabola : Parabola() {

    var d: Double = 0.0
    var e: Double = 0.0
    var f: Double = 0.0

    override fun draw(canvas: Canvas, view: View) {

        if (d == 0.0) {
            //TODO show error message
            canvas.drawText("Unable to draw", 50f, 50f, ColorPicker.pickDefault())
        } else {
            //---------------------ACTUAL DRAWING------------------
            var xCoordinate: Float
            var yCoordinate: Float
            run {
                var i = (-view.width).toFloat()
                while (i < view.width) {
                    xCoordinate = i
                    yCoordinate = (0.5 * (-e + sqrt(e * e - 4 * (d * xCoordinate + f)))).toFloat()
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
                canvas.drawPoint(xCoordinate * 20 + view.width / 2f,
                        invertY(yCoordinate, view.height),
                        ColorPicker.pickDefault())
                i += 0.05f
            }
            //---------------------END OF DRAWING------------------
        }
    }
}