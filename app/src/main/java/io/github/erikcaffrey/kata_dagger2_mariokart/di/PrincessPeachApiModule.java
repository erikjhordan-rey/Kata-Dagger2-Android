package io.github.erikcaffrey.kata_dagger2_mariokart.di;

import dagger.Module;
import dagger.Provides;
import io.github.erikcaffrey.kata_dagger2_mariokart.data.PrincessPeachApi;
import javax.inject.Singleton;

@Module public class PrincessPeachApiModule {

  @Provides @Singleton PrincessPeachApi providesPeachApi() {
    return new PrincessPeachApi();
  }
}
