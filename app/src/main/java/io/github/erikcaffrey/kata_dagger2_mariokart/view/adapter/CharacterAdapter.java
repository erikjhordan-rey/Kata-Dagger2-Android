package io.github.erikcaffrey.kata_dagger2_mariokart.view.adapter;

import android.support.v7.widget.CardView;

public interface CharacterAdapter {

  int MAX_ELEVATION = 8;

  float getElevation();

  CardView getCardViewAt(int position);

  int getCount();
}
