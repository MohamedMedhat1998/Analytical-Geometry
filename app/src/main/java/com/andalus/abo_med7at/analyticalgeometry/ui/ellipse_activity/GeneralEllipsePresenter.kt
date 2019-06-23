package com.andalus.abo_med7at.analyticalgeometry.ui.ellipse_activity

import com.andalus.abo_med7at.analyticalgeometry.models.ellipse.Ellipse
import com.andalus.abo_med7at.analyticalgeometry.models.ellipse.GeneralEllipse
import java.lang.Exception

class GeneralEllipsePresenter(override var view: EllipseActivityContract.View) : EllipseActivityContract.Presenter() {

    override lateinit var ellipse: Ellipse
    override var isValid: Boolean = false

    fun validateAndSetValues(a: String, c: String, d: String, e: String, f: String) {
        try {
            ellipse = GeneralEllipse()
            val generalEllipse = ellipse as GeneralEllipse
            generalEllipse.a = a.toDouble()
            generalEllipse.c = c.toDouble()
            generalEllipse.d = d.toDouble()
            generalEllipse.e = e.toDouble()
            generalEllipse.f = f.toDouble()
            isValid = true
        } catch (e: Exception) {
            e.printStackTrace()
            isValid = false
        }
    }
}