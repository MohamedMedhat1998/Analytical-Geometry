package com.andalus.abo_med7at.analyticalgeometry.models.circle

import android.graphics.Canvas
import android.view.View
import com.andalus.abo_med7at.analyticalgeometry.utils.ColorPicker
import kotlin.math.sqrt

class DiameterCircle : Circle() {

    var x1: Double = 0.0
    var x2: Double = 0.0
    var y1: Double = 0.0
    var y2: Double = 0.0

    var circle: Circle? = null

    override fun draw(canvas: Canvas, view: View) {
        val circle = convertToStandard()
        if (circle != null) {
            circle.draw(canvas, view)
        } else {
            //TODO write an error message ("UNABLE TO DRAW")
            canvas.drawText("UNABLE TO DRAW", 50f, 50f, ColorPicker.pickDefault())
        }
    }


    private fun convertToStandard(): StandardCircle? {
        return if (circle == null) {
            val standardCircle = StandardCircle()
            standardCircle.h = (x1 + x2) / 2
            standardCircle.k = (y1 + y2) / 2
            standardCircle.r = sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2)) / 2
            circle = standardCircle
            standardCircle
        } else {
            circle as StandardCircle
        }
    }

}