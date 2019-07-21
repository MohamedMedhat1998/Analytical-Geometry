package com.andalus.abo_med7at.analyticalgeometry.ui.welcome_activity

class WelcomeActivityPresenter(val view : WelcomeActivityContract.View) : WelcomeActivityContract.Presenter {
    override fun start() {
        view.loadViewPager()
    }
}