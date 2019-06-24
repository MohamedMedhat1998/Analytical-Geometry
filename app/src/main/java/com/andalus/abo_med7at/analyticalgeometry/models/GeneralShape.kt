package com.andalus.abo_med7at.analyticalgeometry.models

import android.graphics.Canvas
import android.view.View
import com.andalus.abo_med7at.analyticalgeometry.utils.ArithmeticUtils.Companion.invertY
import com.andalus.abo_med7at.analyticalgeometry.utils.ColorPicker
import kotlin.math.sqrt

class GeneralShape : Shape {

    var a: Double = 0.0
    var h: Double = 0.0
    var b: Double = 0.0
    var g: Double = 0.0
    var f: Double = 0.0
    var c: Double = 0.0

    override fun draw(canvas: Canvas, view: View) {

        var xCoordinate: Float
        var yCoordinate: Float

        when {
            a != 0.0 -> {
                run {
                    var i = (-view.height).toFloat()
                    while (i < view.height) {
                        yCoordinate = i
                        xCoordinate = ((-(h * i + g) + sqrt((h * i + g) * (h * i + g) - 4.0 * a * (b * i.toDouble() * i.toDouble() + f * i + c))) / (2.0 * a)).toFloat()
                        canvas.drawPoint(xCoordinate * 20 + view.width / 2f,
                                invertY(yCoordinate, view.height),
                                ColorPicker.pickDefault())
                        i += 0.05f
                    }
                }
                var i = (-view.height).toFloat()
                while (i < view.height) {
                    yCoordinate = i
                    xCoordinate = ((-(h * i + g) - sqrt((h * i + g) * (h * i + g) - 4.0 * a * (b * i.toDouble() * i.toDouble() + f * i + c))) / (2.0 * a)).toFloat()
                    canvas.drawPoint(xCoordinate * 20 + view.width / 2f,
                            invertY(yCoordinate, view.height),
                            ColorPicker.pickDefault())
                    i += 0.05f
                }
            }
            b != 0.0 -> {
                run {
                    var i = (-view.width).toFloat()
                    while (i < view.width) {
                        xCoordinate = i
                        yCoordinate = ((-(h * i + f) + sqrt((h * i + f) * (h * i + f) - 4.0 * b * (a * i.toDouble() * i.toDouble() + g * i + c))) / (2.0 * b)).toFloat()
                        canvas.drawPoint(xCoordinate * 20 + view.width / 2f,
                                invertY(yCoordinate, view.height),
                                ColorPicker.pickDefault())
                        i += 0.05f
                    }
                }
                var i = (-view.width).toFloat()
                while (i < view.width) {
                    xCoordinate = i
                    yCoordinate = ((-(h * i + f) - sqrt((h * i + f) * (h * i + f) - 4.0 * b * (a * i.toDouble() * i.toDouble() + g * i + c))) / (2.0 * b)).toFloat()
                    canvas.drawPoint(xCoordinate * 20 + view.width / 2f,
                            invertY(yCoordinate, view.height),
                            ColorPicker.pickDefault())
                    i += 0.05f
                }
            }
            else -> {
                var i = (-view.height).toFloat()
                while (i < view.height) {
                    yCoordinate = i
                    xCoordinate = (-(f * i + c) / (h * i + g)).toFloat()
                    canvas.drawPoint(xCoordinate * 20 + view.width / 2f,
                            invertY(yCoordinate, view.height),
                            ColorPicker.pickDefault())
                    i += 0.05f
                }
            }
        }

    }
}