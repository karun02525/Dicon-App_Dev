package com.dicon.ui.dashboard

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.dicon.R
import com.dicon.transformationlayout.TransformationLayout
import com.dicon.transformationlayout.onTransformationEndContainer
import com.dicon.ui.adapter.Poster
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    onTransformationEndContainer(intent.getParcelableExtra(parmasExtraName))
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_detail)

    intent.getParcelableExtra<Poster>(posterExtraName)?.let {
      Glide.with(this)
        .load(it.poster)
        .into(profile_detail_background)
      detail_title.text = it.name
      detail_description.text = it.description
    }
  }

  companion object {
    const val parmasExtraName = "parmasExtraName"
    const val posterExtraName = "posterExtraName"
    fun startActivity(context: Context, transformationLayout: TransformationLayout, poster: Poster) {
      if (context is Activity) {
        val bundle = transformationLayout.withView(transformationLayout, poster.name)
        val intent = Intent(context, DetailActivity::class.java)
        intent.putExtra(parmasExtraName, transformationLayout.getParcelableParams())
        intent.putExtra(posterExtraName, poster)
        context.startActivity(intent, bundle)
      }
    }
  }
}
