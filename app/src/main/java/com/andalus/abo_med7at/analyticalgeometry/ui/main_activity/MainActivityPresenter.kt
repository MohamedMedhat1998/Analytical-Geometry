package com.andalus.abo_med7at.analyticalgeometry.ui.main_activity

import com.andalus.abo_med7at.analyticalgeometry.utils.PreferencesAccessor

class MainActivityPresenter(private val view: MainActivityContract.View, private val accessor: PreferencesAccessor) : MainActivityContract.Presenter {

    override fun onPrivacyPolicyItemSelected() {
        view.navigateToPrivacyPolicyWebsite()
    }

    override fun start() {
        view.loadAd()
        view.loadLaunchingIntent()
        if (accessor.shouldWelcome())
            view.navigateToWelcomeActivity()
    }

    override fun onPairButtonClicked() {
        view.navigateToPairActivity()
    }

    override fun onCircleButtonClicked() {
        view.navigateToCircleActivity()
    }

    override fun onParabolaButtonClicked() {
        view.navigateToParabolaActivity()
    }

    override fun onEllipseButtonClicked() {
        view.navigateToEllipseActivity()
    }

    override fun onHyperbolaButtonClicked() {
        view.navigateToHyperbolaActivity()
    }

    override fun onGeneralButtonClicked() {
        view.navigateToGeneralActivity()
    }

}