package com.andalus.abo_med7at.analyticalgeometry.ui.circle_activity

import com.andalus.abo_med7at.analyticalgeometry.models.Shape
import com.andalus.abo_med7at.analyticalgeometry.models.circle.DiameterCircle
import com.andalus.abo_med7at.analyticalgeometry.ui.BaseView

class DiameterCirclePresenter(override var view: BaseView) : CircleActivityContract.Presenter() {

    override lateinit var shape: Shape
    override var isValid: Boolean = false

    fun validateAndSetValues(x1: String, x2: String, y1: String, y2: String) {
        try {
            shape = DiameterCircle(x1.toDouble(), x2.toDouble(), y1.toDouble(), y2.toDouble())
            isValid = true
        } catch (e: Exception) {
            isValid = false
            e.printStackTrace()
        }
    }

}