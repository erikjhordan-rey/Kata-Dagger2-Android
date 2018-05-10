package io.github.erikcaffrey.kata_dagger2_mariokart.view.widget

import android.content.Context
import android.graphics.Typeface
import android.support.v7.widget.AppCompatTextView
import android.util.AttributeSet

class MarioKartLabel @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) :
    AppCompatTextView(context, attrs, defStyleAttr) {

  init {
    init(context)
  }

  private fun init(context: Context) {
    this.typeface = getMarioKartTypeFace(context)
  }

  private fun getMarioKartTypeFace(context: Context): Typeface {
    return Typeface.createFromAsset(context.assets, SUPER_MARIO_FONT)
  }

  companion object {
    private const val SUPER_MARIO_FONT = "SuperMario256.ttf"
  }
}
