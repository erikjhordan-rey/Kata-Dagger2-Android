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
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.view.View;
import butterknife.BindView;
import io.github.erikcaffrey.kata_dagger2_mariokart.R;
import io.github.erikcaffrey.kata_dagger2_mariokart.data.CharacterFakeDataSource;
import io.github.erikcaffrey.kata_dagger2_mariokart.data.CharacterRepository;
import io.github.erikcaffrey.kata_dagger2_mariokart.domain.model.Character;
import io.github.erikcaffrey.kata_dagger2_mariokart.domain.usecase.GetCharacters;
import io.github.erikcaffrey.kata_dagger2_mariokart.view.adapter.CharacterDetailPagerAdapter;
import io.github.erikcaffrey.kata_dagger2_mariokart.view.fragment.CharacterDetailFragment;
import io.github.erikcaffrey.kata_dagger2_mariokart.view.fragment.CharacterFragment;
import io.github.erikcaffrey.kata_dagger2_mariokart.view.presenter.CharactersPresenter;
import java.util.List;

public class CharacterDetailActivity extends BaseActivity implements CharactersPresenter.View {

  @BindView(R.id.pager) ViewPager pager;

  private CharacterDetailPagerAdapter characterPagerAdapter;

  @Override protected int getLayoutResID() {
    return R.layout.activity_detail_character;
  }

  @Override protected void onSetupSupportActionBar(@NonNull ActionBar actionBar) {
    super.onSetupSupportActionBar(actionBar);
    actionBar.setDisplayShowTitleEnabled(true);
    actionBar.setDisplayHomeAsUpEnabled(true);
  }

  @Override protected void onPrepareActivity() {
    super.onPrepareActivity();

    characterPagerAdapter = new CharacterDetailPagerAdapter(getSupportFragmentManager());
    pager.setAdapter(characterPagerAdapter);

    CharacterFakeDataSource characterFakeDataSource = new CharacterFakeDataSource();
    CharacterRepository characterRepository = new CharacterRepository(characterFakeDataSource);
    GetCharacters getCharacters = new GetCharacters(characterRepository);
    CharactersPresenter charactersPresenter = new CharactersPresenter(getCharacters);
    charactersPresenter.setView(this);
    charactersPresenter.initialize();
  }

  @Override public void showCharacters(List<Character> characters) {
    for (Character character : characters) {
      CharacterDetailFragment characterFragment = CharacterDetailFragment.newInstance(character);
      characterPagerAdapter.addCharacter(characterFragment);
      characterPagerAdapter.notifyDataSetChanged();
      System.out.println(character.getName());
    }

    pager.setCurrentItem(getIntent().getIntExtra(CharacterFragment.EXTRA_CHARACTER_POSITION,0));
    pager.setVisibility(View.VISIBLE);

  }

  public static Intent getCallingIntent(Context context, int position) {
    Intent intent = new Intent(context, CharacterDetailActivity.class);
    intent.putExtra(CharacterFragment.EXTRA_CHARACTER_POSITION,position);
    return intent;
  }
}
