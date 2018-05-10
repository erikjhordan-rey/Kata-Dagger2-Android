package io.github.erikcaffrey.kata_dagger2_mariokart.di

import dagger.Module
import dagger.Provides
import io.github.erikcaffrey.kata_dagger2_mariokart.data.CharacterFakeDataSource
import io.github.erikcaffrey.kata_dagger2_mariokart.data.CharacterRepository
import io.github.erikcaffrey.kata_dagger2_mariokart.data.DataSource
import io.github.erikcaffrey.kata_dagger2_mariokart.data.Repository

@Module
class CharactersModule {

  @Provides
  fun provideCharacterFakeDataSource(): DataSource = CharacterFakeDataSource()

  @Provides
  fun provideCharacterRepository(dataSource: DataSource): Repository = CharacterRepository(dataSource)

}
