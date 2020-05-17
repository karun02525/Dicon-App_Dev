package com.dicon.transformationlayout

/** Interface definition for a callback to be invoked when a [TransformationLayout] is transformed or not. */
interface OnTransformFinishListener {

  /** Invoked when the [TransformationLayout] is transformed or not. */
  fun onFinish(isTransformed: Boolean)
}
