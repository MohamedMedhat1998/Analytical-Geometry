package com.andalus.abo_med7at.analyticalgeometry.ui.parabola_activity

import com.andalus.abo_med7at.analyticalgeometry.models.parabola.Parabola
import com.andalus.abo_med7at.analyticalgeometry.models.parabola.StandardYParabola

class StandardYParabolaPresenter(override var view: ParabolaActivityContract.View) : ParabolaActivityContract.Presenter() {

    override lateinit var parabola: Parabola
    override var isValid: Boolean = false

    fun validateAndSetValues(h: String, b: String, k: String) {
        try {
            parabola = StandardYParabola()
            val standardYParabola = parabola as StandardYParabola
            standardYParabola.h = h.toDouble()
            standardYParabola.b = b.toDouble()
            standardYParabola.k = k.toDouble()
            isValid = true
        } catch (e: Exception) {
            e.printStackTrace()
            isValid = false
        }
    }

}