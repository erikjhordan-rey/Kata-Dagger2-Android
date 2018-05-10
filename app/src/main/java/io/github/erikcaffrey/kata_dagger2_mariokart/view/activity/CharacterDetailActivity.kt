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

package io.github.erikcaffrey.kata_dagger2_mariokart.view.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.view.View
import io.github.erikcaffrey.kata_dagger2_mariokart.R
import io.github.erikcaffrey.kata_dagger2_mariokart.SuperMarioKartApplication
import io.github.erikcaffrey.kata_dagger2_mariokart.domain.model.Character
import io.github.erikcaffrey.kata_dagger2_mariokart.view.adapter.CharacterDetailPagerAdapter
import io.github.erikcaffrey.kata_dagger2_mariokart.view.fragment.CharacterDetailFragment
import io.github.erikcaffrey.kata_dagger2_mariokart.view.fragment.CharacterFragment
import io.github.erikcaffrey.kata_dagger2_mariokart.view.presenter.CharactersPresenter
import kotlinx.android.synthetic.main.activity_characters.*
import kotlinx.android.synthetic.main.activity_detail_character.*
import javax.inject.Inject

class CharacterDetailActivity : AppCompatActivity(), CharactersPresenter.View {

  private lateinit var adapter: CharacterDetailPagerAdapter
  @Inject lateinit var presenter: CharactersPresenter

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_detail_character)
    initializeDagger()
    initializeToolbar()
    initializeAdapter()
    presenter.view = this
    presenter.initialize()
  }


  override fun showCharacters(characters: List<Character>) {
    for (character in characters) {
      val characterFragment = CharacterDetailFragment.newInstance(character)
      adapter.addCharacter(characterFragment)
      adapter.notifyDataSetChanged()
    }

    pager.currentItem = intent.getIntExtra(CharacterFragment.EXTRA_CHARACTER_POSITION, DEFAULT_POSITION)
    pager.visibility = View.VISIBLE
  }

  override fun hideLoading() {
    pager.visibility = View.VISIBLE
    progress_character_detail.visibility = View.GONE
  }

  private fun initializeDagger() {
    val app = application as SuperMarioKartApplication
    app.charactersComponent.inject(this)
  }

  private fun initializeToolbar() {
    setSupportActionBar(toolbar)
    val actionBar = supportActionBar

    actionBar?.run {
      setDisplayShowTitleEnabled(true)
      setDisplayHomeAsUpEnabled(true)
    }
  }

  private fun initializeAdapter() {
    adapter = CharacterDetailPagerAdapter(supportFragmentManager)
    pager?.adapter = adapter
  }

  companion object {

    private const val DEFAULT_POSITION = 0

    fun getCallingIntent(context: Context, position: Int): Intent {
      val intent = Intent(context, CharacterDetailActivity::class.java)
      intent.putExtra(CharacterFragment.EXTRA_CHARACTER_POSITION, position)
      return intent
    }
  }
}
