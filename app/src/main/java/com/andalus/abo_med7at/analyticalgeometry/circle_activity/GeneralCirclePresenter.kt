package com.andalus.abo_med7at.analyticalgeometry.circle_activity

import com.andalus.abo_med7at.analyticalgeometry.models.circle.Circle
import com.andalus.abo_med7at.analyticalgeometry.models.circle.GeneralCircle

class GeneralCirclePresenter(override var view: CircleActivityContract.View)
    : CircleActivityContract.Presenter() {

    override lateinit var circle: Circle
    override var isValid = false

    fun validateAndSetValues(a: String, b: String, g: String, f: String, c: String) {
        try {
            circle = GeneralCircle()
            val generalCircle: GeneralCircle = circle as GeneralCircle
            generalCircle.a = a.toDouble()
            generalCircle.b = b.toDouble()
            generalCircle.g = g.toDouble()
            generalCircle.f = f.toDouble()
            generalCircle.c = c.toDouble()
            isValid = true
        } catch (e: Exception) {
            isValid = false
            e.printStackTrace()
        }
    }

}