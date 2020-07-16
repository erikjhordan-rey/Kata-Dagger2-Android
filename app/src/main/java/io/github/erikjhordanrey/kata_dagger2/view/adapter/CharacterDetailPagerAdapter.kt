package io.github.erikjhordanrey.kata_dagger2.view.adapter

import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import io.github.erikjhordanrey.kata_dagger2.view.fragment.CharacterDetailFragment
import java.util.ArrayList

class CharacterDetailPagerAdapter(fragmentManager: FragmentManager) :
        FragmentStatePagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    private val characterList: MutableList<Fragment>

    init {
        characterList = ArrayList()
    }

    override fun getItem(position: Int): Fragment {
        return characterList[position]
    }

    override fun getCount(): Int {
        return characterList.size
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val fragment = super.instantiateItem(container, position)
        characterList[position] = fragment as CharacterDetailFragment
        return fragment
    }

    fun addCharacter(fragment: Fragment) {
        characterList.add(fragment)
    }


}
