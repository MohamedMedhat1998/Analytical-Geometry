package com.andalus.abo_med7at.analyticalgeometry.ui.pair_activity

import com.andalus.abo_med7at.analyticalgeometry.models.pair_of_lines.PairOfLines
import com.andalus.abo_med7at.analyticalgeometry.models.Shape
import com.andalus.abo_med7at.analyticalgeometry.utils.Constants

interface PairActivityContract {

    abstract class Presenter {
        abstract var view: View
        abstract var pairOfLines: PairOfLines
        abstract var isValid: Boolean
        fun onDrawPressed(){
            if (isValid)
                view.navigateToDrawingActivity(pairOfLines)
            else
                view.showMessage(Constants.Messages.MISSING_DATA)
        }
    }

    interface View {
        fun navigateToDrawingActivity(shape: Shape)
        fun showMessage(text: String)
    }

}