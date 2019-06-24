package com.andalus.abo_med7at.analyticalgeometry.ui.drawing_activity

interface DrawingActivityContract {

    interface Presenter{
        fun start()
    }

    interface View{
        fun receiveExtras()
        fun loadDrawingFragment()
    }
}