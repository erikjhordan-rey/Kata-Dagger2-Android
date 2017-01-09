package io.github.erikcaffrey.kata_dagger2_mariokart.another_mario_kart_sample;

import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

/**
 * 08/01/17.
 */

@Module public class PrincesPeachApiModule {

  @Provides @Singleton public PrincesPeachApi providesPeachApi() {
    return new PrincesPeachApi();
  }
}
