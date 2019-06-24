package com.andalus.abo_med7at.analyticalgeometry

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import androidx.core.content.res.ResourcesCompat
import android.view.View
import com.andalus.abo_med7at.analyticalgeometry.models.Shape

class CoordinatePlane(context: Context) :
        View(context) {

    lateinit var shape : Shape

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        if (canvas != null){
            drawAxes(canvas)
            shape.draw(canvas, this)
        }
    }

    private fun drawAxes(canvas: Canvas) {
        val p = Paint()
        p.color = ResourcesCompat.getColor(resources,R.color.Gray_300,null)
        val p2 = Paint()
        p2.color = Color.GREEN
        var count = 0
        //+ve x axis
        run {
            var i = width / 2
            while (i < width) {
                val y = Rect()
                y.set(i, 0, i + 1, height)
                canvas.drawRect(y, p)
                if (count != 0)
                    canvas.drawText(count.toString() + "",
                            i - 2.5f,
                            height / 2.0f + 15.0f,
                            p2)
                count++
                i += 20
            }
        }
        count = 0
        //-ve x axis
        run {
            var i = width / 2
            while (i > 0) {
                val y = Rect()
                y.set(i, 0, i + 1, height)
                canvas.drawRect(y, p)
                if (count != 0)
                    canvas.drawText(count.toString() + "",
                            i - 5.0f,
                            height / 2.0f + 15.0f,
                            p2)
                count--
                i -= 20
            }
        }
        count = 0
        //-ve y axis
        run {
            var i = height / 2
            while (i < height) {
                val x = Rect()
                x.set(0, i, width, i + 1)
                canvas.drawRect(x, p)
                if (count != 0)
                    canvas.drawText(count.toString() + "",
                            width / 2.0f + 2.5f,
                            i + 4.0f,
                            p2)
                count--
                i += 20
            }
        }
        count = 0
        //+ve y axis
        var i = height / 2
        while (i > 0) {
            val x = Rect()
            x.set(0, i, width, i + 1)
            canvas.drawRect(x, p)
            if (count != 0)
                canvas.drawText(count.toString() + "", width / 2.0f + 2.5f, i + 4.0f, p2)
            count++
            i -= 20
        }
        val y = Rect()
        val x = Rect()
        y.set(width / 2 - 1, 0, width / 2 + 1, height)
        x.set(0, height / 2 - 1, width, height / 2 + 1)
        p.color = Color.BLACK
        p.style = Paint.Style.FILL
        canvas.drawRect(y, p)
        canvas.drawRect(x, p)
    }

}