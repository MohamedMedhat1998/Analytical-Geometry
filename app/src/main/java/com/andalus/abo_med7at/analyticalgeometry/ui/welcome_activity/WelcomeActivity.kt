package com.andalus.abo_med7at.analyticalgeometry.ui.welcome_activity

import android.os.Bundle
import android.view.Window
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.andalus.abo_med7at.analyticalgeometry.R
import com.andalus.abo_med7at.analyticalgeometry.ui.welcome_fragments.*
import kotlinx.android.synthetic.main.activity_welcome.*


class WelcomeActivity : AppCompatActivity(), WelcomeActivityContract.View {

    val presenter = WelcomeActivityPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.activity_welcome)

        presenter.start()

    }

    override fun loadViewPager() {
        vpWelcomeScreen.adapter = WelcomeScreenPagerAdapter(supportFragmentManager)
        tlWelcomeScreen.setupWithViewPager(vpWelcomeScreen)
    }

    private class WelcomeScreenPagerAdapter(fragmentManager: FragmentManager)
        : FragmentPagerAdapter(fragmentManager) {

        override fun getItem(position: Int): Fragment {
            return when (position) {
                0 -> SmootherExperienceFragment.newInstance()
                1 -> UiFragment.newInstance()
                2 -> EquationIndicatorFragment.newInstance()
                3 -> BugFixesFragment.newInstance()
                4 -> GetStartedFragment.newInstance()
                else -> SmootherExperienceFragment.newInstance()
            }
        }

        override fun getCount(): Int {
            return 5
        }

    }

}
