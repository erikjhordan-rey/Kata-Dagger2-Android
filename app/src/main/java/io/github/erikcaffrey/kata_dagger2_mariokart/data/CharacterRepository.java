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

    assert result != null;
    return Observable.just(result);
  }
}

