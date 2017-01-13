package io.github.erikcaffrey.kata_dagger2_mariokart.view.fragment;

import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import io.github.erikcaffrey.kata_dagger2_mariokart.R;
import io.github.erikcaffrey.kata_dagger2_mariokart.domain.model.Character;

public class CharacterDetailFragment extends BaseFragment {

  public static CharacterDetailFragment newInstance(Character character) {
    CharacterDetailFragment characterFragment = new CharacterDetailFragment();
    Bundle bundle = new Bundle();
    bundle.putSerializable("character", character);
    characterFragment.setArguments(bundle);
    return characterFragment;
  }

  @BindView(R.id.image_profile) ImageView profileImage;
  @BindView(R.id.image_cover) ImageView coverImage;
  @BindView(R.id.label_name) TextView nameLabel;
  @BindView(R.id.label_description) TextView descriptionLabel;
  @BindView(R.id.toolbar) Toolbar toolbar;


  @Override protected int getLayoutResID() {
    return R.layout.fragment_detail_character;
  }

  @Override protected void onPrepareFragment(@NonNull View view) {
    super.onPrepareFragment(view);
    setSupportActionBarOnFragment(toolbar);
    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    getSupportActionBar().setDisplayShowTitleEnabled(false);
    Character character = (Character) getArguments().getSerializable("character");
    profileImage.setImageResource(character.getPhoto());
    coverImage.setImageResource(character.getCover());
    nameLabel.setText(character.getName());
    descriptionLabel.setText(character.getDescription());


  }
}
