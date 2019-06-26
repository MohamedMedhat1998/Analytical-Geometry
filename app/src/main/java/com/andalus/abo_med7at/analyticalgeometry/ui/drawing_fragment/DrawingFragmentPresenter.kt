package com.andalus.abo_med7at.analyticalgeometry.ui.drawing_fragment

import com.andalus.abo_med7at.analyticalgeometry.utils.Constants.Messages.ZOOM_MESSAGE

class DrawingFragmentPresenter(private val view: DrawingFragmentContract.View) :
        DrawingFragmentContract.Presenter {

    override fun start() {
        view.createCoordinatePlane()
        view.showMessage(ZOOM_MESSAGE)
    }

}