package com.andalus.abo_med7at.analyticalgeometry.models.ellipse

import android.graphics.Canvas
import android.view.View
import com.andalus.abo_med7at.analyticalgeometry.utils.ArithmeticUtils.Companion.invertY
import com.andalus.abo_med7at.analyticalgeometry.utils.ColorPicker
import kotlin.math.sqrt

class GeneralEllipse : Ellipse() {

    var a: Double = 0.0
    var c: Double = 0.0
    var d: Double = 0.0
    var e: Double = 0.0
    var f: Double = 0.0

    override fun draw(canvas: Canvas, view: View) {

        if (a == c) {
            //TODO write an error message ("UNABLE TO DRAW")
            canvas.drawText("NOT ELLIPSE", 50f, 50f, ColorPicker.pickDefault())
        } else if (d == 0.0 && e == 0.0 && f >= 0) {
            //TODO write an error message ("UNABLE TO DRAW")
            canvas.drawText("UNABLE TO DRAW", 50f, 50f, ColorPicker.pickDefault())
        } else if (a > 0 && c < 0 || a < 0 && c > 0) {
            //TODO write an error message ("UNABLE TO DRAW")
            canvas.drawText("NOT ELLIPSE", 50f, 50f, ColorPicker.pickDefault())
        } else {
            //-------------------ACTUAL DRAWING----------------
            var xCoordinate: Float
            var yCoordinate: Float

            run {
                var i = (-view.height).toFloat()
                while (i < view.height) {
                    yCoordinate = i
                    xCoordinate = ((-d - sqrt(d * d - 4.0 * a * (c * yCoordinate.toDouble() * yCoordinate.toDouble() + e * yCoordinate + f))) / (2 * a)).toFloat()
                    canvas.drawPoint(xCoordinate * 20 + view.width / 2f,
                            invertY(yCoordinate, view.height),
                            ColorPicker.pickDefault())
                    i += 0.05f
                }
            }
            var i = (-view.height).toFloat()
            while (i < view.height) {
                yCoordinate = i
                xCoordinate = ((-d + sqrt(d * d - 4.0 * a * (c * yCoordinate.toDouble() * yCoordinate.toDouble() + e * yCoordinate + f))) / (2 * a)).toFloat()
                canvas.drawPoint(xCoordinate * 20 + view.width / 2f,
                        invertY(yCoordinate, view.height),
                        ColorPicker.pickDefault())
                i += 0.05f
            }
            //-------------------END OF DRAWING----------------
        }


    }
}