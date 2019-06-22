package com.andalus.abo_med7at.analyticalgeometry.models.pair_of_lines

import android.graphics.Canvas
import android.view.View
import com.andalus.abo_med7at.analyticalgeometry.utils.ArithmeticUtils.Companion.invertY
import com.andalus.abo_med7at.analyticalgeometry.utils.ColorPicker
import kotlin.math.sqrt

class HomogeneousPair : PairOfLines() {

    var a: Double = 0.0
    var h: Double = 0.0
    var b: Double = 0.0

    private var flag = 1

    override fun draw(canvas: Canvas, view: View) {
        if(flag == 1){
            h /= 2.0
            flag = 0
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
                //------------------------END OF DRAWING-----------------------
            } else {
                //TODO show error message
                canvas.drawText("Unable to draw", 50f, 50f, ColorPicker.pickDefault())
            }
        }
    }
}