package io.github.erikcaffrey.kata_dagger2_mariokart.view.widget

import android.view.View
import androidx.viewpager.widget.ViewPager
import io.github.erikcaffrey.kata_dagger2_mariokart.view.adapter.CharacterAdapter

class MarioKartTransformer(private val pager: ViewPager,
                           private val characterAdapter: CharacterAdapter) : ViewPager.OnPageChangeListener, ViewPager.PageTransformer {
  private var lastOffset: Float = 0.toFloat()
  private var scalingEnabled: Boolean = false

  init {
    pager.addOnPageChangeListener(this)
  }

  override fun transformPage(page: View, position: Float) {

  }

  override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
    val realCurrentPosition: Int
    val nextPosition: Int
    val baseElevation = characterAdapter.elevation
    val realOffset: Float
    val goingLeft = lastOffset > positionOffset

    if (goingLeft) {
      realCurrentPosition = position + 1
      nextPosition = position
      realOffset = 1 - positionOffset
    } else {
      nextPosition = position + 1
      realCurrentPosition = position
      realOffset = positionOffset
    }

    if (nextPosition > characterAdapter.count- 1 || realCurrentPosition > characterAdapter.count - 1) {
      return
    }

    val currentCard = characterAdapter.getCardViewAt(realCurrentPosition)

    if (currentCard != null) {
      if (scalingEnabled) {
        currentCard.scaleX = (1 + 0.1 * (1 - realOffset)).toFloat()
        currentCard.scaleY = (1 + 0.1 * (1 - realOffset)).toFloat()
      }
      currentCard.cardElevation = baseElevation + baseElevation * (CharacterAdapter.MAX_ELEVATION - 1).toFloat() * (1 - realOffset)
    }

    val nextCard = characterAdapter.getCardViewAt(nextPosition)

    if (nextCard != null) {
      if (scalingEnabled) {
        nextCard.scaleX = (1 + 0.1 * realOffset).toFloat()
        nextCard.scaleY = (1 + 0.1 * realOffset).toFloat()
      }
      nextCard.cardElevation = baseElevation + baseElevation * (CharacterAdapter.MAX_ELEVATION - 1).toFloat() * realOffset
    }

    lastOffset = positionOffset
  }

  override fun onPageSelected(position: Int) {

  }

  override fun onPageScrollStateChanged(state: Int) {

  }

  fun enableScaling(enable: Boolean) {
    if (scalingEnabled && !enable) {
      val currentCard = characterAdapter.getCardViewAt(pager.currentItem)
      if (currentCard != null) {
        currentCard.animate().scaleY(1f)
        currentCard.animate().scaleX(1f)
      }
    } else if (!scalingEnabled && enable) {
      val currentCard = characterAdapter.getCardViewAt(pager.currentItem)
      if (currentCard != null) {
        currentCard.animate().scaleY(1.1f)
        currentCard.animate().scaleX(1.1f)
      }
    }

    scalingEnabled = enable
  }
}
