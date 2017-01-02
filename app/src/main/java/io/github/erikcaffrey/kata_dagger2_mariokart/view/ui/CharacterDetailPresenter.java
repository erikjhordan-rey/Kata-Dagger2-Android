package io.github.erikcaffrey.kata_dagger2_mariokart.view.ui;

import io.github.erikcaffrey.kata_dagger2_mariokart.domain.model.Character;
import io.github.erikcaffrey.kata_dagger2_mariokart.domain.usecase.GetCharacterByName;
import io.github.erikcaffrey.kata_dagger2_mariokart.domain.usecase.UseCaseSubscriber;

public class CharacterDetailPresenter extends Presenter<CharacterDetailPresenter.View> {

  private final GetCharacterByName getCharacterByName;

  public CharacterDetailPresenter(GetCharacterByName getCharacterByName) {
    this.getCharacterByName = getCharacterByName;
  }

  @Override public void initialize() {
    super.initialize();
    getCharacterByName.execute(new GetCharacterSubscriber());
  }

  @Override public void terminate() {
    super.terminate();
    getCharacterByName.unsubscribe();
  }

  private class GetCharacterSubscriber extends UseCaseSubscriber<Character> {

    @Override public void onCompleted() {
      super.onCompleted();
    }

    @Override public void onError(Throwable e) {
      super.onError(e);
    }

    @Override public void onNext(Character character) {
      super.onNext(character);
    }
  }

  public interface View extends Presenter.View {

    void showCharacter(Character character);
  }
}
