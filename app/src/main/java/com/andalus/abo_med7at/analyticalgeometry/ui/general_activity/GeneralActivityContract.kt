package com.andalus.abo_med7at.analyticalgeometry.ui.general_activity

import com.andalus.abo_med7at.analyticalgeometry.models.Shape
import com.andalus.abo_med7at.analyticalgeometry.utils.Constants

interface GeneralActivityContract {

    abstract class Presenter {
        abstract var view: View
        abstract var shape: Shape
        abstract var isValid: Boolean
        fun onDrawPressed(){
            if (isValid)
                view.navigateToDrawingClass(shape)
            else
                view.showMessage(Constants.Messages.MISSING_DATA)
        }
    }

    interface View {
        fun navigateToDrawingClass(shape: Shape)
        fun showMessage(text: String)
    }
}