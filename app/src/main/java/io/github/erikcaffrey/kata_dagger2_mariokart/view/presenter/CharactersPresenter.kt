/*
 * Copyright (C) 2017 Erik Jhordan Rey.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.github.erikcaffrey.kata_dagger2_mariokart.view.presenter

import io.github.erikcaffrey.kata_dagger2_mariokart.domain.model.Character
import io.github.erikcaffrey.kata_dagger2_mariokart.domain.usecase.GetCharacters
import io.github.erikcaffrey.kata_dagger2_mariokart.domain.usecase.UseCaseObserver
import javax.inject.Inject

class CharactersPresenter @Inject constructor(private val getCharacters: GetCharacters) : Presenter<CharactersPresenter.View>() {

  override fun initialize() {
    super.initialize()
    this.getCharacters.execute(GetCharacterListObserver())
  }

  override fun terminate() {
    super.terminate()
    getCharacters.dispose()
    view = null
  }

  private inner class GetCharacterListObserver : UseCaseObserver<List<Character>>() {

    override fun onComplete() {
      super.onComplete()
      view?.hideLoading()
    }

    override fun onNext(t: List<Character>) {
      super.onNext(t)
      view?.showCharacters(t)
    }
  }

  interface View : Presenter.View {

    fun showCharacters(characters: List<Character>)

    fun hideLoading()
  }
}
