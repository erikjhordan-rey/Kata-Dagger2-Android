package io.github.erikcaffrey.kata_dagger2_mariokart.domain.usecase;

import io.github.erikcaffrey.kata_dagger2_mariokart.data.CharacterRepository;
import io.reactivex.Observable;

public class GetCharacters extends UseCase {

  private final CharacterRepository characterRepository;

  public GetCharacters(CharacterRepository characterRepository) {
    this.characterRepository = characterRepository;
  }

  @Override Observable buildUseCaseObservable() {
    return characterRepository.getAll();
  }
}
