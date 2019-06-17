package com.andalus.abo_med7at.analyticalgeometry.main_activity

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
    }

    interface Presenter {
        fun onPairButtonClicked()
        fun onCircleButtonClicked()
        fun onParabolaButtonClicked()
        fun onEllipseButtonClicked()
        fun onHyperbolaButtonClicked()
        fun onGeneralButtonClicked()
        fun loadImportantComponents()
        fun onPrivacyPolicyItemSelected()
    }
}