package io.github.erikcaffrey.kata_dagger2_mariokart.data;

import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class CharacterRepository_Factory implements Factory<CharacterRepository> {
  private final Provider<DataSource> dataSourceProvider;

  public CharacterRepository_Factory(Provider<DataSource> dataSourceProvider) {
    assert dataSourceProvider != null;
    this.dataSourceProvider = dataSourceProvider;
  }

  @Override
  public CharacterRepository get() {
    return new CharacterRepository(dataSourceProvider.get());
  }

  public static Factory<CharacterRepository> create(Provider<DataSource> dataSourceProvider) {
    return new CharacterRepository_Factory(dataSourceProvider);
  }
}
