package io.github.erikcaffrey.kata_dagger2_mariokart.view.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.List;

import io.github.erikcaffrey.kata_dagger2_mariokart.R;
import io.github.erikcaffrey.kata_dagger2_mariokart.data.CharacterFakeDataSource;
import io.github.erikcaffrey.kata_dagger2_mariokart.data.CharacterRepository;
import io.github.erikcaffrey.kata_dagger2_mariokart.domain.model.Character;
import io.github.erikcaffrey.kata_dagger2_mariokart.domain.usecase.GetCharacters;

public class CharacterActivity extends AppCompatActivity implements CharactersPresenter.View {

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
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
