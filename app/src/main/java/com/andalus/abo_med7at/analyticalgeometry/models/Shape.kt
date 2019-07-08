package com.andalus.abo_med7at.analyticalgeometry.models

import android.graphics.Canvas
import android.view.View
import java.io.Serializable

interface Shape : Serializable {
    fun draw(canvas: Canvas, view: View)
    fun canDraw(): Boolean
    val formula: String
    val category: String
    val unableToDrawMessage: String
}