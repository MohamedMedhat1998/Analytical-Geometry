package com.andalus.abo_med7at.analyticalgeometry.ui.welcome_fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.andalus.abo_med7at.analyticalgeometry.R


class BugFixesFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_bug_fixes, container, false)
    }


    companion object {
        @JvmStatic
        fun newInstance() = BugFixesFragment()
    }
}
