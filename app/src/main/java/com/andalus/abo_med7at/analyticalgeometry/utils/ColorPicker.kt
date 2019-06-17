package com.andalus.abo_med7at.analyticalgeometry.utils

import android.graphics.Color
import android.graphics.Paint

class ColorPicker {

    companion object{
        private val defaultPaint = Paint()
        fun pickDefault() : Paint{
            defaultPaint.color = Color.RED
            defaultPaint.style = Paint.Style.STROKE
            return defaultPaint
        }
    }
}