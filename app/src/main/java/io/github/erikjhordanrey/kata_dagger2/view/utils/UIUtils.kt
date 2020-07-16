package io.github.erikjhordanrey.kata_dagger2.view.utils

import android.content.Context

object UIUtils {

    fun transformDpToPixels(dp: Int, context: Context): Float {
        return dp * context.resources.displayMetrics.density
    }
}
