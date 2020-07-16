package io.github.erikjhordanrey.kata_dagger2

import android.app.Application
import io.github.erikjhordanrey.kata_dagger2.di.CharactersComponent
import io.github.erikjhordanrey.kata_dagger2.di.CharactersModule
import io.github.erikjhordanrey.kata_dagger2.di.DaggerCharactersComponent

class SuperMarioKartApplication : Application() {

  lateinit var charactersComponent: CharactersComponent

  override fun onCreate() {
    super.onCreate()

    charactersComponent = DaggerCharactersComponent.builder().charactersModule(CharactersModule()).build()
  }
}
