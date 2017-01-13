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
import android.view.ViewGroup;
import io.github.erikcaffrey.kata_dagger2_mariokart.view.fragment.CharacterDetailFragment;
import java.util.ArrayList;
import java.util.List;

public class CharacterDetailPagerAdapter extends FragmentStatePagerAdapter {

  private List<Fragment> characterList;

  public CharacterDetailPagerAdapter(FragmentManager fm) {
    super(fm);
    characterList = new ArrayList<>();
  }

  @Override public Fragment getItem(int position) {
    return characterList.get(position);
  }

  @Override public int getCount() {
    return characterList.size();
  }

  @Override public Object instantiateItem(ViewGroup container, int position) {
    Object fragment = super.instantiateItem(container, position);
    characterList.set(position, (CharacterDetailFragment) fragment);
    return fragment;
  }

  public void addCharacter(Fragment fragment) {
    characterList.add(fragment);
  }
}
