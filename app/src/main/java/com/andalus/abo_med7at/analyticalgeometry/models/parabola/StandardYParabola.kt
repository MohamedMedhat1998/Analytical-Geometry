package com.andalus.abo_med7at.analyticalgeometry.models.parabola

import android.graphics.Canvas
import android.view.View
import com.andalus.abo_med7at.analyticalgeometry.utils.ArithmeticUtils.Companion.invertY
import com.andalus.abo_med7at.analyticalgeometry.utils.ColorPicker
import com.andalus.abo_med7at.analyticalgeometry.utils.FormulaBuilder.Companion.number
import kotlin.math.sqrt

class StandardYParabola(val h: Double, val b: Double, val k: Double) : Parabola() {
    override val formula: String
        get() = "(x${number(h, isInverse = true, hasSign = true, canBeZero = false)})^2 = ${number(b, canBeOne = false)}(y${number(k, isInverse = true, hasSign = true, canBeZero = false)})"

    override fun draw(canvas: Canvas, view: View) {
        if (canDraw()) {
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
        }
    }

    override fun canDraw(): Boolean {
        if (b == 0.0) return false
        return true
    }

}