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

package io.github.erikjhordanrey.kata_dagger2.view.activity

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import io.github.erikjhordanrey.kata_dagger2.App
import io.github.erikjhordanrey.kata_dagger2.R
import io.github.erikjhordanrey.kata_dagger2.databinding.ActivityCharactersBinding
import io.github.erikjhordanrey.kata_dagger2.domain.model.Character
import io.github.erikjhordanrey.kata_dagger2.view.adapter.CharacterPagerAdapter
import io.github.erikjhordanrey.kata_dagger2.view.fragment.CharacterFragment
import io.github.erikjhordanrey.kata_dagger2.view.presenter.CharactersPresenter
import io.github.erikjhordanrey.kata_dagger2.view.utils.UIUtils
import io.github.erikjhordanrey.kata_dagger2.view.widget.MarioKartTransformer
import javax.inject.Inject

class CharacterActivity : AppCompatActivity(), CharactersPresenter.View {

    private lateinit var adapter: CharacterPagerAdapter
    private lateinit var transformer: MarioKartTransformer

    private lateinit var binding: ActivityCharactersBinding

    @Inject lateinit var presenter: CharactersPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCharactersBinding.inflate(layoutInflater)
        setContentView(binding.root)
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
        binding.viewPager.setPageTransformer(false, transformer)
        transformer.enableScaling(true)
    }

    override fun hideLoading() {
        binding.progressDetail.visibility = View.GONE
        binding.viewPager.visibility = View.VISIBLE
    }

    private fun initializeDagger() {
        val app = application as App
        app.charactersComponent.inject(this)
    }

    private fun initializeToolbar() {
        setSupportActionBar(binding.toolbar)
        val actionBar = supportActionBar

        actionBar?.run {
            setDisplayShowTitleEnabled(false)
            setIcon(ContextCompat.getDrawable(this@CharacterActivity, R.drawable.ic_menu_white_24dp))
        }
    }

    private fun initializeAdapter() {
        adapter = CharacterPagerAdapter(supportFragmentManager)
        adapter.elevation = UIUtils.transformDpToPixels(ELEVATION_DP, this)
        transformer = MarioKartTransformer(binding.viewPager, adapter)
        binding.viewPager.adapter = adapter
    }

    companion object {

        private const val ELEVATION_DP = 2
    }
}
