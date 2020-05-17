package com.dicon.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dicon.R
import com.dicon.ui.dashboard.DetailActivity
import kotlinx.android.synthetic.main.item_poster_menu.view.item_poster_menu_transformationLayout
import kotlinx.android.synthetic.main.item_poster_menu.view.item_poster_post
import kotlinx.android.synthetic.main.item_poster_menu.view.item_poster_title

class PosterMenuAdapter : RecyclerView.Adapter<PosterMenuAdapter.PosterViewHolder>() {

  private val items = mutableListOf<Poster>()

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PosterViewHolder {
    val inflater = LayoutInflater.from(parent.context)
    return PosterViewHolder(inflater.inflate(R.layout.item_poster_menu, parent, false))
  }

  override fun onBindViewHolder(holder: PosterViewHolder, position: Int) {
    val item = items[position]
    holder.itemView.run {
      Glide.with(context)
        .load(item.poster)
        .into(item_poster_post)
      item_poster_title.text = item.name
      setOnClickListener {
        DetailActivity.startActivity(context, item_poster_menu_transformationLayout, item)
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
