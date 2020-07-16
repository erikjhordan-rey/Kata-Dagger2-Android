package io.github.erikjhordanrey.kata_dagger2.view.adapter

import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import io.github.erikjhordanrey.kata_dagger2.view.fragment.CharacterFragment
import java.util.ArrayList

class CharacterPagerAdapter(fm: FragmentManager?) : FragmentStatePagerAdapter(fm!!, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT), CharacterAdapter {

    private val characterList: MutableList<Fragment>
    override var elevation = 0f
    override fun getItem(position: Int): Fragment {
        return characterList[position]
    }

    override fun getCardViewAt(position: Int): CardView? {
        return (characterList[position] as CharacterFragment).characterCardView
    }

    override fun getCount(): Int {
        return characterList.size
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val fragment = super.instantiateItem(container, position)
        characterList[position] = fragment as CharacterFragment
        return fragment
    }

    fun addCharacter(fragment: Fragment) {
        characterList.add(fragment)
    }

    init {
        characterList = ArrayList()
    }
}
