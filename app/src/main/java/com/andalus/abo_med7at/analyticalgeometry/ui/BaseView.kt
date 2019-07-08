package com.andalus.abo_med7at.analyticalgeometry.ui

import com.andalus.abo_med7at.analyticalgeometry.models.Shape

interface BaseView {
    fun navigateToDrawingActivity(shape: Shape)
    fun showMessage(text: String)
}