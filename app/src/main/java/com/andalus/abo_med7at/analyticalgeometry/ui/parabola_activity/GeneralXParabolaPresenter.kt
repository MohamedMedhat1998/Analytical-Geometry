package com.andalus.abo_med7at.analyticalgeometry.ui.parabola_activity

import com.andalus.abo_med7at.analyticalgeometry.models.parabola.GeneralXParabola
import com.andalus.abo_med7at.analyticalgeometry.models.parabola.Parabola

class GeneralXParabolaPresenter(override var view: ParabolaActivityContract.View) : ParabolaActivityContract.Presenter() {

    override lateinit var parabola: Parabola
    override var isValid: Boolean = false

    fun validateAndSetValues(d: String, e: String, f: String) {
        try {
            parabola = GeneralXParabola()
            val generalXParabola = parabola as GeneralXParabola
            generalXParabola.d = d.toDouble()
            generalXParabola.e = e.toDouble()
            generalXParabola.f = f.toDouble()
            isValid = true
        }catch (e: Exception){
            e.printStackTrace()
            isValid = false
        }
    }
}