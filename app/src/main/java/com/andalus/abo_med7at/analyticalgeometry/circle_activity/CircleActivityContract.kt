package com.andalus.abo_med7at.analyticalgeometry.circle_activity

import com.andalus.abo_med7at.analyticalgeometry.models.Shape

interface CircleActivityContract {

    interface Presenter {
        fun onDrawPressed()
        fun validateAndSetValues(h: String?, k: String?, r: String?)
    }

    interface View {
        fun navigateToDrawingClass(shape: Shape)
        fun showMessage(text: String)
    }

}