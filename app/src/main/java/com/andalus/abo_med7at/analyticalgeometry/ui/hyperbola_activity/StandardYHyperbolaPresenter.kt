package com.andalus.abo_med7at.analyticalgeometry.ui.hyperbola_activity

import com.andalus.abo_med7at.analyticalgeometry.models.Shape
import com.andalus.abo_med7at.analyticalgeometry.models.hyperbola.StandardYHyperbola
import com.andalus.abo_med7at.analyticalgeometry.ui.BaseView

class StandardYHyperbolaPresenter(override var view: BaseView) : HyperbolaActivityContract.Presenter() {

    override lateinit var shape: Shape
    override var isValid: Boolean = false

    fun validateAndSetValues(a: String, b: String) {
        try {
            shape = StandardYHyperbola(a.toDouble(), b.toDouble())
            isValid = true
        } catch (e: Exception) {
            e.printStackTrace()
            isValid = false
        }

    }
}