package io.github.erikjhordanrey.kata_dagger2.di

import dagger.Component
import io.github.erikjhordanrey.kata_dagger2.view.activity.CharacterActivity
import io.github.erikjhordanrey.kata_dagger2.view.activity.CharacterDetailActivity
import javax.inject.Singleton

@Singleton
@Component(modules = [CharactersModule::class])
interface CharactersComponent {

  fun inject(characterActivity: CharacterActivity)

  fun inject(characterDetailActivity: CharacterDetailActivity)
}
