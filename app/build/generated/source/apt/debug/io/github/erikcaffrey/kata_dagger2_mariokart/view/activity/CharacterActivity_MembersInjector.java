package io.github.erikcaffrey.kata_dagger2_mariokart.view.activity;

import dagger.MembersInjector;
import io.github.erikcaffrey.kata_dagger2_mariokart.view.presenter.CharactersPresenter;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class CharacterActivity_MembersInjector implements MembersInjector<CharacterActivity> {
  private final Provider<CharactersPresenter> presenterProvider;

  public CharacterActivity_MembersInjector(Provider<CharactersPresenter> presenterProvider) {
    assert presenterProvider != null;
    this.presenterProvider = presenterProvider;
  }

  public static MembersInjector<CharacterActivity> create(
      Provider<CharactersPresenter> presenterProvider) {
    return new CharacterActivity_MembersInjector(presenterProvider);
  }

  @Override
  public void injectMembers(CharacterActivity instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    instance.presenter = presenterProvider.get();
  }

  public static void injectPresenter(
      CharacterActivity instance, Provider<CharactersPresenter> presenterProvider) {
    instance.presenter = presenterProvider.get();
  }
}
