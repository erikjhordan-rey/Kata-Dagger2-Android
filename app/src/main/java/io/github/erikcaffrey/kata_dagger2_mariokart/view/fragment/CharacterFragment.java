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

package io.github.erikcaffrey.kata_dagger2_mariokart.view.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import io.github.erikcaffrey.kata_dagger2_mariokart.R;
import io.github.erikcaffrey.kata_dagger2_mariokart.domain.model.Character;
import io.github.erikcaffrey.kata_dagger2_mariokart.view.activity.CharacterDetailActivity;
import io.github.erikcaffrey.kata_dagger2_mariokart.view.adapter.CharacterAdapter;

public class CharacterFragment extends BaseFragment {

  public static final String EXTRA_CHARACTER_POSITION = "character_position";

  public static CharacterFragment newInstance(Character character) {
    CharacterFragment characterFragment = new CharacterFragment();
    Bundle bundle = new Bundle();
    bundle.putSerializable("character", character);
    characterFragment.setArguments(bundle);
    return characterFragment;
  }

  @BindView(R.id.button_name) Button nameButton;
  @BindView(R.id.image_profile) ImageView profileImage;
  @BindView(R.id.label_position) TextView positionLabel;
  @BindView(R.id.cardView) CardView cardView;

  @Override protected int getLayoutResID() {
    return R.layout.fragment_character;
  }

  @Override protected void onPrepareFragment(@NonNull View view) {
    super.onPrepareFragment(view);
    final Character character = (Character) getArguments().getSerializable("character");
    nameButton.setText(character.getName());
    profileImage.setImageResource(character.getPhoto());
    positionLabel.setText(character.getId());
    cardView.setMaxCardElevation(cardView.getCardElevation() * CharacterAdapter.MAX_ELEVATION);

    nameButton.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {

        startActivity(CharacterDetailActivity.getCallingIntent(getContext(),
            Integer.parseInt(character.getId()) - 1));
      }
    });
  }

  public CardView getCardView() {
    return cardView;
  }
}
