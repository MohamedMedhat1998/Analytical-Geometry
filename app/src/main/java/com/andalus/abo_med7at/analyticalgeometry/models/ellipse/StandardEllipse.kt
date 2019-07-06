package com.andalus.abo_med7at.analyticalgeometry.models.ellipse

import android.graphics.Canvas
import android.graphics.RectF
import android.view.View
import com.andalus.abo_med7at.analyticalgeometry.utils.ColorPicker
import kotlin.math.sqrt

class StandardEllipse : Ellipse() {
    override val formula: String
        get() = "(x^2/$a) + (y^2/$b) = 1"

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
            //---------------------ACTUAL DRAWING-------------------
            val rectF = RectF(
                    (view.width / 2 - a * 20).toFloat(),
                    (view.height / 2 - b * 20).toFloat(),
                    (view.width / 2 + a * 20).toFloat(),
                    (view.height / 2 + b * 20).toFloat())

            canvas.drawOval(rectF, ColorPicker.pickDefault())
            //---------------------END OF DRAWING-------------------
        } else {
            //TODO write an error message ("UNABLE TO DRAW")
            canvas.drawText("UNABLE TO DRAW", 50f, 50f, ColorPicker.pickDefault())
        }
    }
}