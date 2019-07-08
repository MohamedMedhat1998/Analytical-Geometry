package com.andalus.abo_med7at.analyticalgeometry.ui.circle_activity

import com.andalus.abo_med7at.analyticalgeometry.models.Shape
import com.andalus.abo_med7at.analyticalgeometry.models.circle.GeneralCircle
import com.andalus.abo_med7at.analyticalgeometry.ui.BaseView

class GeneralCirclePresenter(override var view: BaseView)
    : CircleActivityContract.Presenter() {

    override lateinit var shape: Shape
    override var isValid = false

    fun validateAndSetValues(a: String, b: String, g: String, f: String, c: String) {
        try {
            shape = GeneralCircle(a.toDouble(), b.toDouble(), g.toDouble(), f.toDouble(), c.toDouble())
            isValid = true
        } catch (e: Exception) {
            isValid = false
            e.printStackTrace()
        }
    }

}