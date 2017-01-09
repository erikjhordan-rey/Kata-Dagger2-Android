package io.github.erikcaffrey.kata_dagger2_mariokart.another_mario_kart_sample;

import dagger.Component;
import javax.inject.Singleton;

/**
 * 08/01/17.
 */

@Singleton
@Component(modules = {PrincesPeachApiModule.class})
public interface PrincesPeachComponent {

  void inject(PrincesPeachActivity princesPeachActivity);
}
