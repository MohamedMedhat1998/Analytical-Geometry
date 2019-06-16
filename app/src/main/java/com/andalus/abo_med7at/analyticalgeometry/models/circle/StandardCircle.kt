package com.andalus.abo_med7at.analyticalgeometry.models.circle

import android.graphics.Canvas
import android.view.View
import com.andalus.abo_med7at.analyticalgeometry.utils.ArithmeticUtils
import com.andalus.abo_med7at.analyticalgeometry.utils.ColorPicker

class StandardCircle : Circle() {
    var h: Double? = null
    var k: Double? = null
    var r: Double? = null

    override fun draw(canvas: Canvas, view: View) {
        if (h != null && k != null && r != null){
            canvas.drawCircle((view.width / 2 + h!! * 20).toFloat(),
                    ArithmeticUtils.invertY(k!!.toFloat(), view.height),
                    r!!.toFloat() * 20,
                    ColorPicker.pickDefault())
        }
    }
}