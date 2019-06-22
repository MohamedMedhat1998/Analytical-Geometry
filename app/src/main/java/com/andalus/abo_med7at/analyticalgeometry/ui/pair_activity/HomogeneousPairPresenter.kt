package com.andalus.abo_med7at.analyticalgeometry.ui.pair_activity

import com.andalus.abo_med7at.analyticalgeometry.models.pair_of_lines.HomogeneousPair
import com.andalus.abo_med7at.analyticalgeometry.models.pair_of_lines.PairOfLines

class HomogeneousPairPresenter(override var view: PairActivityContract.View) : PairActivityContract.Presenter() {

    override lateinit var pairOfLines: PairOfLines
    override var isValid: Boolean = false

    fun validateAndSetValues(a: String, h: String, b: String) {
        try {
            pairOfLines = HomogeneousPair()
            val homogeneousPair = pairOfLines as HomogeneousPair
            homogeneousPair.a = a.toDouble()
            homogeneousPair.h = h.toDouble()
            homogeneousPair.b = b.toDouble()
            isValid = true
        }catch (e: Exception){
            isValid = false
            e.printStackTrace()
        }

    }
}