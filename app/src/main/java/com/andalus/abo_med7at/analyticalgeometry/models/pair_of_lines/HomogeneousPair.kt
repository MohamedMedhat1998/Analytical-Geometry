package com.andalus.abo_med7at.analyticalgeometry.models.pair_of_lines

import android.graphics.Canvas
import android.view.View
import com.andalus.abo_med7at.analyticalgeometry.utils.ArithmeticUtils.Companion.invertY
import com.andalus.abo_med7at.analyticalgeometry.utils.ColorPicker
import com.andalus.abo_med7at.analyticalgeometry.utils.FormulaBuilder
import com.andalus.abo_med7at.analyticalgeometry.utils.FormulaBuilder.Companion.xSquare
import com.andalus.abo_med7at.analyticalgeometry.utils.FormulaBuilder.Companion.xy
import com.andalus.abo_med7at.analyticalgeometry.utils.FormulaBuilder.Companion.ySquare
import kotlin.math.pow
import kotlin.math.sqrt

class HomogeneousPair : PairOfLines() {
    override val formula: String
        get() = "${xSquare(a, isStarting = true)}${xy(h)}${ySquare(b)} = 0".trim().removePrefix("+")

    var a: Double = 0.0
    var h: Double = 0.0
    var b: Double = 0.0

    private var canEdit = true

    private var startX = 0f
    private var endX = 0f

    override fun draw(canvas: Canvas, view: View) {
        if (canEdit) {
            h /= 2.0
            startX = -view.width.toFloat() / 2
            endX = view.width.toFloat() / 2
            canEdit = false
        }
        if (h * h - a * b < 0) {
            //TODO show error message
            canvas.drawText("NOT A PAIR", 50f, 50f, ColorPicker.pickDefault())
        } else {
            if (a != 0.0 && b != 0.0) {
                //-------------------ACTUAL DRAWING---------------------
                drawFirstLine(canvas, view)
                drawSecondLine(canvas, view)
                //------------------------END OF DRAWING-----------------------
            } else {
                //TODO show error message
                canvas.drawText("Unable to draw", 50f, 50f, ColorPicker.pickDefault())
            }
        }
    }

    private fun drawFirstLine(canvas: Canvas, view: View) {
        val startY = ((-h + sqrt(h.pow(2) - a * b)) / b) * startX * -1
        val endY = ((-h + sqrt(h.pow(2) - a * b)) / b) * endX * -1
        canvas.drawLine(startX + view.width / 2f,
                startY.toFloat() + view.height / 2f,
                endX + view.width / 2f,
                endY.toFloat() + view.height / 2f,
                ColorPicker.pickDefault())
    }

    private fun drawSecondLine(canvas: Canvas, view: View) {
        val startY = ((-h - sqrt(h.pow(2) - a * b)) / b) * startX * -1
        val endY = ((-h - sqrt(h.pow(2) - a * b)) / b) * endX * -1
        canvas.drawLine(startX + view.width / 2f,
                startY.toFloat() + view.height / 2f,
                endX + view.width / 2f,
                endY.toFloat() + view.height / 2f,
                ColorPicker.pickDefault())
    }
}