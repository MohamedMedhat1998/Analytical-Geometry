package com.andalus.abo_med7at.analyticalgeometry.ui.drawing_fragment

interface DrawingFragmentContract {

    interface Presenter {
        fun start()
    }

    interface View {
        fun createCoordinatePlane()
        fun showMessage(text:String)
    }

}