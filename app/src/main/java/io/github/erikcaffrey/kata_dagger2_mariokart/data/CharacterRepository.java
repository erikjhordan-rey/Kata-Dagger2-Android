package io.github.erikcaffrey.kata_dagger2_mariokart.data;

import io.reactivex.Observable;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.github.erikcaffrey.kata_dagger2_mariokart.domain.model.Character;


public class CharacterRepository {

  private final List<Character> characters;

  public CharacterRepository(CharacterFakeDataSource characterFakeDataSource) {
    this.characters = characterFakeDataSource.provideCharacterList();
  }

  public Observable<List<Character>> getAll() {
    final int seconds = 2000;
    return Observable.just(characters).delay(seconds, TimeUnit.MILLISECONDS);
  }

  public Observable<Character> getByName(String name) {
    Character result = null;
    for (Character character : characters) {
      if (character.getName().equals(name)) {
        result = character;
        break;
      }
    }

    return Observable.just(result);
  }
}

