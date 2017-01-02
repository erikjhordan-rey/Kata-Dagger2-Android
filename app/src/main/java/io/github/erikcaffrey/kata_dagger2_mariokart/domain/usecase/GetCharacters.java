package io.github.erikcaffrey.kata_dagger2_mariokart.domain.usecase;

import io.github.erikcaffrey.kata_dagger2_mariokart.data.CharacterRepository;
import rx.Observable;

public class GetCharacters extends UseCase {

  private final CharacterRepository characterRepository;

  public GetCharacters(CharacterRepository characterRepository) {
    this.characterRepository = characterRepository;
  }

  @Override protected Observable buildObservableUseCase() {
    return characterRepository.getAll();
  }
}
