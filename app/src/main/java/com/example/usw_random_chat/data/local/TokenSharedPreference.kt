package com.example.usw_random_chat.data.local

import android.content.Context
import android.content.SharedPreferences
import dagger.hilt.android.qualifiers.ApplicationContext
import java.util.prefs.Preferences
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TokenSharedPreference @Inject constructor(@ApplicationContext context: Context)  {
    private val prefs : SharedPreferences =
        context.getSharedPreferences("tokenRepo", Context.MODE_PRIVATE)

    fun getToken(key: String, defValue: String): String {
        return prefs.getString(key, defValue).toString()
    }

    fun setToken(key: String, str: String) {
        prefs.edit().putString(key, str).apply()
    }
}