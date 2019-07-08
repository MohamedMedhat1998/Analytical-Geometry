package com.andalus.abo_med7at.analyticalgeometry.ui.parabola_activity

import com.andalus.abo_med7at.analyticalgeometry.models.Shape
import com.andalus.abo_med7at.analyticalgeometry.models.parabola.StandardYParabola
import com.andalus.abo_med7at.analyticalgeometry.ui.BaseView

class StandardYParabolaPresenter(override var view: BaseView) : ParabolaActivityContract.Presenter() {

    override lateinit var shape: Shape
    override var isValid: Boolean = false

    fun validateAndSetValues(h: String, b: String, k: String) {
        try {
            shape = StandardYParabola(h.toDouble(), b.toDouble(), k.toDouble())
            isValid = true
        } catch (e: Exception) {
            e.printStackTrace()
            isValid = false
        }
    }

}