package com.andalus.abo_med7at.analyticalgeometry.models.pair_of_lines

import android.graphics.Canvas
import android.view.View
import com.andalus.abo_med7at.analyticalgeometry.utils.ArithmeticUtils.Companion.invertY
import com.andalus.abo_med7at.analyticalgeometry.utils.ColorPicker
import kotlin.math.pow
import kotlin.math.sqrt

class HomogeneousPair : PairOfLines() {

    var a: Double = 0.0
    var h: Double = 0.0
    var b: Double = 0.0

    private var canEdit = true

    private var startX = 0f
    private var endX = 0f

    override fun draw(canvas: Canvas, view: View) {
        if (canEdit) {
            h /= 2.0
            startX = -view.width.toFloat() / 2 + view.width / 2
            endX = view.width.toFloat() / 2 + view.width / 2
            canEdit = false
        }
        if (h * h - a * b < 0) {
            //TODO show error message
            canvas.drawText("NOT A PAIR", 50f, 50f, ColorPicker.pickDefault())
        } else {
            if (a != 0.0 && b != 0.0) {
                //-------------------ACTUAL DRAWING---------------------
                var xCoordinate: Float
                var yCoordinate: Float
                run {
                    var i = (-view.width).toFloat()
                    while (i < view.width) {
                        xCoordinate = i
                        yCoordinate = (xCoordinate * ((-h + sqrt(h * h - a * b)) / b)).toFloat()
                        canvas.drawPoint(xCoordinate * 20 + view.width / 2f,
                                invertY(yCoordinate, view.height),
                                ColorPicker.pickDefault())
                        i += 0.05f
                    }
                }
                var i = (-view.width).toFloat()
                while (i < view.width) {
                    xCoordinate = i
                    yCoordinate = (xCoordinate * ((-h - sqrt(h * h - a * b)) / b)).toFloat()
                    canvas.drawPoint(xCoordinate * 20 + view.width / 2f,
                            invertY(yCoordinate, view.height),
                            ColorPicker.pickDefault())
                    i += 0.05f
                }
                /*drawFirstLine(canvas, view)
                drawSecondLine(canvas, view)*/
                //------------------------END OF DRAWING-----------------------
            } else {
                //TODO show error message
                canvas.drawText("Unable to draw", 50f, 50f, ColorPicker.pickDefault())
            }
        }
    }

    private fun drawFirstLine(canvas: Canvas, view: View) {
        val startY = ((-h + sqrt(h.pow(2) - a * b)) / b) * startX
        val endY = ((-h + sqrt(h.pow(2) - a * b)) / b) * endX
        canvas.drawLine(startX,
                startY.toFloat(),
                endX,
                endY.toFloat(),
                ColorPicker.pickDefault())
    }

    private fun drawSecondLine(canvas: Canvas, view: View) {
        val startY = ((-h - sqrt(h.pow(2) - a * b)) / b) * startX
        val endY = ((-h - sqrt(h.pow(2) - a * b)) / b) * endX
        canvas.drawLine(startX,
                startY.toFloat(),
                endX,
                endY.toFloat(),
                ColorPicker.pickDefault())
    }
}