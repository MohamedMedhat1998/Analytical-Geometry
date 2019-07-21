package com.andalus.abo_med7at.analyticalgeometry.ui.welcome_fragments


import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.andalus.abo_med7at.analyticalgeometry.R
import com.andalus.abo_med7at.analyticalgeometry.ui.main_activity.MainActivity
import com.andalus.abo_med7at.analyticalgeometry.utils.PreferencesAccessor
import kotlinx.android.synthetic.main.fragment_get_started.view.*


class GetStartedFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_get_started, container, false)
        val startMainFinishThis: (view: View) -> Unit = {
            startActivity(Intent(activity, MainActivity::class.java))
            activity?.finish()
        }
        view.ivGetStarted.setOnClickListener(startMainFinishThis)
        view.btnGetStarted.setOnClickListener(startMainFinishThis)
        PreferencesAccessor(context!!).setShouldWelcome(false)
        return view
    }


    companion object {
        @JvmStatic
        fun newInstance() = GetStartedFragment()
    }
}
