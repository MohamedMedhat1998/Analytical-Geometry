package com.andalus.abo_med7at.analyticalgeometry.models.circle

import android.graphics.Canvas
import android.view.View
import com.andalus.abo_med7at.analyticalgeometry.utils.ArithmeticUtils
import com.andalus.abo_med7at.analyticalgeometry.utils.ColorPicker
import com.andalus.abo_med7at.analyticalgeometry.utils.FormulaBuilder.Companion.number

class StandardCircle(val h: Double, val k: Double, val r: Double) : Circle() {
    override val formula: String
        get() = "(x${number(h, canBeZero = false, isInverse = true, hasSign = true)})^2 + (y${number(k, canBeZero = false, isInverse = true, hasSign = true)})^2 = (${number(r)})^2"

    override fun draw(canvas: Canvas, view: View) {
        canvas.drawCircle((view.width / 2 + h * 20).toFloat(),
                ArithmeticUtils.invertY(k.toFloat(), view.height),
                r.toFloat() * 20,
                ColorPicker.pickDefault())
    }

    override fun canDraw(): Boolean {
        return true
    }
}