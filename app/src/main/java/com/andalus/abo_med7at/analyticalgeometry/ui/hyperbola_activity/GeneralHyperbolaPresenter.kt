package com.andalus.abo_med7at.analyticalgeometry.ui.hyperbola_activity

import com.andalus.abo_med7at.analyticalgeometry.models.hyperbola.GeneralHyperbola
import com.andalus.abo_med7at.analyticalgeometry.models.hyperbola.Hyperbola

class GeneralHyperbolaPresenter(override var view: HyperbolaActivityContract.View) : HyperbolaActivityContract.Presenter() {

    override lateinit var hyperbola: Hyperbola
    override var isValid: Boolean = false

    fun validateAndSetValues(a: String, b: String, d: String, e: String, f: String) {
        try {
            hyperbola = GeneralHyperbola()
            val generalHyperbola = hyperbola as GeneralHyperbola
            generalHyperbola.a = a.toDouble()
            generalHyperbola.b = b.toDouble()
            generalHyperbola.d = d.toDouble()
            generalHyperbola.e = e.toDouble()
            generalHyperbola.f = f.toDouble()
            isValid = true
        } catch (e: Exception) {
            e.printStackTrace()
            isValid = false
        }
    }
}