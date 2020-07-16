package io.github.erikjhordanrey.kata_dagger2.view.adapter;

import androidx.cardview.widget.CardView;

public interface CharacterAdapter {

    int MAX_ELEVATION = 8;

    float getElevation();

    CardView getCardViewAt(int position);

    int getCount();
}
