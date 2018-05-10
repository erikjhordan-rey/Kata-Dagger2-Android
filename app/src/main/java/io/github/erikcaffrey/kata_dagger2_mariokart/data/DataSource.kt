package io.github.erikcaffrey.kata_dagger2_mariokart.data

import io.github.erikcaffrey.kata_dagger2_mariokart.domain.model.Character

interface DataSource {

  fun provideCharacterList(): List<Character>
}
