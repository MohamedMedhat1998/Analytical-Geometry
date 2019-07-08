package com.andalus.abo_med7at.analyticalgeometry.ui.circle_activity

import com.andalus.abo_med7at.analyticalgeometry.models.Shape
import com.andalus.abo_med7at.analyticalgeometry.models.circle.StandardCircle
import com.andalus.abo_med7at.analyticalgeometry.ui.BaseView

class StandardCirclePresenter(override var view: BaseView) :
        CircleActivityContract.Presenter() {

    override lateinit var shape: Shape
    override var isValid: Boolean = false

    fun validateAndSetValues(h: String, k: String, r: String) {
        try {
            shape = StandardCircle(h.toDouble(), k.toDouble(), r.toDouble())
            isValid = true
        } catch (e: Exception) {
            isValid = false
            e.printStackTrace()
        }
    }

}