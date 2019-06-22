package com.andalus.abo_med7at.analyticalgeometry.ui.pair_activity

import com.andalus.abo_med7at.analyticalgeometry.models.pair_of_lines.GeneralPair
import com.andalus.abo_med7at.analyticalgeometry.models.pair_of_lines.PairOfLines
import java.lang.Exception

class GeneralPairPresenter(override var view: PairActivityContract.View) : PairActivityContract.Presenter() {

    override lateinit var pairOfLines: PairOfLines
    override var isValid: Boolean = false

    fun validateAndSetValues(a: String, h: String, b: String, g: String, f: String, c: String) {
        try {
            pairOfLines = GeneralPair()
            val generalPair = pairOfLines as GeneralPair
            generalPair.a = a.toDouble()
            generalPair.h = h.toDouble()
            generalPair.b = b.toDouble()
            generalPair.g = g.toDouble()
            generalPair.f = f.toDouble()
            generalPair.c = c.toDouble()
            isValid = true
        } catch (e: Exception) {
            e.printStackTrace()
            isValid = false
        }
    }

}