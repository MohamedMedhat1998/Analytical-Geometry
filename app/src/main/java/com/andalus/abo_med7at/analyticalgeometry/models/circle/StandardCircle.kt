package com.andalus.abo_med7at.analyticalgeometry.models.circle

import android.graphics.Canvas
import android.view.View
import com.andalus.abo_med7at.analyticalgeometry.utils.ArithmeticUtils
import com.andalus.abo_med7at.analyticalgeometry.utils.ColorPicker

class StandardCircle : Circle() {
    var h: Double = 0.0
    var k: Double = 0.0
    var r: Double = 0.0

    override fun draw(canvas: Canvas, view: View) {
        canvas.drawCircle((view.width / 2 + h * 20).toFloat(),
                ArithmeticUtils.invertY(k.toFloat(), view.height),
                r.toFloat() * 20,
                ColorPicker.pickDefault())
    }
}