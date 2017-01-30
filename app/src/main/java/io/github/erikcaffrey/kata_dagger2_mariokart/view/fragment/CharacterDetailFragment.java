package io.github.erikcaffrey.kata_dagger2_mariokart.view.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import io.github.erikcaffrey.kata_dagger2_mariokart.R;
import io.github.erikcaffrey.kata_dagger2_mariokart.domain.model.Abilities;
import io.github.erikcaffrey.kata_dagger2_mariokart.domain.model.Character;
import io.github.erikcaffrey.kata_dagger2_mariokart.view.widget.SkillView;

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
  @BindView(R.id.skill_accelerate) SkillView accelerateSkill;
  @BindView(R.id.skill_steer) SkillView steerSkill;
  @BindView(R.id.skill_brake) SkillView brakeSkill;
  @BindView(R.id.skill_reverse) SkillView reverseSkill;
  @BindView(R.id.skill_look_behind) SkillView lookBehindSkill;
  @BindView(R.id.skill_drift) SkillView driftSkill;

  @Override protected int getLayoutResID() {
    return R.layout.fragment_detail_character;
  }

  @Override protected void onPrepareFragment(@NonNull View view) {
    super.onPrepareFragment(view);
    initializeToolbar();
    Character character = getCharacter();
    renderCharacterDetail(character);
  }

  private void initializeToolbar() {
    setSupportActionBarOnFragment(toolbar);
    ActionBar actionBar = getSupportActionBar();
    if (actionBar != null) {
      actionBar.setDisplayHomeAsUpEnabled(true);
      actionBar.setDisplayShowTitleEnabled(false);
    }
  }

  private Character getCharacter() {
    return (Character) getArguments().getSerializable(EXTRA_CHARACTER);
  }

  private void renderCharacterDetail(Character character) {
    profileImage.setImageResource(character.getPhoto());
    coverImage.setImageResource(character.getCover());
    nameLabel.setText(character.getName());
    descriptionLabel.setText(character.getDescription());
    renderSkills(character.getAbilities());
  }

  private void renderSkills(Abilities abilities) {
    renderSkill(accelerateSkill, getString(R.string.text_accelerate), abilities.getAccelerate());
    renderSkill(steerSkill, getString(R.string.text_steer), abilities.getSteer());
    renderSkill(brakeSkill, getString(R.string.text_brake), abilities.getBrake());
    renderSkill(reverseSkill, getString(R.string.text_reverse), abilities.getReverse());
    renderSkill(lookBehindSkill, getString(R.string.text_look_behind), abilities.getLookBehind());
    renderSkill(driftSkill, getString(R.string.text_drift), abilities.getDrift());
  }

  private void renderSkill(SkillView skillView, String skill, int rank) {
    skillView.setSkill(skill, rank);
  }
}
