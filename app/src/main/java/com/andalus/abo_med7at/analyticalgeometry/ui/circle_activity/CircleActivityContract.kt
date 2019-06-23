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
                view.navigateToDrawingActivity(circle)
            else
                view.showMessage(Constants.Messages.MISSING_DATA)
        }
    }

    interface View {
        fun navigateToDrawingActivity(shape: Shape)
        fun showMessage(text: String)
    }

}