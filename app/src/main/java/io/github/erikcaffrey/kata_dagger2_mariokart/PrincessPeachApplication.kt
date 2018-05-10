package io.github.erikcaffrey.kata_dagger2_mariokart

import android.app.Application

import io.github.erikcaffrey.kata_dagger2_mariokart.di.DaggerPrincessPeachComponent
import io.github.erikcaffrey.kata_dagger2_mariokart.di.PrincessPeachApiModule
import io.github.erikcaffrey.kata_dagger2_mariokart.di.PrincessPeachComponent

class PrincessPeachApplication : Application() {

  lateinit var princessPeachComponent: PrincessPeachComponent

  override fun onCreate() {
    super.onCreate()
    initializeInjector()
  }

  private fun initializeInjector() {
    princessPeachComponent = DaggerPrincessPeachComponent.builder()
        .princessPeachApiModule(PrincessPeachApiModule())
        .build()
  }
}
