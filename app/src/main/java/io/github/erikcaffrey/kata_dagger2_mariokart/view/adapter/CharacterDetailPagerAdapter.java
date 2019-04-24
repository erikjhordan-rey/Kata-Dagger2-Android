package io.github.erikcaffrey.kata_dagger2_mariokart.view.adapter;

import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

import io.github.erikcaffrey.kata_dagger2_mariokart.view.fragment.CharacterDetailFragment;

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
