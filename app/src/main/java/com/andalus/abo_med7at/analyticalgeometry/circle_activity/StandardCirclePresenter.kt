package com.andalus.abo_med7at.analyticalgeometry.circle_activity

import com.andalus.abo_med7at.analyticalgeometry.models.circle.Circle
import com.andalus.abo_med7at.analyticalgeometry.models.circle.StandardCircle
import com.andalus.abo_med7at.analyticalgeometry.utils.Constants
import java.lang.Exception

class StandardCirclePresenter(override var view: CircleActivityContract.View) :
        CircleActivityContract.Presenter() {

    override lateinit var circle: Circle
    override var isValid: Boolean = false

    fun validateAndSetValues(h: String, k: String, r: String) {
        try {
            circle = StandardCircle()
            val standardCircle = circle as StandardCircle
            standardCircle.h = h.toDouble()
            standardCircle.k = k.toDouble()
            standardCircle.r = r.toDouble()
            isValid = true
        } catch (e: Exception) {
            isValid = false
            e.printStackTrace()
        }
    }

}