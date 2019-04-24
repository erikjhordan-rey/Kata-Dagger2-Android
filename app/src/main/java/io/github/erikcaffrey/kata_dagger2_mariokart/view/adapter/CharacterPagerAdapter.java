package io.github.erikcaffrey.kata_dagger2_mariokart.view.adapter;

import android.view.ViewGroup;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

import io.github.erikcaffrey.kata_dagger2_mariokart.view.fragment.CharacterFragment;

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
    return ((CharacterFragment) characterList.get(position)).characterCardView;
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
