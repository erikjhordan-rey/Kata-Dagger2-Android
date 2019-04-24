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

package io.github.erikcaffrey.kata_dagger2_mariokart.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import io.github.erikcaffrey.kata_dagger2_mariokart.R
import io.github.erikcaffrey.kata_dagger2_mariokart.domain.model.Character
import io.github.erikcaffrey.kata_dagger2_mariokart.view.activity.CharacterDetailActivity
import io.github.erikcaffrey.kata_dagger2_mariokart.view.adapter.CharacterAdapter
import kotlinx.android.synthetic.main.fragment_character.button_name
import kotlinx.android.synthetic.main.fragment_character.cardView
import kotlinx.android.synthetic.main.fragment_character.image_profile
import kotlinx.android.synthetic.main.fragment_character.label_position

class CharacterFragment : Fragment() {

  private val character: Character
    get() = arguments?.getSerializable(EXTRA_CHARACTER) as Character

  lateinit  var characterCardView: CardView
  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
      savedInstanceState: Bundle?): View? {
    return inflater.inflate(R.layout.fragment_character, container, false)
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    this.characterCardView = cardView
    val character = character
    renderCharacter(character)
  }

  private fun renderCharacter(character: Character) {
    button_name.text = character.name
    image_profile.setImageResource(character.photo)
    label_position.text = character.id
    cardView.maxCardElevation = cardView?.cardElevation.let {
      cardView.cardElevation * CharacterAdapter.MAX_ELEVATION
    }
    button_name.setOnClickListener {
      val position = Integer.parseInt(character.id) - 1
      startActivity(CharacterDetailActivity.getCallingIntent(context!!, position))
    }
  }

  companion object {

    const val EXTRA_CHARACTER_POSITION = "character_position"
    const val EXTRA_CHARACTER = "character"

    fun newInstance(character: Character): CharacterFragment {
      val characterFragment = CharacterFragment()
      val bundle = Bundle()
      bundle.putSerializable(EXTRA_CHARACTER, character)
      characterFragment.arguments = bundle
      return characterFragment
    }
  }
}
