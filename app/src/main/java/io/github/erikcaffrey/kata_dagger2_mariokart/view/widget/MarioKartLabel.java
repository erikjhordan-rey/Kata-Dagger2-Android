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

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

public class MarioKartLabel extends TextView {

  private final static String SUPER_MARIO_FONT = "SuperMario256.ttf";

  public MarioKartLabel(Context context) {
    super(context);
    if (!isInEditMode()) {
      init(context);
    }
  }

  public MarioKartLabel(Context context, AttributeSet attrs) {
    super(context, attrs);
    if (!isInEditMode()) {
      init(context);
    }
  }

  public MarioKartLabel(Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
    if (!isInEditMode()) {
      init(context);
    }
  }

  private void init(Context context) {
    this.setTypeface(getMarioKartTypeFace(context));
  }

  private Typeface getMarioKartTypeFace(Context context) {
    return Typeface.createFromAsset(context.getAssets(), SUPER_MARIO_FONT);
  }
}