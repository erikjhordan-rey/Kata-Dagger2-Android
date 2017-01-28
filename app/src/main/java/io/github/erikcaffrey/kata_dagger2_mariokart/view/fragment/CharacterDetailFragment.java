package io.github.erikcaffrey.kata_dagger2_mariokart.view.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import butterknife.BindView;
import io.github.erikcaffrey.kata_dagger2_mariokart.R;
import io.github.erikcaffrey.kata_dagger2_mariokart.domain.model.Character;
import io.github.erikcaffrey.kata_dagger2_mariokart.view.widget.AbilitieView;

import static io.github.erikcaffrey.kata_dagger2_mariokart.view.fragment.CharacterFragment.EXTRA_CHARACTER;

public class CharacterDetailFragment extends BaseFragment {

  public static CharacterDetailFragment newInstance(Character character) {
    CharacterDetailFragment characterFragment = new CharacterDetailFragment();
    Bundle bundle = new Bundle();
    bundle.putSerializable(EXTRA_CHARACTER, character);
    characterFragment.setArguments(bundle);
    return characterFragment;
  }

  @BindView(R.id.image_profile) ImageView profileImage;
  @BindView(R.id.image_cover) ImageView coverImage;
  @BindView(R.id.label_name) TextView nameLabel;
  @BindView(R.id.label_description) TextView descriptionLabel;
  @BindView(R.id.toolbar) Toolbar toolbar;
  @BindView(R.id.abilitie_accelerate) AbilitieView accelerateAbilitie;
  @BindView(R.id.abilitie_steer) AbilitieView steerAbilitie;
  @BindView(R.id.abilitie_brake) AbilitieView brakeAbilitie;
  @BindView(R.id.abilitie_reverse) AbilitieView reverseAbilitie;
  @BindView(R.id.abilitie_look_behind) AbilitieView lookBehindAbilitie;
  @BindView(R.id.abilitie_drift) AbilitieView driftAbilitie;

  @Override protected int getLayoutResID() {
    return R.layout.fragment_detail_character;
  }

  @Override protected void onPrepareFragment(@NonNull View view) {
    super.onPrepareFragment(view);
    setSupportActionBarOnFragment(toolbar);
    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    getSupportActionBar().setDisplayShowTitleEnabled(false);
    Character character = (Character) getArguments().getSerializable(EXTRA_CHARACTER);
    profileImage.setImageResource(character.getPhoto());
    coverImage.setImageResource(character.getCover());
    nameLabel.setText(character.getName());
    descriptionLabel.setText(character.getDescription());
    accelerateAbilitie.initAbilitie("Acclerate", character.getAbilities().getAccelerate());
    steerAbilitie.initAbilitie("Steer", character.getAbilities().getSteer());
    brakeAbilitie.initAbilitie("Brake", character.getAbilities().getBrake());
    reverseAbilitie.initAbilitie("Reverse", character.getAbilities().getReverse());
    lookBehindAbilitie.initAbilitie("LookBehind", character.getAbilities().getLookBehind());
    driftAbilitie.initAbilitie("Drift", character.getAbilities().getDrift());
  }
}
