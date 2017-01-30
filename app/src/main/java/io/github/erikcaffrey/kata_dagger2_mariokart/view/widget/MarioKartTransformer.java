/*
 * Copyright (C) 2017 Erik Jhordan Rey.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.github.erikcaffrey.kata_dagger2_mariokart.view.widget;

import android.support.v4.view.ViewPager;
import android.support.v7.widget.CardView;
import android.view.View;
import io.github.erikcaffrey.kata_dagger2_mariokart.view.adapter.CharacterAdapter;

public class MarioKartTransformer implements ViewPager.OnPageChangeListener, ViewPager.PageTransformer {

  private ViewPager pager;
  private CharacterAdapter characterAdapter;
  private float lastOffset;
  private boolean scalingEnabled;

  public MarioKartTransformer(ViewPager viewPager, CharacterAdapter adapter) {
    pager = viewPager;
    viewPager.addOnPageChangeListener(this);
    characterAdapter = adapter;
  }

  @Override public void transformPage(View page, float position) {

  }

  @Override
  public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
    int realCurrentPosition;
    int nextPosition;
    float baseElevation = characterAdapter.getElevation();
    float realOffset;
    boolean goingLeft = lastOffset > positionOffset;

    if (goingLeft) {
      realCurrentPosition = position + 1;
      nextPosition = position;
      realOffset = 1 - positionOffset;
    } else {
      nextPosition = position + 1;
      realCurrentPosition = position;
      realOffset = positionOffset;
    }

    if (nextPosition > characterAdapter.getCount() - 1
        || realCurrentPosition > characterAdapter.getCount() - 1) {
      return;
    }

    CardView currentCard = characterAdapter.getCardViewAt(realCurrentPosition);

    if (currentCard != null) {
      if (scalingEnabled) {
        currentCard.setScaleX((float) (1 + 0.1 * (1 - realOffset)));
        currentCard.setScaleY((float) (1 + 0.1 * (1 - realOffset)));
      }
      currentCard.setCardElevation(
          (baseElevation + baseElevation * (CharacterAdapter.MAX_ELEVATION - 1) * (1
              - realOffset)));
    }

    CardView nextCard = characterAdapter.getCardViewAt(nextPosition);

    if (nextCard != null) {
      if (scalingEnabled) {
        nextCard.setScaleX((float) (1 + 0.1 * (realOffset)));
        nextCard.setScaleY((float) (1 + 0.1 * (realOffset)));
      }
      nextCard.setCardElevation(
          (baseElevation + baseElevation * (CharacterAdapter.MAX_ELEVATION - 1) * (realOffset)));
    }

    lastOffset = positionOffset;
  }

  @Override public void onPageSelected(int position) {

  }

  @Override public void onPageScrollStateChanged(int state) {

  }

  public void enableScaling(boolean enable) {
    if (scalingEnabled && !enable) {
      CardView currentCard = characterAdapter.getCardViewAt(pager.getCurrentItem());
      if (currentCard != null) {
        currentCard.animate().scaleY(1);
        currentCard.animate().scaleX(1);
      }
    } else if (!scalingEnabled && enable) {
      CardView currentCard = characterAdapter.getCardViewAt(pager.getCurrentItem());
      if (currentCard != null) {
        currentCard.animate().scaleY(1.1f);
        currentCard.animate().scaleX(1.1f);
      }
    }

    scalingEnabled = enable;
  }
}