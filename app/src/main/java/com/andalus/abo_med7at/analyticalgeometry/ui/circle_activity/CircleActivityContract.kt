package com.andalus.abo_med7at.analyticalgeometry.ui.circle_activity

import com.andalus.abo_med7at.analyticalgeometry.models.Shape
import com.andalus.abo_med7at.analyticalgeometry.models.circle.Circle
import com.andalus.abo_med7at.analyticalgeometry.utils.Constants

interface CircleActivityContract {

    abstract class Presenter {
        abstract var view: View
        abstract var circle: Circle
        abstract var isValid: Boolean
        fun onDrawPressed(){
            if (isValid)
                view.navigateToDrawingClass(circle)
            else
                view.showMessage(Constants.Messages.MISSING_DATA)
        }
    }

    interface View {
        fun navigateToDrawingClass(shape: Shape)
        fun showMessage(text: String)
    }

}