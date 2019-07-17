package com.andalus.abo_med7at.analyticalgeometry.ui.main_activity

interface MainActivityContract {

    interface View {
        fun navigateToPairActivity()
        fun navigateToCircleActivity()
        fun navigateToParabolaActivity()
        fun navigateToEllipseActivity()
        fun navigateToHyperbolaActivity()
        fun navigateToGeneralActivity()
        fun loadAd()
        fun navigateToPrivacyPolicyWebsite()
        fun navigateToUpdateWebsite()
        fun loadUpdateDialog()
        fun loadLaunchingIntent()
    }

    interface Presenter {
        fun onPairButtonClicked()
        fun onCircleButtonClicked()
        fun onParabolaButtonClicked()
        fun onEllipseButtonClicked()
        fun onHyperbolaButtonClicked()
        fun onGeneralButtonClicked()
        fun start()
        fun onPrivacyPolicyItemSelected()
    }
}