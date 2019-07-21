package com.andalus.abo_med7at.analyticalgeometry.ui.welcome_activity

interface WelcomeActivityContract {

    interface Presenter{
        fun start()
    }

    interface View{
        fun loadViewPager()
    }

}