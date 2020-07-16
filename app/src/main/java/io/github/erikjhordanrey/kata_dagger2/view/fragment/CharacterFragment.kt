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

package io.github.erikjhordanrey.kata_dagger2.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import io.github.erikjhordanrey.kata_dagger2.databinding.FragmentCharacterBinding
import io.github.erikjhordanrey.kata_dagger2.domain.model.Character
import io.github.erikjhordanrey.kata_dagger2.view.activity.CharacterDetailActivity
import io.github.erikjhordanrey.kata_dagger2.view.adapter.CharacterAdapter

class CharacterFragment : Fragment() {

    private val character: Character
        get() = arguments?.getSerializable(EXTRA_CHARACTER) as Character

    lateinit var characterCardView: CardView

    private lateinit var binding: FragmentCharacterBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentCharacterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        this.characterCardView = binding.cardView
        val character = character
        renderCharacter(character)
    }

    private fun renderCharacter(character: Character) {
        binding.buttonName.text = character.name
        binding.imageProfile.setImageResource(character.photo)
        binding.labelPosition.text = character.id
        binding.cardView.maxCardElevation = binding.cardView.cardElevation * CharacterAdapter.MAX_ELEVATION

        binding.buttonName.setOnClickListener {
            val position = Integer.parseInt(character.id.orEmpty()) - 1
            startActivity(CharacterDetailActivity.getCallingIntent(requireContext(), position))
        }
    }

    companion object {

        const val EXTRA_CHARACTER_POSITION = "character_position"
        const val EXTRA_CHARACTER = "character"

        fun newInstance(character: Character) = CharacterFragment().apply {
            val bundle = Bundle()
            bundle.putSerializable(EXTRA_CHARACTER, character)
            arguments = bundle
        }
    }
}
