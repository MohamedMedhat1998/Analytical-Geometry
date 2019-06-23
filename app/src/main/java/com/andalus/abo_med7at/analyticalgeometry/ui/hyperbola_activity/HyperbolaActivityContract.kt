package com.andalus.abo_med7at.analyticalgeometry.ui.hyperbola_activity

import com.andalus.abo_med7at.analyticalgeometry.models.Shape
import com.andalus.abo_med7at.analyticalgeometry.models.hyperbola.Hyperbola
import com.andalus.abo_med7at.analyticalgeometry.utils.Constants

interface HyperbolaActivityContract {

    abstract class Presenter {
        abstract var view: View
        abstract var hyperbola: Hyperbola
        abstract var isValid: Boolean
        fun onDrawPressed(){
            if (isValid)
                view.navigateToDrawingClass(hyperbola)
            else
                view.showMessage(Constants.Messages.MISSING_DATA)
        }
    }

    interface View {
        fun navigateToDrawingClass(shape: Shape)
        fun showMessage(text: String)
    }
}