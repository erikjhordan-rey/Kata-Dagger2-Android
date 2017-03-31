package io.github.erikcaffrey.kata_dagger2_mariokart.domain.usecase;

import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;
import io.github.erikcaffrey.kata_dagger2_mariokart.data.Repository;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class GetCharacters_Factory implements Factory<GetCharacters> {
  private final MembersInjector<GetCharacters> getCharactersMembersInjector;

  private final Provider<Repository> repositoryProvider;

  public GetCharacters_Factory(
      MembersInjector<GetCharacters> getCharactersMembersInjector,
      Provider<Repository> repositoryProvider) {
    assert getCharactersMembersInjector != null;
    this.getCharactersMembersInjector = getCharactersMembersInjector;
    assert repositoryProvider != null;
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public GetCharacters get() {
    return MembersInjectors.injectMembers(
        getCharactersMembersInjector, new GetCharacters(repositoryProvider.get()));
  }

  public static Factory<GetCharacters> create(
      MembersInjector<GetCharacters> getCharactersMembersInjector,
      Provider<Repository> repositoryProvider) {
    return new GetCharacters_Factory(getCharactersMembersInjector, repositoryProvider);
  }
}
