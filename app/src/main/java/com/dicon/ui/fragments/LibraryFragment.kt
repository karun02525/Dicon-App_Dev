package com.dicon.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.dicon.R
import com.dicon.ui.adapter.PosterLineAdapter
import com.dicon.utils.MockUtil.getMockPosters
import kotlinx.android.synthetic.main.fragment_library.*

class LibraryFragment : Fragment() {

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    return inflater.inflate(R.layout.fragment_library, container, false)
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    recyclerView.adapter = PosterLineAdapter().apply { addPosterList(getMockPosters()) }

    fab.setOnClickListener {
      transformationLayout.startTransform(container)
    }

    menu_card.setOnClickListener {
      transformationLayout.finishTransform(container)
      Toast.makeText(context, "Play", Toast.LENGTH_SHORT).show()
    }
  }
}
