package com.andalus.abo_med7at.analyticalgeometry.ui.ellipse_activity

import com.andalus.abo_med7at.analyticalgeometry.models.Shape
import com.andalus.abo_med7at.analyticalgeometry.models.ellipse.StandardEllipse
import com.andalus.abo_med7at.analyticalgeometry.ui.BaseView

class StandardEllipsePresenter(override var view: BaseView) : EllipseActivityContract.Presenter() {

    override lateinit var shape: Shape
    override var isValid: Boolean = false

    fun validateAndSetValues(a: String, b: String) {
        try {
            shape = StandardEllipse(a.toDouble(), b.toDouble())
            isValid = true
        } catch (e: Exception) {
            e.printStackTrace()
            isValid = false
        }
    }
}