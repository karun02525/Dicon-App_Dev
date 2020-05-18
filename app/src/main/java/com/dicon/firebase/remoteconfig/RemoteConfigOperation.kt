package com.dicon.firebase.remoteconfig

import com.dicon.BuildConfig
import com.dicon.R
import com.dicon.firebase.remoteconfig.Const.appColor
import com.dicon.firebase.remoteconfig.Const.appName
import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings

class RemoteConfigOperation {
    private var mFirebaseRemoteConfig: FirebaseRemoteConfig? = null

    init {
        mFirebaseRemoteConfig = FirebaseRemoteConfig.getInstance()
    }

    fun firebase() {

        mFirebaseRemoteConfig!!.setDefaults(R.xml.remote_config_defaults)
        mFirebaseRemoteConfig!!.setConfigSettings(
            FirebaseRemoteConfigSettings
                .Builder()
                .setDeveloperModeEnabled(BuildConfig.DEBUG).build()
        )
        //Fetching the values here
        mFirebaseRemoteConfig!!.fetch(0).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                mFirebaseRemoteConfig!!.activateFetched()
                try {
                    applyConfig()
                } catch (e: Exception) {
                }
            }
        }.addOnFailureListener {
            try {
                applyConfig()
            } catch (e: Exception) {
            }
        }
    }


    fun applyConfig() {
        try {
            appName = mFirebaseRemoteConfig!!.getString("app_name")
        } catch (e: Exception) {
        }

        try {
            appColor = mFirebaseRemoteConfig!!.getString("app_theme_color")
        } catch (e: Exception) {
        }

    }
}

