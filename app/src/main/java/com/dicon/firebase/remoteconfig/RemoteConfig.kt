/*
package com.dicon.firebase.remoteconfig

import android.util.Log
import com.dicon.R
import com.google.firebase.ktx.Firebase
import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import com.google.firebase.remoteconfig.ktx.remoteConfig
import com.google.firebase.remoteconfig.ktx.remoteConfigSettings

class RemoteConfig {

    companion object{
        var appName = ""
        var appColor = ""
    }

    private var remoteConfig: FirebaseRemoteConfig = Firebase.remoteConfig

    init {
        init()
    }

    private fun init() {
        // [START enable_dev_mode]
        val configSettings = remoteConfigSettings {
            minimumFetchIntervalInSeconds = 3600
        }
        remoteConfig.setConfigSettingsAsync(configSettings)
        // [END enable_dev_mode]

        // [START set_default_values]
        remoteConfig.setDefaultsAsync(R.xml.remote_config_defaults)
        // [END set_default_values]
        fetchWelcome()
    }


    private fun fetchWelcome() {
        // [START fetch_config_with_callback]
        remoteConfig.fetchAndActivate()
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val updated = task.result
                } else {
                    Log.d("TAG", "Fetch failed ")
                }
                appUpdateMessage()
            }
        // [END fetch_config_with_callback]
    }

    private fun appUpdateMessage() {
        appName = remoteConfig.getString("app_name")
        appColor = remoteConfig.getString("app_theme_color")
    }

}*/
