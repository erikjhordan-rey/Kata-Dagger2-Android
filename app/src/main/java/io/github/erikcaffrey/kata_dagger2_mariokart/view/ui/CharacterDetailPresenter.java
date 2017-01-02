package io.github.erikcaffrey.kata_dagger2_mariokart.view.ui;

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
