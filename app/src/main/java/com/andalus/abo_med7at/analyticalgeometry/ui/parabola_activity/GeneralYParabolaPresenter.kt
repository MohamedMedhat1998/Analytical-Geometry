package com.andalus.abo_med7at.analyticalgeometry.ui.parabola_activity

import com.andalus.abo_med7at.analyticalgeometry.models.parabola.GeneralYParabola
import com.andalus.abo_med7at.analyticalgeometry.models.parabola.Parabola

class GeneralYParabolaPresenter(override var view: ParabolaActivityContract.View) : ParabolaActivityContract.Presenter() {

    override lateinit var parabola: Parabola
    override var isValid: Boolean = false

    fun validateAndSetValues(d: String, e: String, f: String) {
        try {
            parabola = GeneralYParabola()
            val generalYParabola = parabola as GeneralYParabola
            generalYParabola.d = d.toDouble()
            generalYParabola.e = e.toDouble()
            generalYParabola.f = f.toDouble()
            isValid = true
        }catch (e:Exception){
            e.printStackTrace()
            isValid = false
        }
    }
}