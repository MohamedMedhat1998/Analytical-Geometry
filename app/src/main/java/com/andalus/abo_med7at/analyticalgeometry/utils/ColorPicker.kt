package com.andalus.abo_med7at.analyticalgeometry.utils

import android.graphics.Color
import android.graphics.Paint

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

        private fun construct() {
            defaultPaint.color = Color.RED
            defaultPaint.style = Paint.Style.STROKE
            defaultPaint.isAntiAlias = true
        }
    }
}