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
import io.github.erikcaffrey.kata_dagger2_mariokart.domain.usecase.GetCharacters;
import io.github.erikcaffrey.kata_dagger2_mariokart.domain.usecase.UseCaseObserver;
import java.util.List;
import javax.inject.Inject;

public class CharactersPresenter extends Presenter<CharactersPresenter.View> {

  private GetCharacters getCharacters;

  @Inject public CharactersPresenter(GetCharacters getCharacters) {
    this.getCharacters = getCharacters;
  }

  @SuppressWarnings("unchecked") @Override public void initialize() {
    super.initialize();
    this.getCharacters.execute(new GetCharacterListObserver());
  }

  @Override public void terminate() {
    super.terminate();
    getCharacters.dispose();
    setView(null);
  }

  private class GetCharacterListObserver extends UseCaseObserver<List<Character>> {

    @Override public void onComplete() {
      super.onComplete();
      getView().hideLoading();
    }

    @Override public void onError(Throwable e) {
      super.onError(e);
    }

    @Override public void onNext(List<Character> characters) {
      super.onNext(characters);
      getView().showCharacters(characters);
    }
  }

  public interface View extends Presenter.View {

    void showCharacters(List<Character> characters);

    void hideLoading();
  }
}
