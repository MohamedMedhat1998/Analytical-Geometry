package com.andalus.abo_med7at.analyticalgeometry.utils

import android.graphics.Color
import android.graphics.Paint
import android.graphics.RadialGradient
import android.graphics.Shader
import android.graphics.drawable.ShapeDrawable

class ColorPicker {

    companion object {
        private val defaultPaint = Paint()
        private var constructed = false
        fun pickDefault(): Paint {
            if (!constructed) {
                construct()
                constructed = true
            }
            return defaultPaint
        }

        fun setRed() {
            //TODO Remove this RED
            defaultPaint.color = Color.RED
        }

        fun setStrokeFill() {
            //TODO Remove this STROKE
            defaultPaint.style = Paint.Style.FILL
        }

        fun setBlue() {
            //TODO Remove this BLUE
            defaultPaint.color = Color.BLUE
        }

        fun setGreen() {
            //TODO Remove this GREEN
            defaultPaint.color = Color.GREEN
        }

        fun setBlack() {
            //TODO Remove this YELLOW
            defaultPaint.color = Color.BLACK
        }

        private fun construct() {
            defaultPaint.color = Color.RED
            defaultPaint.style = Paint.Style.STROKE
            defaultPaint.isAntiAlias = true
        }
    }
}