package io.github.erikcaffrey.kata_dagger2_mariokart.another_mario_kart_sample;

import android.app.Application;

/**
 * 09/01/17.
 */

public class PrincesPeachApplication extends Application {

  private PrincesPeachComponent princesPeachComponent;

  @Override public void onCreate() {
    super.onCreate();
    initializeInjector();
  }

  private void initializeInjector() {
    princesPeachComponent = DaggerPrincesPeachComponent.builder()
        .princesPeachApiModule(new PrincesPeachApiModule()).build();
  }

  public PrincesPeachComponent getPrincesPeachComponent() {
    return princesPeachComponent;
  }
}
