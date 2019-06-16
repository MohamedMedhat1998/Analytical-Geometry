package com.andalus.abo_med7at.analyticalgeometry.circle_activity

import com.andalus.abo_med7at.analyticalgeometry.models.circle.Circle
import com.andalus.abo_med7at.analyticalgeometry.models.circle.StandardCircle
import com.andalus.abo_med7at.analyticalgeometry.utils.Constants
import java.lang.Exception

class CircleActivityPresenter(private val view: CircleActivityContract.View) :
        CircleActivityContract.Presenter {

    private lateinit var circle: Circle
    private var isValid = false

    override fun onDrawPressed() {
        if (isValid)
            view.navigateToDrawingClass(circle)
        else
            view.showMessage(Constants.Messages.MISSING_DATA)
    }

    override fun validateAndSetValues(h: String?, k: String?, r: String?) {
        try {
            circle = StandardCircle()
            (circle as StandardCircle).h = h!!.toDouble()
            (circle as StandardCircle).k = k!!.toDouble()
            (circle as StandardCircle).r = r!!.toDouble()
            isValid = true
        } catch (e: Exception) {
            isValid = false
        }
    }

}