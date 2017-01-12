package io.github.erikcaffrey.kata_dagger2_mariokart.view.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import io.github.erikcaffrey.kata_dagger2_mariokart.R;
import io.github.erikcaffrey.kata_dagger2_mariokart.domain.model.Character;
import io.github.erikcaffrey.kata_dagger2_mariokart.view.adapter.CardAdapter;

/**
 * 11/01/17.
 */

public class CharacterFragment extends BaseFragment {

  public static CharacterFragment newInstance(Character character) {
    CharacterFragment characterFragment = new CharacterFragment();
    Bundle bundle = new Bundle();
    bundle.putString("name", character.getName());
    bundle.putInt("cover", character.getPhoto());
    characterFragment.setArguments(bundle);
    return characterFragment;
  }

  @BindView(R.id.label_name) TextView nameLabel;
  @BindView(R.id.image_cover) ImageView imageCover;
  @BindView(R.id.cardView) CardView cardView;

  @Override protected int getLayoutResID() {
    return R.layout.fragment_character;
  }

  @Override protected void onPrepareFragment(@NonNull View view) {
    super.onPrepareFragment(view);
    nameLabel.setText(getArguments().getString("name"));
    imageCover.setImageResource(getArguments().getInt("cover"));
    cardView.setMaxCardElevation(cardView.getCardElevation()
        * CardAdapter.MAX_ELEVATION_FACTOR);
  }

  public CardView getCardView() {
    return cardView;
  }
}
