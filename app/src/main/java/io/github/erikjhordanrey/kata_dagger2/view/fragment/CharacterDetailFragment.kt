package io.github.erikjhordanrey.kata_dagger2.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import io.github.erikjhordanrey.kata_dagger2.R
import io.github.erikjhordanrey.kata_dagger2.domain.model.Abilities
import io.github.erikjhordanrey.kata_dagger2.domain.model.Character
import io.github.erikjhordanrey.kata_dagger2.view.fragment.CharacterFragment.Companion.EXTRA_CHARACTER
import io.github.erikjhordanrey.kata_dagger2.view.widget.SkillView
import kotlinx.android.synthetic.main.fragment_detail_character.image_cover
import kotlinx.android.synthetic.main.fragment_detail_character.image_profile
import kotlinx.android.synthetic.main.fragment_detail_character.label_description
import kotlinx.android.synthetic.main.fragment_detail_character.label_name
import kotlinx.android.synthetic.main.fragment_detail_character.skill_accelerate
import kotlinx.android.synthetic.main.fragment_detail_character.skill_brake
import kotlinx.android.synthetic.main.fragment_detail_character.skill_drift
import kotlinx.android.synthetic.main.fragment_detail_character.skill_look_behind
import kotlinx.android.synthetic.main.fragment_detail_character.skill_reverse
import kotlinx.android.synthetic.main.fragment_detail_character.skill_steer
import kotlinx.android.synthetic.main.fragment_detail_character.toolbar

class CharacterDetailFragment : Fragment() {

  private val character: Character
    get() = arguments?.getSerializable(EXTRA_CHARACTER) as Character


  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
      savedInstanceState: Bundle?): View? {
    return inflater.inflate(R.layout.fragment_detail_character, container, false)
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    initializeToolbar()
    val character = character
    renderCharacterDetail(character)
  }

  private fun initializeToolbar() {
    (activity as AppCompatActivity).setSupportActionBar(toolbar)
    val actionBar = (activity as AppCompatActivity).supportActionBar
    if (actionBar != null) {
      actionBar.setDisplayHomeAsUpEnabled(true)
      actionBar.setDisplayShowTitleEnabled(false)
    }
  }

  private fun renderCharacterDetail(character: Character) {
    image_profile.setImageResource(character.photo)
    image_cover.setImageResource(character.cover)
    label_name.text = character.name
    label_description.text = character.description
    renderSkills(character.abilities!!)
  }

  private fun renderSkills(abilities: Abilities) {
    renderSkill(skill_accelerate, getString(R.string.text_accelerate), abilities.accelerate)
    renderSkill(skill_steer, getString(R.string.text_steer), abilities.steer)
    renderSkill(skill_brake, getString(R.string.text_brake), abilities.brake)
    renderSkill(skill_reverse, getString(R.string.text_reverse), abilities.reverse)
    renderSkill(skill_look_behind, getString(R.string.text_look_behind), abilities.lookBehind)
    renderSkill(skill_drift, getString(R.string.text_drift), abilities.drift)
  }

  private fun renderSkill(skillView: SkillView, skill: String, rank: Int) {
    skillView.setSkill(skill, rank)
  }

  companion object {

    fun newInstance(character: Character): CharacterDetailFragment {
      val characterFragment = CharacterDetailFragment()
      val bundle = Bundle()
      bundle.putSerializable(EXTRA_CHARACTER, character)
      characterFragment.arguments = bundle
      return characterFragment
    }
  }
}
