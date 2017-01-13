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

package io.github.erikcaffrey.kata_dagger2_mariokart.view.presenter;

import io.github.erikcaffrey.kata_dagger2_mariokart.domain.model.Character;
import io.github.erikcaffrey.kata_dagger2_mariokart.domain.usecase.GetCharacterByName;
import io.github.erikcaffrey.kata_dagger2_mariokart.domain.usecase.UseCaseObserver;

public class CharacterDetailPresenter extends Presenter<CharacterDetailPresenter.View> {

  private final GetCharacterByName getCharacterByName;

  public CharacterDetailPresenter(GetCharacterByName getCharacterByName) {
    this.getCharacterByName = getCharacterByName;
  }

  @SuppressWarnings("unchecked") @Override public void initialize() {
    super.initialize();
    getCharacterByName.execute(new GetCharacterObserver());
  }

  @Override public void terminate() {
    super.terminate();
    getCharacterByName.dispose();
    setView(null);
  }

  private class GetCharacterObserver extends UseCaseObserver<Character> {

    @Override public void onComplete() {
      super.onComplete();
    }

    @Override public void onError(Throwable e) {
      super.onError(e);
    }

    @Override public void onNext(Character character) {
      super.onNext(character);
      getView().showCharacter(character);
    }
  }

  public interface View extends Presenter.View {

    void showCharacter(Character character);
  }
}
