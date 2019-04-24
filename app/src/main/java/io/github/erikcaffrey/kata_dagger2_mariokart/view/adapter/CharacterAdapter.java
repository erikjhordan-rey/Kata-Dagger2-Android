package io.github.erikcaffrey.kata_dagger2_mariokart.view.adapter;

import androidx.cardview.widget.CardView;

public interface CharacterAdapter {

  int MAX_ELEVATION = 8;

  float getElevation();

  CardView getCardViewAt(int position);

  int getCount();
}
