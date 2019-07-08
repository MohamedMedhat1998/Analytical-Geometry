package com.andalus.abo_med7at.analyticalgeometry.ui.pair_activity

import com.andalus.abo_med7at.analyticalgeometry.models.Shape
import com.andalus.abo_med7at.analyticalgeometry.models.pair_of_lines.HomogeneousPair
import com.andalus.abo_med7at.analyticalgeometry.ui.BaseView

class HomogeneousPairPresenter(override var view: BaseView) : PairActivityContract.Presenter() {

    override lateinit var shape: Shape
    override var isValid: Boolean = false

    fun validateAndSetValues(a: String, h: String, b: String) {
        try {
            shape = HomogeneousPair(a.toDouble(), h.toDouble(), b.toDouble())
            isValid = true
        } catch (e: Exception) {
            isValid = false
            e.printStackTrace()
        }

    }
}