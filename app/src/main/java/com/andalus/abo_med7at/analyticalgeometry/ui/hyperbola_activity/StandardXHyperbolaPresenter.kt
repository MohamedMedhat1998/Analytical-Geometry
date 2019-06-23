package com.andalus.abo_med7at.analyticalgeometry.ui.hyperbola_activity

import com.andalus.abo_med7at.analyticalgeometry.models.hyperbola.Hyperbola
import com.andalus.abo_med7at.analyticalgeometry.models.hyperbola.StandardXHyperbola

class StandardXHyperbolaPresenter(override var view: HyperbolaActivityContract.View) : HyperbolaActivityContract.Presenter() {

    override lateinit var hyperbola: Hyperbola
    override var isValid: Boolean = false

    fun validateAndSetValues(a: String, b: String) {
        try {
            hyperbola = StandardXHyperbola()
            val standardXHyperbola = hyperbola as StandardXHyperbola
            standardXHyperbola.a = a.toDouble()
            standardXHyperbola.b = b.toDouble()
            isValid = true
        } catch (e: Exception) {
            e.printStackTrace()
            isValid = false
        }
    }
}