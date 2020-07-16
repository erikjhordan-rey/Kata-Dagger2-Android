package io.github.erikjhordanrey.kata_dagger2.data

import io.github.erikjhordanrey.kata_dagger2.domain.model.Character

interface DataSource {

    fun provideCharacterList(): List<Character>
}
