package com.dicon.ui.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.dicon.R
import com.dicon.ui.adapter.PosterAdapter
import com.dicon.ui.adapter.PosterMenuAdapter
import com.dicon.utils.MockUtil.getMockPosters
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
    return inflater.inflate(R.layout.fragment_home, container, false)
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    recyclerView.adapter = PosterAdapter().apply {
         addPosterList(getMockPosters()) }

    recyclerView_menu.adapter = PosterMenuAdapter().apply {
      addPosterList(getMockPosters()) }

    fab.setOnClickListener {
      if (!transformationLayout.isTransforming) {
        backgroundView.visibility = View.VISIBLE
      }
      transformationLayout.startTransform(container)
    }

    menu_home.setOnClickListener {
      if (!transformationLayout.isTransforming) {
        backgroundView.visibility = View.GONE
      }

      transformationLayout.finishTransform(container)
      Toast.makeText(context, "Compose New", Toast.LENGTH_SHORT).show()
    }
  }
}
