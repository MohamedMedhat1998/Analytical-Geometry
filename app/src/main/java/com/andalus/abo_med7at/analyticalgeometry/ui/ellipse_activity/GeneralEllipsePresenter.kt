package com.andalus.abo_med7at.analyticalgeometry.ui.ellipse_activity

import com.andalus.abo_med7at.analyticalgeometry.models.Shape
import com.andalus.abo_med7at.analyticalgeometry.models.ellipse.GeneralEllipse
import com.andalus.abo_med7at.analyticalgeometry.ui.BaseView

class GeneralEllipsePresenter(override var view: BaseView) : EllipseActivityContract.Presenter() {

    override lateinit var shape: Shape
    override var isValid: Boolean = false

    fun validateAndSetValues(a: String, c: String, d: String, e: String, f: String) {
        try {
            shape = GeneralEllipse(a.toDouble(), c.toDouble(), d.toDouble(), e.toDouble(), f.toDouble())
            isValid = true
        } catch (e: Exception) {
            e.printStackTrace()
            isValid = false
        }
    }
}