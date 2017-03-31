package io.github.erikcaffrey.kata_dagger2_mariokart.di;

import android.support.v4.app.FragmentManager;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import io.github.erikcaffrey.kata_dagger2_mariokart.view.adapter.CharacterAdapter;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class CharactersModule_ProvideCharacterPagerAdapterFactory
    implements Factory<CharacterAdapter> {
  private final CharactersModule module;

  private final Provider<FragmentManager> fragmentManagerProvider;

  public CharactersModule_ProvideCharacterPagerAdapterFactory(
      CharactersModule module, Provider<FragmentManager> fragmentManagerProvider) {
    assert module != null;
    this.module = module;
    assert fragmentManagerProvider != null;
    this.fragmentManagerProvider = fragmentManagerProvider;
  }

  @Override
  public CharacterAdapter get() {
    return Preconditions.checkNotNull(
        module.provideCharacterPagerAdapter(fragmentManagerProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<CharacterAdapter> create(
      CharactersModule module, Provider<FragmentManager> fragmentManagerProvider) {
    return new CharactersModule_ProvideCharacterPagerAdapterFactory(
        module, fragmentManagerProvider);
  }

  /** Proxies {@link CharactersModule#provideCharacterPagerAdapter(FragmentManager)}. */
  public static CharacterAdapter proxyProvideCharacterPagerAdapter(
      CharactersModule instance, FragmentManager fragmentManager) {
    return instance.provideCharacterPagerAdapter(fragmentManager);
  }
}
