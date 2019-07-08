package com.andalus.abo_med7at.analyticalgeometry.ui

import com.andalus.abo_med7at.analyticalgeometry.models.Shape
import com.andalus.abo_med7at.analyticalgeometry.utils.Constants

abstract class BasePresenter {

    abstract var view: BaseView
    abstract var shape: Shape
    abstract var isValid: Boolean

    fun onDrawPressed() {
        if (isValid)
            if (shape.canDraw())
                view.navigateToDrawingActivity(shape)
            else
                view.showMessage(shape.unableToDrawMessage)
        else
            view.showMessage(Constants.Messages.MISSING_DATA)
    }

}