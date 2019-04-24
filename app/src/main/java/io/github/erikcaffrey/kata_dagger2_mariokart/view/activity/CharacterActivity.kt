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

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import io.github.erikcaffrey.kata_dagger2_mariokart.R
import io.github.erikcaffrey.kata_dagger2_mariokart.SuperMarioKartApplication
import io.github.erikcaffrey.kata_dagger2_mariokart.domain.model.Character
import io.github.erikcaffrey.kata_dagger2_mariokart.view.adapter.CharacterPagerAdapter
import io.github.erikcaffrey.kata_dagger2_mariokart.view.fragment.CharacterFragment
import io.github.erikcaffrey.kata_dagger2_mariokart.view.presenter.CharactersPresenter
import io.github.erikcaffrey.kata_dagger2_mariokart.view.utils.UIUtils
import io.github.erikcaffrey.kata_dagger2_mariokart.view.widget.MarioKartTransformer
import kotlinx.android.synthetic.main.activity_characters.progress_detail
import kotlinx.android.synthetic.main.activity_characters.toolbar
import kotlinx.android.synthetic.main.activity_characters.view_pager
import javax.inject.Inject

class CharacterActivity : AppCompatActivity(), CharactersPresenter.View {

  private lateinit var adapter: CharacterPagerAdapter
  private lateinit var transformer: MarioKartTransformer
  @Inject lateinit var presenter: CharactersPresenter

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_characters)
    initializeDagger()
    initializeToolbar()
    initializeAdapter()
    presenter.view = this
    presenter.initialize()
  }

  override fun showCharacters(characters: List<Character>) {
    for (character in characters) {
      val characterFragment = CharacterFragment.newInstance(character)
      adapter.addCharacter(characterFragment)
      adapter.notifyDataSetChanged()
    }
    view_pager.setPageTransformer(false, transformer)
    transformer.enableScaling(true)
  }

  override fun hideLoading() {
    progress_detail.visibility = View.GONE
    view_pager.visibility = View.VISIBLE
  }

  private fun initializeDagger() {
    val app = application as SuperMarioKartApplication
    app.charactersComponent.inject(this)
  }

  private fun initializeToolbar() {
    setSupportActionBar(toolbar)
    val actionBar = supportActionBar

    actionBar?.run {
      setDisplayShowTitleEnabled(false)
      setIcon(ContextCompat.getDrawable(this@CharacterActivity, R.drawable.ic_menu_white_24dp))
    }
  }

  private fun initializeAdapter() {
    adapter = CharacterPagerAdapter(supportFragmentManager)
    adapter.elevation = UIUtils.transformDpToPixels(ELEVATION_DP, this)
    transformer = MarioKartTransformer(view_pager, adapter)
    view_pager.adapter = adapter
  }

  companion object {

    private const val ELEVATION_DP = 2
  }
}
