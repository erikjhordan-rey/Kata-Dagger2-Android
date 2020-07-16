package io.github.erikjhordanrey.kata_dagger2.view.adapter;

import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

import io.github.erikjhordanrey.kata_dagger2.view.fragment.CharacterDetailFragment;
import org.jetbrains.annotations.NotNull;

public class CharacterDetailPagerAdapter extends FragmentStatePagerAdapter {

    private List<Fragment> characterList;

    public CharacterDetailPagerAdapter(FragmentManager fm) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        characterList = new ArrayList<>();
    }

    @NotNull
    @Override
    public Fragment getItem(int position) {
        return characterList.get(position);
    }

    @Override
    public int getCount() {
        return characterList.size();
    }

    @NotNull
    @Override
    public Object instantiateItem(@NotNull ViewGroup container, int position) {
        Object fragment = super.instantiateItem(container, position);
        characterList.set(position, (CharacterDetailFragment) fragment);
        return fragment;
    }

    public void addCharacter(Fragment fragment) {
        characterList.add(fragment);
    }
}
