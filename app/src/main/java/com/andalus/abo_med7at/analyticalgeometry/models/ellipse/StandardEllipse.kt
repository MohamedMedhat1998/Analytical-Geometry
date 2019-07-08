package com.andalus.abo_med7at.analyticalgeometry.models.ellipse

import android.graphics.Canvas
import android.graphics.RectF
import android.view.View
import com.andalus.abo_med7at.analyticalgeometry.utils.ColorPicker
import com.andalus.abo_med7at.analyticalgeometry.utils.FormulaBuilder.Companion.number
import kotlin.math.sqrt

class StandardEllipse(val a: Double, val b: Double) : Ellipse() {
    override val formula: String
        get() = "(x^2/${number(a)}) + (y^2/${number(b)}) = 1"

    override fun draw(canvas: Canvas, view: View) {
        if (canDraw()) {
            val a = sqrt(a)
            val b = sqrt(b)
            val rectF = RectF(
                    (view.width / 2 - a * 20).toFloat(),
                    (view.height / 2 - b * 20).toFloat(),
                    (view.width / 2 + a * 20).toFloat(),
                    (view.height / 2 + b * 20).toFloat())

            canvas.drawOval(rectF, ColorPicker.pickDefault())
        }
    }

    override fun canDraw(): Boolean {
        if (a > 0 && b > 0) return true
        return false
    }
}