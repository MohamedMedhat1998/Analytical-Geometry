package com.andalus.abo_med7at.analyticalgeometry.models

import android.graphics.Canvas
import android.view.View
import com.andalus.abo_med7at.analyticalgeometry.utils.ColorPicker

class TestShape : Shape {
    //TODO Remove this TestShape
    override fun draw(canvas: Canvas, view: View) {
        canvas.drawCircle(0f, 0f, 50f, ColorPicker.pickDefault())
        ColorPicker.setBlue()
        canvas.drawCircle(0f, view.height.toFloat(), 50f, ColorPicker.pickDefault())
        ColorPicker.setGreen()
        canvas.drawCircle(view.width.toFloat(), 0f, 50f, ColorPicker.pickDefault())
        ColorPicker.setBlack()
        canvas.drawCircle(view.width.toFloat(), view.height.toFloat(), 50f, ColorPicker.pickDefault())
    }
}