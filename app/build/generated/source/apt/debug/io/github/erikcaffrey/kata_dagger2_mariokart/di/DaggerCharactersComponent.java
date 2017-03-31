package io.github.erikcaffrey.kata_dagger2_mariokart.di;

import dagger.MembersInjector;
import dagger.internal.MembersInjectors;
import dagger.internal.Preconditions;
import io.github.erikcaffrey.kata_dagger2_mariokart.data.DataSource;
import io.github.erikcaffrey.kata_dagger2_mariokart.data.Repository;
import io.github.erikcaffrey.kata_dagger2_mariokart.domain.usecase.GetCharacters;
import io.github.erikcaffrey.kata_dagger2_mariokart.domain.usecase.GetCharacters_Factory;
import io.github.erikcaffrey.kata_dagger2_mariokart.view.activity.CharacterActivity;
import io.github.erikcaffrey.kata_dagger2_mariokart.view.activity.CharacterActivity_MembersInjector;
import io.github.erikcaffrey.kata_dagger2_mariokart.view.activity.CharacterDetailActivity;
import io.github.erikcaffrey.kata_dagger2_mariokart.view.activity.CharacterDetailActivity_MembersInjector;
import io.github.erikcaffrey.kata_dagger2_mariokart.view.presenter.CharactersPresenter;
import io.github.erikcaffrey.kata_dagger2_mariokart.view.presenter.CharactersPresenter_Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DaggerCharactersComponent implements CharactersComponent {
  private Provider<DataSource> provideCharacterFakeDataSourceProvider;

  private Provider<Repository> provideCharacterRepositoryProvider;

  private Provider<GetCharacters> getCharactersProvider;

  private Provider<CharactersPresenter> charactersPresenterProvider;

  private MembersInjector<CharacterActivity> characterActivityMembersInjector;

  private MembersInjector<CharacterDetailActivity> characterDetailActivityMembersInjector;

  private DaggerCharactersComponent(Builder builder) {
    assert builder != null;
    initialize(builder);
  }

  public static Builder builder() {
    return new Builder();
  }

  public static CharactersComponent create() {
    return builder().build();
  }

  @SuppressWarnings("unchecked")
  private void initialize(final Builder builder) {

    this.provideCharacterFakeDataSourceProvider =
        CharactersModule_ProvideCharacterFakeDataSourceFactory.create(builder.charactersModule);

    this.provideCharacterRepositoryProvider =
        CharactersModule_ProvideCharacterRepositoryFactory.create(
            builder.charactersModule, provideCharacterFakeDataSourceProvider);

    this.getCharactersProvider =
        GetCharacters_Factory.create(
            MembersInjectors.<GetCharacters>noOp(), provideCharacterRepositoryProvider);

    this.charactersPresenterProvider =
        CharactersPresenter_Factory.create(
            MembersInjectors.<CharactersPresenter>noOp(), getCharactersProvider);

    this.characterActivityMembersInjector =
        CharacterActivity_MembersInjector.create(charactersPresenterProvider);

    this.characterDetailActivityMembersInjector =
        CharacterDetailActivity_MembersInjector.create(charactersPresenterProvider);
  }

  @Override
  public void inject(CharacterActivity characterActivity) {
    characterActivityMembersInjector.injectMembers(characterActivity);
  }

  @Override
  public void inject(CharacterDetailActivity characterDetailActivity) {
    characterDetailActivityMembersInjector.injectMembers(characterDetailActivity);
  }

  public static final class Builder {
    private CharactersModule charactersModule;

    private Builder() {}

    public CharactersComponent build() {
      if (charactersModule == null) {
        this.charactersModule = new CharactersModule();
      }
      return new DaggerCharactersComponent(this);
    }

    public Builder charactersModule(CharactersModule charactersModule) {
      this.charactersModule = Preconditions.checkNotNull(charactersModule);
      return this;
    }
  }
}
