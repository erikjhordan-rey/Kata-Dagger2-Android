package io.github.erikcaffrey.kata_dagger2_mariokart.view.ui;

import io.github.erikcaffrey.kata_dagger2_mariokart.R;
import io.github.erikcaffrey.kata_dagger2_mariokart.data.CharacterFakeDataSource;
import io.github.erikcaffrey.kata_dagger2_mariokart.data.CharacterRepository;
import io.github.erikcaffrey.kata_dagger2_mariokart.domain.model.Character;
import io.github.erikcaffrey.kata_dagger2_mariokart.domain.usecase.GetCharacters;
import java.util.List;

public class CharacterActivity extends BaseActivity implements CharactersPresenter.View {

  @Override protected int getLayoutResID() {
    return R.layout.activity_main;
  }

  @Override protected void onPrepareActivity() {
    super.onPrepareActivity();

    GetCharacters getCharacters =
        new GetCharacters(new CharacterRepository(new CharacterFakeDataSource()));
    CharactersPresenter charactersPresenter = new CharactersPresenter(getCharacters);
    charactersPresenter.setView(this);
    charactersPresenter.initialize();
  }

  @Override public void showCharacters(List<Character> characters) {
    for (Character character : characters) {
      System.out.println(character.getName());
    }
  }

  @Override public void showLoading() {

  }

  @Override public void hideLoading() {

  }
}
