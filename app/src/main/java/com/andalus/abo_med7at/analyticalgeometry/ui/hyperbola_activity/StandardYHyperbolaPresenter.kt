package com.andalus.abo_med7at.analyticalgeometry.ui.hyperbola_activity

import com.andalus.abo_med7at.analyticalgeometry.models.hyperbola.Hyperbola
import com.andalus.abo_med7at.analyticalgeometry.models.hyperbola.StandardYHyperbola
import java.lang.Exception

class StandardYHyperbolaPresenter(override var view: HyperbolaActivityContract.View) : HyperbolaActivityContract.Presenter() {

    override lateinit var hyperbola: Hyperbola
    override var isValid: Boolean = false

    fun validateAndSetValues(a: String, b: String) {
        try {
            hyperbola = StandardYHyperbola()
            val standardYHyperbola = hyperbola as StandardYHyperbola
            standardYHyperbola.a = a.toDouble()
            standardYHyperbola.b = b.toDouble()
            isValid = true
        } catch (e: Exception) {
            e.printStackTrace()
            isValid = false
        }

    }
}