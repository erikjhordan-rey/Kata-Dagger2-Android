package io.github.erikcaffrey.kata_dagger2_mariokart.domain.usecase;

import io.github.erikcaffrey.kata_dagger2_mariokart.data.CharacterRepository;
import rx.Observable;

public class GetCharacterByName extends UseCase {

  private final CharacterRepository characterRepository;
  private String characterName;

  public GetCharacterByName(String characterName, CharacterRepository characterRepository) {
    this.characterName = characterName;
    this.characterRepository = characterRepository;
  }

  @Override protected Observable buildObservableUseCase() {
    return this.characterRepository.getByName(characterName);
  }
}
