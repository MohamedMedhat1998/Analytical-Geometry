package com.andalus.abo_med7at.analyticalgeometry.ui.ellipse_activity

import com.andalus.abo_med7at.analyticalgeometry.models.Shape
import com.andalus.abo_med7at.analyticalgeometry.models.ellipse.Ellipse
import com.andalus.abo_med7at.analyticalgeometry.utils.Constants

interface EllipseActivityContract  {

    abstract class Presenter {
        abstract var view: View
        abstract var ellipse: Ellipse
        abstract var isValid: Boolean
        fun onDrawPressed(){
            if (isValid)
                view.navigateToDrawingActivity(ellipse)
            else
                view.showMessage(Constants.Messages.MISSING_DATA)
        }
    }

    interface View {
        fun navigateToDrawingActivity(shape: Shape)
        fun showMessage(text: String)
    }
}