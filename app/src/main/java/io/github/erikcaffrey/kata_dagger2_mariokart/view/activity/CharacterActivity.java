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

package io.github.erikcaffrey.kata_dagger2_mariokart.view.activity;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import butterknife.BindView;
import io.github.erikcaffrey.kata_dagger2_mariokart.R;
import io.github.erikcaffrey.kata_dagger2_mariokart.SuperMarioKartApplication;
import io.github.erikcaffrey.kata_dagger2_mariokart.domain.model.Character;
import io.github.erikcaffrey.kata_dagger2_mariokart.view.adapter.CharacterPagerAdapter;
import io.github.erikcaffrey.kata_dagger2_mariokart.view.fragment.CharacterFragment;
import io.github.erikcaffrey.kata_dagger2_mariokart.view.presenter.CharactersPresenter;
import io.github.erikcaffrey.kata_dagger2_mariokart.view.widget.MarioTransformer;
import java.util.List;
import javax.inject.Inject;

public class CharacterActivity extends BaseActivity implements CharactersPresenter.View {

  @BindView(R.id.view_pager) ViewPager pager;

  private CharacterPagerAdapter characterPagerAdapter;
  private MarioTransformer marioTransformer;

  @Inject CharactersPresenter charactersPresenter;

  @Override protected int getLayoutResID() {
    return R.layout.activity_characters;
  }

  @Override protected void onSetupSupportActionBar(@NonNull ActionBar actionBar) {
    super.onSetupSupportActionBar(actionBar);
    actionBar.setDisplayShowTitleEnabled(false);
    actionBar.setIcon(ContextCompat.getDrawable(this, R.drawable.ic_menu_white_24dp));
  }

  @Override protected void onPrepareActivity() {
    super.onPrepareActivity();
    initializeDagger();

    characterPagerAdapter = new CharacterPagerAdapter(getSupportFragmentManager());
    characterPagerAdapter.setElevation(dpToPixels(2, this));
    marioTransformer = new MarioTransformer(pager, characterPagerAdapter);
    pager.setAdapter(characterPagerAdapter);

    charactersPresenter.setView(this);
    charactersPresenter.initialize();
  }

  @Override public void showCharacters(List<Character> characters) {
    for (Character character : characters) {
      CharacterFragment characterFragment = CharacterFragment.newInstance(character);
      characterPagerAdapter.addCharacter(characterFragment);
      characterPagerAdapter.notifyDataSetChanged();
    }
    pager.setPageTransformer(false, marioTransformer);
    marioTransformer.enableScaling(true);
  }

  public static float dpToPixels(int dp, Context context) {
    return dp * (context.getResources().getDisplayMetrics().density);
  }

  private void initializeDagger() {
    SuperMarioKartApplication app = (SuperMarioKartApplication) getApplication();
    app.getCharactersComponent().inject(this);
  }
}
