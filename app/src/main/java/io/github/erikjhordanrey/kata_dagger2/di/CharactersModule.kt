package io.github.erikjhordanrey.kata_dagger2.di

import dagger.Module
import dagger.Provides
import io.github.erikjhordanrey.kata_dagger2.data.CharacterFakeDataSource
import io.github.erikjhordanrey.kata_dagger2.data.CharacterRepository
import io.github.erikjhordanrey.kata_dagger2.data.DataSource
import io.github.erikjhordanrey.kata_dagger2.data.Repository

@Module
class CharactersModule {

    @Provides
    fun provideCharacterFakeDataSource(): DataSource = CharacterFakeDataSource()

    @Provides
    fun provideCharacterRepository(dataSource: DataSource): Repository = CharacterRepository(dataSource)
}
