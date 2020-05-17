package com.dicon.transformationlayout

import android.view.View

/** makes visible or invisible a View align the value parameter. */
internal fun View.visible(value: Boolean) {
  if (value) {
    this.visibility = View.VISIBLE
  } else {
    this.visibility = View.GONE
  }
}
