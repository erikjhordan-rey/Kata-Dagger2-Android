package io.github.erikcaffrey.kata_dagger2_mariokart.view.activity;

import dagger.MembersInjector;
import io.github.erikcaffrey.kata_dagger2_mariokart.view.presenter.CharactersPresenter;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class CharacterDetailActivity_MembersInjector
    implements MembersInjector<CharacterDetailActivity> {
  private final Provider<CharactersPresenter> presenterProvider;

  public CharacterDetailActivity_MembersInjector(Provider<CharactersPresenter> presenterProvider) {
    assert presenterProvider != null;
    this.presenterProvider = presenterProvider;
  }

  public static MembersInjector<CharacterDetailActivity> create(
      Provider<CharactersPresenter> presenterProvider) {
    return new CharacterDetailActivity_MembersInjector(presenterProvider);
  }

  @Override
  public void injectMembers(CharacterDetailActivity instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    instance.presenter = presenterProvider.get();
  }

  public static void injectPresenter(
      CharacterDetailActivity instance, Provider<CharactersPresenter> presenterProvider) {
    instance.presenter = presenterProvider.get();
  }
}
