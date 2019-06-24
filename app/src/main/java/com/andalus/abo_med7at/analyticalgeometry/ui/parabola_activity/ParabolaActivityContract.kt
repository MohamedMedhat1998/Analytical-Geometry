package com.andalus.abo_med7at.analyticalgeometry.ui.parabola_activity

import com.andalus.abo_med7at.analyticalgeometry.models.Shape
import com.andalus.abo_med7at.analyticalgeometry.models.parabola.Parabola
import com.andalus.abo_med7at.analyticalgeometry.utils.Constants

interface ParabolaActivityContract {

    abstract class Presenter {
        abstract var view: View
        abstract var parabola: Parabola
        abstract var isValid: Boolean
        fun onDrawPressed(){
            if (isValid)
                view.navigateToDrawingActivity(parabola)
            else
                view.showMessage(Constants.Messages.MISSING_DATA)
        }
    }

    interface View {
        fun navigateToDrawingActivity(shape: Shape)
        fun showMessage(text: String)
    }

}