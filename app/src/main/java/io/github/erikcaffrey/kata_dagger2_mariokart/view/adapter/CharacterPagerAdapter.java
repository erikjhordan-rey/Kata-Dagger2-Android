package io.github.erikcaffrey.kata_dagger2_mariokart.view.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v7.widget.CardView;
import android.view.ViewGroup;
import io.github.erikcaffrey.kata_dagger2_mariokart.view.fragment.CharacterFragment;
import java.util.ArrayList;
import java.util.List;

/**
 * 11/01/17.
 */

public class CharacterPagerAdapter extends FragmentStatePagerAdapter implements CardAdapter {

  private List<Fragment> characterList;
  private float elevation;

  public CharacterPagerAdapter(FragmentManager fm, float elevation) {
    super(fm);
    characterList = new ArrayList<>();
    this.elevation = elevation;
  }

  @Override public Fragment getItem(int position) {
    return characterList.get(position);
  }

  @Override public float getBaseElevation() {
    return elevation;
  }

  @Override public CardView getCardViewAt(int position) {
    return ((CharacterFragment)characterList.get(position)).getCardView();
  }

  @Override public int getCount() {
    return characterList.size();
  }

  @Override
  public Object instantiateItem(ViewGroup container, int position) {
    Object fragment = super.instantiateItem(container, position);
    characterList.set(position, (CharacterFragment) fragment);
    return fragment;
  }


  public void addCharacter(Fragment fragment) {
    characterList.add(fragment);
  }
}
