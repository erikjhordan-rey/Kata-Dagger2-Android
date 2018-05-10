package io.github.erikcaffrey.kata_dagger2_mariokart


import android.app.Application
import io.github.erikcaffrey.kata_dagger2_mariokart.di.CharactersComponent
import io.github.erikcaffrey.kata_dagger2_mariokart.di.CharactersModule
import io.github.erikcaffrey.kata_dagger2_mariokart.di.DaggerCharactersComponent

class SuperMarioKartApplication : Application() {

  lateinit var charactersComponent: CharactersComponent

  override fun onCreate() {
    super.onCreate()

    charactersComponent = DaggerCharactersComponent.builder().charactersModule(CharactersModule()).build()
  }
}
