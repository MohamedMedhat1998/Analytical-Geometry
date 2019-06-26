package com.andalus.abo_med7at.analyticalgeometry.models.parabola

import android.graphics.Canvas
import android.view.View
import com.andalus.abo_med7at.analyticalgeometry.utils.ArithmeticUtils.Companion.invertY
import com.andalus.abo_med7at.analyticalgeometry.utils.ColorPicker
import kotlin.math.sqrt

class StandardYParabola : Parabola() {

    var h: Double = 0.0
    var b: Double = 0.0
    var k: Double = 0.0

    override fun draw(canvas: Canvas, view: View) {
        if (b == 0.0) {
            //TODO show error message
            canvas.drawText("Unable to draw", 50f, 50f, ColorPicker.pickDefault())
        } else {
            //-----------------ACTUAL DRAWING-------------
            var xCoordinate: Float
            var yCoordinate: Float
            run {
                var i = (-view.height).toFloat()
                while (i < view.height) {
                    yCoordinate = i
                    xCoordinate = (h + sqrt(b * yCoordinate - b * k)).toFloat()
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
                xCoordinate = (h - sqrt(b * yCoordinate - b * k)).toFloat()
                if (!xCoordinate.isNaN())
                    canvas.drawPoint(xCoordinate * 20 + view.width / 2f,
                            invertY(yCoordinate, view.height),
                            ColorPicker.pickDefault())
                i += 0.05f
            }
            //-----------------END OF DRAWING-------------
        }
    }
}