package com.andalus.abo_med7at.analyticalgeometry.models.ellipse

import android.graphics.Canvas
import android.graphics.RectF
import android.view.View
import com.andalus.abo_med7at.analyticalgeometry.utils.ArithmeticUtils.Companion.invertY
import com.andalus.abo_med7at.analyticalgeometry.utils.ColorPicker
import com.andalus.abo_med7at.analyticalgeometry.utils.FormulaBuilder.Companion.freeTerm
import com.andalus.abo_med7at.analyticalgeometry.utils.FormulaBuilder.Companion.x
import com.andalus.abo_med7at.analyticalgeometry.utils.FormulaBuilder.Companion.xSquare
import com.andalus.abo_med7at.analyticalgeometry.utils.FormulaBuilder.Companion.y
import com.andalus.abo_med7at.analyticalgeometry.utils.FormulaBuilder.Companion.ySquare
import kotlin.math.pow
import kotlin.math.sqrt

class GeneralEllipse : Ellipse() {
    override val formula: String
        get() = "${xSquare(a, isStarting = true)}${ySquare(c)}${x(d)}${y(e)}${freeTerm(f)} = 0".trim().removePrefix("+")

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
            val denominator = -f + d.pow(2) / (4 * a) + e.pow(2) / (4 * c)
            val aStandard = sqrt(denominator / a)
            val bStandard = sqrt(denominator / c)
            val shiftX = -d / (2 * a)
            val shiftY = -e / (2 * c)

            val rectF = RectF(
                    (view.width / 2 - (aStandard - shiftX) * 20).toFloat(),
                    (view.height / 2 - (bStandard + shiftY) * 20).toFloat(),
                    (view.width / 2 + (aStandard + shiftX) * 20).toFloat(),
                    (view.height / 2 + (bStandard - shiftY) * 20).toFloat())

            canvas.drawOval(rectF, ColorPicker.pickDefault())
            //-------------------END OF DRAWING----------------
        }


    }
}