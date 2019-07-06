package com.andalus.abo_med7at.analyticalgeometry.models.circle

import android.graphics.Canvas
import android.view.View
import com.andalus.abo_med7at.analyticalgeometry.utils.ColorPicker
import com.andalus.abo_med7at.analyticalgeometry.utils.FormulaBuilder.Companion.freeTerm
import com.andalus.abo_med7at.analyticalgeometry.utils.FormulaBuilder.Companion.x
import com.andalus.abo_med7at.analyticalgeometry.utils.FormulaBuilder.Companion.xSquare
import com.andalus.abo_med7at.analyticalgeometry.utils.FormulaBuilder.Companion.y
import com.andalus.abo_med7at.analyticalgeometry.utils.FormulaBuilder.Companion.ySquare
import kotlin.math.sqrt

class GeneralCircle : Circle() {

    override val formula: String
        get() = "${xSquare(a, isStarting = true)}${ySquare(b)}${x(g)}${y(f)}${freeTerm(c)} = 0".trim().removePrefix("+")

    var a: Double = 0.0
    var b: Double = 0.0
    var g: Double = 0.0
    var f: Double = 0.0
    var c: Double = 0.0

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
        if (circle == null) {
            val localStandardCircle = StandardCircle()
            try {
                g /= 2.0
                g /= a
                f /= 2.0
                f /= a
                c /= a

                if (a == b && g * g + f * f - c >= 0.0) {
                    localStandardCircle.h = -g
                    localStandardCircle.k = -f
                    localStandardCircle.r = sqrt(g * g + f * f - c)

                    if (a == 0.0)
                        return null

                } else {
                    return null
                }
            } catch (e: Exception) {
                return null
            }
            circle = localStandardCircle
            return localStandardCircle
        } else {
            return circle as StandardCircle?
        }
    }
}