package com.andalus.abo_med7at.analyticalgeometry.ui.parabola_activity

import com.andalus.abo_med7at.analyticalgeometry.models.Shape
import com.andalus.abo_med7at.analyticalgeometry.models.parabola.GeneralXParabola
import com.andalus.abo_med7at.analyticalgeometry.ui.BaseView

class GeneralXParabolaPresenter(override var view: BaseView) : ParabolaActivityContract.Presenter() {

    override lateinit var shape: Shape
    override var isValid: Boolean = false

    fun validateAndSetValues(d: String, e: String, f: String) {
        try {
            shape = GeneralXParabola(d.toDouble(), e.toDouble(), f.toDouble())
            isValid = true
        } catch (e: Exception) {
            e.printStackTrace()
            isValid = false
        }
    }
}