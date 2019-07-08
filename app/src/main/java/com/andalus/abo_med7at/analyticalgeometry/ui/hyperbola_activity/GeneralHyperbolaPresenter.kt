package com.andalus.abo_med7at.analyticalgeometry.ui.hyperbola_activity

import com.andalus.abo_med7at.analyticalgeometry.models.Shape
import com.andalus.abo_med7at.analyticalgeometry.models.hyperbola.GeneralHyperbola
import com.andalus.abo_med7at.analyticalgeometry.ui.BaseView

class GeneralHyperbolaPresenter(override var view: BaseView) : HyperbolaActivityContract.Presenter() {

    override lateinit var shape: Shape
    override var isValid: Boolean = false

    fun validateAndSetValues(a: String, b: String, d: String, e: String, f: String) {
        try {
            shape = GeneralHyperbola(a.toDouble(), b.toDouble(), d.toDouble(), e.toDouble(), f.toDouble())
            isValid = true
        } catch (e: Exception) {
            e.printStackTrace()
            isValid = false
        }
    }
}