package com.andalus.abo_med7at.analyticalgeometry.ui.drawing_activity

class DrawingActivityPresenter(private val view: DrawingActivityContract.View)
    : DrawingActivityContract.Presenter {

    override fun start() {
        view.receiveExtras()
        view.setTitle()
        view.loadDrawingFragment()
    }
}