package io.github.erikcaffrey.kata_dagger2_mariokart.view.utils

import android.content.Context

object UIUtils {

  fun transformDpToPixels(dp: Int, context: Context): Float {
    return dp * context.resources.displayMetrics.density
  }
}
