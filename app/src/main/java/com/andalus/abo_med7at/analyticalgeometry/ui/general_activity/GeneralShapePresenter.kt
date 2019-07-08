package com.andalus.abo_med7at.analyticalgeometry.ui.general_activity

import com.andalus.abo_med7at.analyticalgeometry.models.GeneralShape
import com.andalus.abo_med7at.analyticalgeometry.models.Shape
import com.andalus.abo_med7at.analyticalgeometry.ui.BaseView

class GeneralShapePresenter(override var view: BaseView) : GeneralActivityContract.Presenter() {

    override lateinit var shape: Shape
    override var isValid: Boolean = false

    fun validateAndSetValues(a: String, h: String, b: String, g: String, f: String, c: String) {
        try {
            shape = GeneralShape(a.toDouble(), h.toDouble(), b.toDouble(), g.toDouble(), f.toDouble(), c.toDouble())
            isValid = true
        } catch (e: Exception) {
            e.printStackTrace()
            isValid = false
        }
    }
}