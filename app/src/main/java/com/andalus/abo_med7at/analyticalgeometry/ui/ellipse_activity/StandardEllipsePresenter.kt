package com.andalus.abo_med7at.analyticalgeometry.ui.ellipse_activity

import com.andalus.abo_med7at.analyticalgeometry.models.ellipse.Ellipse
import com.andalus.abo_med7at.analyticalgeometry.models.ellipse.StandardEllipse

class StandardEllipsePresenter(override var view: EllipseActivityContract.View) : EllipseActivityContract.Presenter() {

    override lateinit var ellipse: Ellipse
    override var isValid: Boolean = false

    fun validateAndSetValues(a: String, b: String) {
        try {
            ellipse = StandardEllipse()
            val standardEllipse = ellipse as StandardEllipse
            standardEllipse.a = a.toDouble()
            standardEllipse.b = b.toDouble()
            isValid = true
        } catch (e: Exception) {
            e.printStackTrace()
            isValid = false
        }
    }
}