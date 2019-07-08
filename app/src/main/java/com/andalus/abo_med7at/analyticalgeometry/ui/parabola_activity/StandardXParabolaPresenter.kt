package com.andalus.abo_med7at.analyticalgeometry.ui.parabola_activity

import com.andalus.abo_med7at.analyticalgeometry.models.Shape
import com.andalus.abo_med7at.analyticalgeometry.models.parabola.StandardXParabola
import com.andalus.abo_med7at.analyticalgeometry.ui.BaseView

class StandardXParabolaPresenter(override var view: BaseView) : ParabolaActivityContract.Presenter() {

    override lateinit var shape: Shape
    override var isValid: Boolean = false

    fun validateAndSetValues(k: String, a: String, h: String) {
        try {
            shape = StandardXParabola(k.toDouble(), a.toDouble(), h.toDouble())
            isValid = true
        } catch (e: Exception) {
            e.printStackTrace()
            isValid = false
        }

    }
}