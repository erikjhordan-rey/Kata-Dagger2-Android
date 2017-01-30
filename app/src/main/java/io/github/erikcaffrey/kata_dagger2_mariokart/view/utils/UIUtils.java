package io.github.erikcaffrey.kata_dagger2_mariokart.view.utils;

import android.content.Context;

public class UIUtils {

  public static float transformDpToPixels(int dp, Context context) {
    return dp * (context.getResources().getDisplayMetrics().density);
  }
}
