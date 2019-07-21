package com.andalus.abo_med7at.analyticalgeometry.ui.main_activity

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.andalus.abo_med7at.analyticalgeometry.R
import com.andalus.abo_med7at.analyticalgeometry.ui.circle_activity.CircleActivity
import com.andalus.abo_med7at.analyticalgeometry.ui.ellipse_activity.EllipseActivity
import com.andalus.abo_med7at.analyticalgeometry.ui.general_activity.GeneralActivity
import com.andalus.abo_med7at.analyticalgeometry.ui.hyperbola_activity.HyperbolaActivity
import com.andalus.abo_med7at.analyticalgeometry.ui.pair_activity.PairActivity
import com.andalus.abo_med7at.analyticalgeometry.ui.parabola_activity.ParabolaActivity
import com.andalus.abo_med7at.analyticalgeometry.ui.welcome_activity.WelcomeActivity
import com.andalus.abo_med7at.analyticalgeometry.utils.PreferencesAccessor
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.MobileAds
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), MainActivityContract.View {

    private val presenter = MainActivityPresenter(this, PreferencesAccessor(this))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter.start()

        btnPairOfLine.setOnClickListener {
            presenter.onPairButtonClicked()
        }
        btnCircle.setOnClickListener {
            presenter.onCircleButtonClicked()
        }
        btnParabola.setOnClickListener {
            presenter.onParabolaButtonClicked()
        }
        btnEllipse.setOnClickListener {
            presenter.onEllipseButtonClicked()
        }
        btnHyperbola.setOnClickListener {
            presenter.onHyperbolaButtonClicked()
        }
        btnGeneral.setOnClickListener {
            presenter.onGeneralButtonClicked()
        }

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = MenuInflater(this)
        inflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.item_privacy_policy) {
            presenter.onPrivacyPolicyItemSelected()
        }
        return true
    }

    override fun navigateToPairActivity() {
        startActivity(Intent(this, PairActivity::class.java))
    }

    override fun navigateToCircleActivity() {
        startActivity(Intent(this, CircleActivity::class.java))
    }

    override fun navigateToParabolaActivity() {
        startActivity(Intent(this, ParabolaActivity::class.java))
    }

    override fun navigateToEllipseActivity() {
        startActivity(Intent(this, EllipseActivity::class.java))
    }

    override fun navigateToHyperbolaActivity() {
        startActivity(Intent(this, HyperbolaActivity::class.java))
    }

    override fun navigateToGeneralActivity() {
        startActivity(Intent(this, GeneralActivity::class.java))
    }

    override fun loadAd() {
        MobileAds.initialize(this, getString(R.string.ADMOB_APP_ID))
        val adRequest = AdRequest.Builder().build()
        adView.loadAd(adRequest)
    }

    override fun navigateToPrivacyPolicyWebsite() {
        val privacyPolicyIntent = Intent(Intent.ACTION_VIEW)
        privacyPolicyIntent.data = Uri.parse(getString(R.string.privacy_policy_link))
        startActivity(privacyPolicyIntent)
    }

    override fun navigateToUpdateWebsite() {
        val updateIntent = Intent(Intent.ACTION_VIEW)
        updateIntent.data = Uri.parse(getString(R.string.update_link))
        startActivity(updateIntent)
    }

    override fun loadUpdateDialog() {
        with(AlertDialog.Builder(this)) {
            setTitle(getString(R.string.update_dialog_label))
            setMessage(getString(R.string.update_dialog_message))
            setPositiveButton(getString(R.string.update_now)) { _, _ ->
                navigateToUpdateWebsite()
            }
            setNegativeButton(getString(R.string.remind_me_later), null)
            show()
        }
    }

    override fun loadLaunchingIntent() {
        if (intent.extras != null)
            loadUpdateDialog()
    }

    override fun navigateToWelcomeActivity() {
        startActivity(Intent(this, WelcomeActivity::class.java))
        finish()
    }

}