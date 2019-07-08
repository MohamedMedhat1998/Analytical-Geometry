package com.andalus.abo_med7at.analyticalgeometry.ui.parabola_activity

import com.andalus.abo_med7at.analyticalgeometry.models.Shape
import com.andalus.abo_med7at.analyticalgeometry.models.parabola.GeneralYParabola
import com.andalus.abo_med7at.analyticalgeometry.ui.BaseView

class GeneralYParabolaPresenter(override var view: BaseView) : ParabolaActivityContract.Presenter() {

    override lateinit var shape: Shape
    override var isValid: Boolean = false

    fun validateAndSetValues(d: String, e: String, f: String) {
        try {
            shape = GeneralYParabola(d.toDouble(), e.toDouble(), f.toDouble())
            isValid = true
        } catch (e: Exception) {
            e.printStackTrace()
            isValid = false
        }
    }
}