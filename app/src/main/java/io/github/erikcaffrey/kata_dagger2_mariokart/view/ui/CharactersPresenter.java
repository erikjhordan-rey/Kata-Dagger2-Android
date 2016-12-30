package io.github.erikcaffrey.kata_dagger2_mariokart.view.ui;


import java.util.List;

import io.github.erikcaffrey.kata_dagger2_mariokart.domain.model.Character;
import io.github.erikcaffrey.kata_dagger2_mariokart.domain.usecase.GetCharacters;
import io.github.erikcaffrey.kata_dagger2_mariokart.domain.usecase.UseCaseSubscriber;

public class CharactersPresenter {

    private CharactersPresenter.View view;
    private GetCharacters getCharacters;

    public CharactersPresenter(View view, GetCharacters getCharacters) {
        this.view = view;
        this.getCharacters = getCharacters;
    }

    public void init() {
        getCharacters.execute(new GetCharacterSubscriber());
    }


    private class GetCharacterSubscriber extends UseCaseSubscriber<List<Character>> {

        @Override
        public void onCompleted() {
            super.onCompleted();
        }

        @Override
        public void onError(Throwable e) {
            super.onError(e);
        }

        @Override
        public void onNext(List<Character> characters) {
            super.onNext(characters);
            view.showCharacters(characters);
        }
    }

    public interface View {

        void showCharacters(List<Character> characters);
    }
}
