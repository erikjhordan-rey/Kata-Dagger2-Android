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

package io.github.erikcaffrey.kata_dagger2_mariokart.view.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v7.widget.CardView;
import android.view.ViewGroup;
import io.github.erikcaffrey.kata_dagger2_mariokart.view.fragment.CharacterFragment;
import java.util.ArrayList;
import java.util.List;

public class CharacterPagerAdapter extends FragmentStatePagerAdapter implements CharacterAdapter {

  private List<Fragment> characterList;
  private float elevation;

  public CharacterPagerAdapter(FragmentManager fm) {
    super(fm);
    characterList = new ArrayList<>();
  }

  @Override public Fragment getItem(int position) {
    return characterList.get(position);
  }

  @Override public float getElevation() {
    return elevation;
  }

  @Override public CardView getCardViewAt(int position) {
    return ((CharacterFragment) characterList.get(position)).getCardView();
  }

  @Override public int getCount() {
    return characterList.size();
  }

  @Override public Object instantiateItem(ViewGroup container, int position) {
    Object fragment = super.instantiateItem(container, position);
    characterList.set(position, (CharacterFragment) fragment);
    return fragment;
  }

  public void setElevation(float elevation) {
    this.elevation = elevation;
  }

  public void addCharacter(Fragment fragment) {
    characterList.add(fragment);
  }
}
