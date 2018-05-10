package io.github.erikcaffrey.kata_dagger2_mariokart.di

import dagger.Module
import dagger.Provides
import io.github.erikcaffrey.kata_dagger2_mariokart.data.PrincessPeachApi
import javax.inject.Singleton

@Module
class PrincessPeachApiModule {

  @Provides
  @Singleton
  fun providesPeachApi(): PrincessPeachApi = PrincessPeachApi()
}
