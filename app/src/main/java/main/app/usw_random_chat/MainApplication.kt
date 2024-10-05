package main.app.usw_random_chat

import android.app.Application
import main.app.usw_random_chat.data.local.TokenSharedPreference
import dagger.hilt.android.HiltAndroidApp


@HiltAndroidApp
class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        prefs =
            TokenSharedPreference(applicationContext)
    }

    companion object {
        lateinit var prefs: TokenSharedPreference
    }
}