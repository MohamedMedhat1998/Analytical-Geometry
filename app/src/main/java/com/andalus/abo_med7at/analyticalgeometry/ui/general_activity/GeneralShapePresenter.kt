package com.andalus.abo_med7at.analyticalgeometry.ui.general_activity

import com.andalus.abo_med7at.analyticalgeometry.models.GeneralShape
import com.andalus.abo_med7at.analyticalgeometry.models.Shape

class GeneralShapePresenter(override var view: GeneralActivityContract.View) : GeneralActivityContract.Presenter() {

    override lateinit var shape: Shape
    override var isValid: Boolean = false

    fun validateAndSetValues(a: String, h: String, b: String, g: String, f: String, c: String) {
        try {
            shape = GeneralShape()
            val generalShape = shape as GeneralShape
            generalShape.a = a.toDouble()
            generalShape.h = h.toDouble()
            generalShape.b = b.toDouble()
            generalShape.g = g.toDouble()
            generalShape.f = f.toDouble()
            generalShape.c = c.toDouble()
            isValid = true
        } catch (e: Exception) {
            e.printStackTrace()
            isValid = false
        }
    }
}