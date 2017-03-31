package io.github.erikcaffrey.kata_dagger2_mariokart.view.presenter;

import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;
import io.github.erikcaffrey.kata_dagger2_mariokart.domain.usecase.GetCharacters;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class CharactersPresenter_Factory implements Factory<CharactersPresenter> {
  private final MembersInjector<CharactersPresenter> charactersPresenterMembersInjector;

  private final Provider<GetCharacters> getCharactersProvider;

  public CharactersPresenter_Factory(
      MembersInjector<CharactersPresenter> charactersPresenterMembersInjector,
      Provider<GetCharacters> getCharactersProvider) {
    assert charactersPresenterMembersInjector != null;
    this.charactersPresenterMembersInjector = charactersPresenterMembersInjector;
    assert getCharactersProvider != null;
    this.getCharactersProvider = getCharactersProvider;
  }

  @Override
  public CharactersPresenter get() {
    return MembersInjectors.injectMembers(
        charactersPresenterMembersInjector, new CharactersPresenter(getCharactersProvider.get()));
  }

  public static Factory<CharactersPresenter> create(
      MembersInjector<CharactersPresenter> charactersPresenterMembersInjector,
      Provider<GetCharacters> getCharactersProvider) {
    return new CharactersPresenter_Factory(
        charactersPresenterMembersInjector, getCharactersProvider);
  }
}
