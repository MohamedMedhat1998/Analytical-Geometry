package com.andalus.abo_med7at.analyticalgeometry.models.circle

import android.graphics.Canvas
import android.view.View
import com.andalus.abo_med7at.analyticalgeometry.utils.ArithmeticUtils
import com.andalus.abo_med7at.analyticalgeometry.utils.ColorPicker
import com.andalus.abo_med7at.analyticalgeometry.utils.FormulaBuilder.Companion.number
import kotlin.math.sqrt

class DiameterCircle(private val x1: Double, private val x2: Double, private val y1: Double, private val y2: Double) : Circle() {

    override val formula: String
        get() = "Diameter ends (${number(x1)},${number(y1)}) , (${number(x2)},${number(y2)})"

    override fun draw(canvas: Canvas, view: View) {
        val h = (x1 + x2) / 2
        val k = (y1 + y2) / 2
        val r = sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2)) / 2
        canvas.drawCircle((view.width / 2 + h * 20).toFloat(),
                ArithmeticUtils.invertY(k.toFloat(), view.height),
                r.toFloat() * 20,
                ColorPicker.pickDefault())
    }

    override fun canDraw(): Boolean {
        return true
    }

}