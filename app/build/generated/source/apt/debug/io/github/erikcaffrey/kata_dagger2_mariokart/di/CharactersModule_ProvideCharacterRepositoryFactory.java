package io.github.erikcaffrey.kata_dagger2_mariokart.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import io.github.erikcaffrey.kata_dagger2_mariokart.data.DataSource;
import io.github.erikcaffrey.kata_dagger2_mariokart.data.Repository;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class CharactersModule_ProvideCharacterRepositoryFactory
    implements Factory<Repository> {
  private final CharactersModule module;

  private final Provider<DataSource> dataSourceProvider;

  public CharactersModule_ProvideCharacterRepositoryFactory(
      CharactersModule module, Provider<DataSource> dataSourceProvider) {
    assert module != null;
    this.module = module;
    assert dataSourceProvider != null;
    this.dataSourceProvider = dataSourceProvider;
  }

  @Override
  public Repository get() {
    return Preconditions.checkNotNull(
        module.provideCharacterRepository(dataSourceProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<Repository> create(
      CharactersModule module, Provider<DataSource> dataSourceProvider) {
    return new CharactersModule_ProvideCharacterRepositoryFactory(module, dataSourceProvider);
  }

  /** Proxies {@link CharactersModule#provideCharacterRepository(DataSource)}. */
  public static Repository proxyProvideCharacterRepository(
      CharactersModule instance, DataSource dataSource) {
    return instance.provideCharacterRepository(dataSource);
  }
}
