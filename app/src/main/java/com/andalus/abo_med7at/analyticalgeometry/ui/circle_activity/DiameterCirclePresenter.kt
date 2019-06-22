package com.andalus.abo_med7at.analyticalgeometry.ui.circle_activity

import com.andalus.abo_med7at.analyticalgeometry.models.circle.Circle
import com.andalus.abo_med7at.analyticalgeometry.models.circle.DiameterCircle
import java.lang.Exception

class DiameterCirclePresenter(override var view: CircleActivityContract.View) : CircleActivityContract.Presenter() {

    override lateinit var circle: Circle
    override var isValid: Boolean = false

    fun validateAndSetValues(x1: String, x2: String, y1: String, y2: String) {
        try {
            circle = DiameterCircle()
            val diameterCircle = circle as DiameterCircle
            diameterCircle.x1 = x1.toDouble()
            diameterCircle.x2 = x2.toDouble()
            diameterCircle.y1 = y1.toDouble()
            diameterCircle.y2 = y2.toDouble()
            isValid = true
        } catch (e: Exception) {
            isValid = false
            e.printStackTrace()
        }
    }

}