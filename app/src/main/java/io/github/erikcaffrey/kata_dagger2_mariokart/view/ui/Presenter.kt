package io.github.erikcaffrey.kata_dagger2_mariokart.view.ui

class Presenter<T : Presenter.View> {

  var view: T? = null

  fun initialize() {

  }

  fun terminate() {

  }

  interface View
}
