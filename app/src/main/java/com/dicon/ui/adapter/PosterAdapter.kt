package com.dicon.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dicon.R
import com.dicon.ui.dashboard.DetailActivity
import kotlinx.android.synthetic.main.item_poster.view.item_poster_post
import kotlinx.android.synthetic.main.item_poster.view.item_poster_running_time
import kotlinx.android.synthetic.main.item_poster.view.item_poster_title
import kotlinx.android.synthetic.main.item_poster.view.item_poster_transformationLayout

class PosterAdapter : RecyclerView.Adapter<PosterAdapter.PosterViewHolder>() {

  private val items = mutableListOf<Poster>()

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PosterViewHolder {
    val inflater = LayoutInflater.from(parent.context)
    return PosterViewHolder(inflater.inflate(R.layout.item_poster, parent, false))
  }

  override fun onBindViewHolder(holder: PosterViewHolder, position: Int) {
    val item = items[position]
    holder.itemView.run {
      Glide.with(context)
        .load(item.poster)
        .into(item_poster_post)
      item_poster_title.text = item.name
      item_poster_running_time.text = item.playtime
      setOnClickListener {
        DetailActivity.startActivity(context, item_poster_transformationLayout, item)
      }
    }
  }

  fun addPosterList(list: List<Poster>) {
    items.clear()
    items.addAll(list)
    notifyDataSetChanged()
  }

  override fun getItemCount() = items.size

  class PosterViewHolder(view: View) : RecyclerView.ViewHolder(view)
}
