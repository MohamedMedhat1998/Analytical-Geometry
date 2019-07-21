package com.andalus.abo_med7at.analyticalgeometry.utils

import android.content.Context
import android.preference.PreferenceManager
import com.andalus.abo_med7at.analyticalgeometry.utils.Constants.Keys.CAN_WELCOME

class PreferencesAccessor(val context: Context) {

    fun shouldWelcome(): Boolean {
        val prefs = PreferenceManager.getDefaultSharedPreferences(context)
        return prefs.getBoolean(CAN_WELCOME, true)
    }

    fun setShouldWelcome(canWelcome: Boolean) {
        val prefs = PreferenceManager.getDefaultSharedPreferences(context)
        prefs.edit().putBoolean(CAN_WELCOME, canWelcome).apply()
    }
}