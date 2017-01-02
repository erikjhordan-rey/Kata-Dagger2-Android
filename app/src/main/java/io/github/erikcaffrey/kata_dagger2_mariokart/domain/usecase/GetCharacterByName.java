package io.github.erikcaffrey.kata_dagger2_mariokart.domain.usecase;

import io.github.erikcaffrey.kata_dagger2_mariokart.data.CharacterRepository;
import io.reactivex.Observable;

public class GetCharacterByName extends UseCase {

  private final CharacterRepository characterRepository;
  private String characterName;

  public GetCharacterByName(String characterName, CharacterRepository characterRepository) {
    this.characterName = characterName;
    this.characterRepository = characterRepository;
  }

  @Override Observable buildUseCaseObservable() {
    return this.characterRepository.getByName(characterName);
  }
}
