package io.github.erikcaffrey.kata_dagger2_mariokart.view.presenter;

import io.github.erikcaffrey.kata_dagger2_mariokart.domain.model.Character;
import io.github.erikcaffrey.kata_dagger2_mariokart.domain.usecase.GetCharacters;
import io.github.erikcaffrey.kata_dagger2_mariokart.domain.usecase.UseCaseObserver;
import java.util.List;

public class CharactersPresenter extends Presenter<CharactersPresenter.View> {

  private GetCharacters getCharacters;

  public CharactersPresenter(GetCharacters getCharacters) {
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
  }
}
