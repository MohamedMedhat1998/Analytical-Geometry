package com.andalus.abo_med7at.analyticalgeometry.ui.parabola_activity

import com.andalus.abo_med7at.analyticalgeometry.models.parabola.Parabola
import com.andalus.abo_med7at.analyticalgeometry.models.parabola.StandardXParabola
import kotlin.Exception

class StandardXParabolaPresenter(override var view: ParabolaActivityContract.View) : ParabolaActivityContract.Presenter() {

    override lateinit var parabola: Parabola
    override var isValid: Boolean = false

    fun validateAndSetValues(k: String, a: String, h: String) {
        try {
            parabola = StandardXParabola()
            val standardXParabola = parabola as StandardXParabola
            standardXParabola.k = k.toDouble()
            standardXParabola.a = a.toDouble()
            standardXParabola.h = h.toDouble()
            isValid = true
        }catch (e: Exception){
            e.printStackTrace()
            isValid = false
        }

    }
}