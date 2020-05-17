package com.dicon

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import androidx.core.app.ActivityOptionsCompat
import androidx.core.util.Pair
import kotlinx.android.synthetic.main.activity_splash.*
import kotlinx.coroutines.*

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        initAnimation()
        redirectView()
    }

    private fun initAnimation() {
        val topAnim=AnimationUtils.loadAnimation(this,R.anim.top_animation)
        val bottomAnim=AnimationUtils.loadAnimation(this,R.anim.bottom_animation)

        iv_logo.animation=topAnim
        tv_title.animation=bottomAnim
        tv_dec.animation=bottomAnim


    }

    private fun redirectView() {
      CoroutineScope(Dispatchers.Main).launch {
          delay(3500)
          val sharedIntent = Intent(this@SplashActivity, LoginActivity::class.java)
          val pair1 = Pair.create(iv_logo as View, "iv_logo")
          val pair2 = Pair.create(tv_title as View, "tv_title")
          val options = ActivityOptionsCompat.makeSceneTransitionAnimation(this@SplashActivity, pair1, pair2)
          startActivity(sharedIntent, options.toBundle())
          finish()
      }
    }
}
