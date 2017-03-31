package io.github.erikcaffrey.kata_dagger2_mariokart.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import io.github.erikcaffrey.kata_dagger2_mariokart.data.DataSource;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class CharactersModule_ProvideCharacterFakeDataSourceFactory
    implements Factory<DataSource> {
  private final CharactersModule module;

  public CharactersModule_ProvideCharacterFakeDataSourceFactory(CharactersModule module) {
    assert module != null;
    this.module = module;
  }

  @Override
  public DataSource get() {
    return Preconditions.checkNotNull(
        module.provideCharacterFakeDataSource(),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<DataSource> create(CharactersModule module) {
    return new CharactersModule_ProvideCharacterFakeDataSourceFactory(module);
  }

  /** Proxies {@link CharactersModule#provideCharacterFakeDataSource()}. */
  public static DataSource proxyProvideCharacterFakeDataSource(CharactersModule instance) {
    return instance.provideCharacterFakeDataSource();
  }
}
