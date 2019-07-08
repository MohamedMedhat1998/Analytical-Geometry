package com.andalus.abo_med7at.analyticalgeometry.models.pair_of_lines

import android.graphics.Canvas
import android.view.View
import com.andalus.abo_med7at.analyticalgeometry.utils.ColorPicker
import com.andalus.abo_med7at.analyticalgeometry.utils.FormulaBuilder.Companion.xSquare
import com.andalus.abo_med7at.analyticalgeometry.utils.FormulaBuilder.Companion.xy
import com.andalus.abo_med7at.analyticalgeometry.utils.FormulaBuilder.Companion.ySquare
import kotlin.math.pow
import kotlin.math.sqrt

class HomogeneousPair(val a: Double, val h: Double, val b: Double) : PairOfLines() {
    override val formula: String
        get() = "${xSquare(a, isStarting = true)}${xy(h)}${ySquare(b)} = 0".trim().removePrefix("+")

    private var canEdit = true

    private var startX = 0f
    private var endX = 0f

    override fun draw(canvas: Canvas, view: View) {
        if (canDraw()) {
            if (canEdit) {
                startX = -view.width.toFloat() / 2
                endX = view.width.toFloat() / 2
                canEdit = false
            }
            drawFirstLine(canvas, view)
            drawSecondLine(canvas, view)
        }
    }

    private fun drawFirstLine(canvas: Canvas, view: View) {
        val h = this.h / 2.0
        val startY = ((-h + sqrt(h.pow(2) - a * b)) / b) * startX * -1
        val endY = ((-h + sqrt(h.pow(2) - a * b)) / b) * endX * -1
        canvas.drawLine(startX + view.width / 2f,
                startY.toFloat() + view.height / 2f,
                endX + view.width / 2f,
                endY.toFloat() + view.height / 2f,
                ColorPicker.pickDefault())
    }

    private fun drawSecondLine(canvas: Canvas, view: View) {
        val h = this.h / 2.0
        val startY = ((-h - sqrt(h.pow(2) - a * b)) / b) * startX * -1
        val endY = ((-h - sqrt(h.pow(2) - a * b)) / b) * endX * -1
        canvas.drawLine(startX + view.width / 2f,
                startY.toFloat() + view.height / 2f,
                endX + view.width / 2f,
                endY.toFloat() + view.height / 2f,
                ColorPicker.pickDefault())
    }

    override fun canDraw(): Boolean {
        val h = this.h / 2.0
        if (h * h - a * b < 0) return false
        if (a != 0.0 && b != 0.0) return true
        return false
    }
}