package io.github.erikcaffrey.kata_dagger2_mariokart.di

import dagger.Component
import io.github.erikcaffrey.kata_dagger2_mariokart.view.activity.CharacterActivity
import io.github.erikcaffrey.kata_dagger2_mariokart.view.activity.CharacterDetailActivity
import javax.inject.Singleton

@Singleton
@Component(modules = [CharactersModule::class])
interface CharactersComponent {

  fun inject(characterActivity: CharacterActivity)

  fun inject(characterDetailActivity: CharacterDetailActivity)
}
