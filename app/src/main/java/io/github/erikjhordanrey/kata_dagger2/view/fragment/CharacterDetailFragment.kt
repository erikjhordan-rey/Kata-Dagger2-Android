package io.github.erikjhordanrey.kata_dagger2.view.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import io.github.erikjhordanrey.kata_dagger2.R
import io.github.erikjhordanrey.kata_dagger2.databinding.FragmentDetailCharacterBinding
import io.github.erikjhordanrey.kata_dagger2.domain.model.Abilities
import io.github.erikjhordanrey.kata_dagger2.domain.model.Character
import io.github.erikjhordanrey.kata_dagger2.view.fragment.CharacterFragment.Companion.EXTRA_CHARACTER
import io.github.erikjhordanrey.kata_dagger2.view.widget.SkillView

class CharacterDetailFragment : Fragment() {

    private val character: Character
        get() = arguments?.getSerializable(EXTRA_CHARACTER) as Character

    private lateinit var binding: FragmentDetailCharacterBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentDetailCharacterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeToolbar()
        Log.d("Data", character.name.orEmpty())
        bind(character)
    }

    override fun onStart() {
        super.onStart()
        Log.d("Data", "start" +  character.name)
    }

    override fun onResume() {
        super.onResume()
        Log.d("Data", "resume" +  character.name)
    }
    private fun initializeToolbar() {
        (activity as AppCompatActivity).setSupportActionBar(binding.toolbar)
        val actionBar = (activity as AppCompatActivity).supportActionBar
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true)
            actionBar.setDisplayShowTitleEnabled(false)
        }
    }

    private fun bind(character: Character) {
        binding.imageProfile.setImageResource(character.photo)
        binding.imageCover.setImageResource(character.cover)
        binding.labelName.text = character.name
        binding.labelDescription.text = character.description
        bindSkills(character.abilities)
    }

    private fun bindSkills(abilities: Abilities?) = abilities?.run {
        bindSkill(binding.skillAccelerate, getString(R.string.text_accelerate), accelerate)
        bindSkill(binding.skillSteer, getString(R.string.text_steer), steer)
        bindSkill(binding.skillBrake, getString(R.string.text_brake), brake)
        bindSkill(binding.skillReverse, getString(R.string.text_reverse), reverse)
        bindSkill(binding.skillLookBehind, getString(R.string.text_look_behind), lookBehind)
        bindSkill(binding.skillDrift, getString(R.string.text_drift), drift)
    }

    private fun bindSkill(skillView: SkillView, skill: String, rank: Int) {
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
