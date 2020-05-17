package com.dicon.ui.adapter

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
@Parcelize
data class Poster(
  val name: String,
  val release: String,
  val playtime: String,
  val description: String,
  val poster: String
) : Parcelable
