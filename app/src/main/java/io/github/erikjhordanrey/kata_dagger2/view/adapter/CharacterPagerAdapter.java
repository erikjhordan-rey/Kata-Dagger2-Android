package io.github.erikjhordanrey.kata_dagger2.view.adapter;

import android.view.ViewGroup;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

import io.github.erikjhordanrey.kata_dagger2.view.fragment.CharacterFragment;
import org.jetbrains.annotations.NotNull;

public class CharacterPagerAdapter extends FragmentStatePagerAdapter implements CharacterAdapter {

    private List<Fragment> characterList;
    private float elevation;

    public CharacterPagerAdapter(FragmentManager fm) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        characterList = new ArrayList<>();
    }

    @NotNull
    @Override
    public Fragment getItem(int position) {
        return characterList.get(position);
    }

    @Override
    public float getElevation() {
        return elevation;
    }

    @Override
    public CardView getCardViewAt(int position) {
        return ((CharacterFragment) characterList.get(position)).characterCardView;
    }

    @Override
    public int getCount() {
        return characterList.size();
    }

    @NotNull
    @Override
    public Object instantiateItem(@NotNull ViewGroup container, int position) {
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
