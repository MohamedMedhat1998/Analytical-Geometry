package com.andalus.abo_med7at.analyticalgeometry.models.pair_of_lines

import android.graphics.Canvas
import android.view.View
import com.andalus.abo_med7at.analyticalgeometry.utils.ArithmeticUtils.Companion.invertY
import com.andalus.abo_med7at.analyticalgeometry.utils.ColorPicker
import com.andalus.abo_med7at.analyticalgeometry.utils.FormulaBuilder.Companion.freeTerm
import com.andalus.abo_med7at.analyticalgeometry.utils.FormulaBuilder.Companion.x
import com.andalus.abo_med7at.analyticalgeometry.utils.FormulaBuilder.Companion.xSquare
import com.andalus.abo_med7at.analyticalgeometry.utils.FormulaBuilder.Companion.xy
import com.andalus.abo_med7at.analyticalgeometry.utils.FormulaBuilder.Companion.y
import com.andalus.abo_med7at.analyticalgeometry.utils.FormulaBuilder.Companion.ySquare
import kotlin.math.sqrt

class GeneralPair : PairOfLines() {
    override val formula: String
        get() = "${xSquare(a)}${xy(h)}${ySquare(b)}${x(g)}${y(f)}${freeTerm(c)} = 0".trim().removePrefix("+")

    var a: Double = 0.0
    var h: Double = 0.0
    var b: Double = 0.0
    var g: Double = 0.0
    var f: Double = 0.0
    var c: Double = 0.0

    private var canEdit = true

    override fun draw(canvas: Canvas, view: View) {

        if (canEdit) {
            h /= 2.0
            g /= 2.0
            f /= 2.0
            canEdit = false
        }

        var xCoordinate: Float
        var yCoordinate: Float

        if (h * h - a * b >= 0 && a * b * c + 2.0 * f * g * h - a * f * f - b * g * g - c * h * h == 0.0) {
            if (a != 0.0 && b != 0.0) {
                //--------------------ACTUAL DRAWING------------------
                run {
                    var i = (-view.height).toFloat()
                    while (i < view.height) {
                        yCoordinate = i
                        xCoordinate = ((-(2.0 * h * i.toDouble() + 2.0 * g) + sqrt((2.0 * h * i.toDouble() + 2.0 * g) * (2.0 * h * i.toDouble() + 2.0 * g) - 4.0 * a * (b * i.toDouble() * i.toDouble() + 2.0 * f * i.toDouble() + c))) / (2.0 * a)).toFloat()
                        canvas.drawPoint(xCoordinate * 20 + view.width / 2f,
                                invertY(yCoordinate, view.height),
                                ColorPicker.pickDefault())
                        i += 0.05f
                    }
                }
                var i = (-view.height).toFloat()
                while (i < view.height) {
                    yCoordinate = i
                    xCoordinate = ((-(2.0 * h * i.toDouble() + 2.0 * g) - sqrt((2.0 * h * i.toDouble() + 2.0 * g) * (2.0 * h * i.toDouble() + 2.0 * g) - 4.0 * a * (b * i.toDouble() * i.toDouble() + 2.0 * f * i.toDouble() + c))) / (2.0 * a)).toFloat()
                    canvas.drawPoint(xCoordinate * 20 + view.width / 2f,
                            invertY(yCoordinate, view.height),
                            ColorPicker.pickDefault())
                    i += 0.05f
                }
                //--------------------END OF DRAWING------------------
            } else {
                //TODO show error message
                canvas.drawText("Unable to draw", 50f, 50f, ColorPicker.pickDefault())
            }
        } else {
            //TODO show error message
            canvas.drawText("NOT A PAIR", 50f, 50f, ColorPicker.pickDefault())
        }
    }
}