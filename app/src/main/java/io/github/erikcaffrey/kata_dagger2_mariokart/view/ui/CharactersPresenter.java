package io.github.erikcaffrey.kata_dagger2_mariokart.view.ui;

import io.github.erikcaffrey.kata_dagger2_mariokart.domain.usecase.GetCharacterByName;
import java.util.List;

import io.github.erikcaffrey.kata_dagger2_mariokart.domain.model.Character;
import io.github.erikcaffrey.kata_dagger2_mariokart.domain.usecase.GetCharacters;
import io.github.erikcaffrey.kata_dagger2_mariokart.domain.usecase.UseCaseSubscriber;

public class CharactersPresenter extends Presenter<CharactersPresenter.View> {

  private CharactersPresenter.View view;
  private GetCharacters getCharacters;

  public CharactersPresenter(View view, GetCharacters getCharacters) {
    this.view = view;
    this.getCharacters = getCharacters;
  }

  @Override public void initialize() {
    super.initialize();
    getCharacters.execute(new GetCharacterListSubscriber());
  }

  @Override public void terminate() {
    super.terminate();
    getCharacters.unsubscribe();
  }

  private class GetCharacterListSubscriber extends UseCaseSubscriber<List<Character>> {

    @Override public void onCompleted() {
      super.onCompleted();
    }

    @Override public void onError(Throwable e) {
      super.onError(e);
    }

    @Override public void onNext(List<Character> characters) {
      super.onNext(characters);
      view.showCharacters(characters);
    }
  }

  public interface View extends Presenter.View {

    void showCharacters(List<Character> characters);
  }
}
