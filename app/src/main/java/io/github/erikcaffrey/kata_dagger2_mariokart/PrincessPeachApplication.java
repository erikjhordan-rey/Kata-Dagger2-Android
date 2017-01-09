package io.github.erikcaffrey.kata_dagger2_mariokart;

import android.app.Application;

import io.github.erikcaffrey.kata_dagger2_mariokart.di.DaggerPrincessPeachComponent;
import io.github.erikcaffrey.kata_dagger2_mariokart.di.PrincessPeachApiModule;
import io.github.erikcaffrey.kata_dagger2_mariokart.di.PrincessPeachComponent;

public class PrincessPeachApplication extends Application {

  private PrincessPeachComponent princessPeachComponent;

  @Override public void onCreate() {
    super.onCreate();
    initializeInjector();
  }

  private void initializeInjector() {
    princessPeachComponent = DaggerPrincessPeachComponent.builder()
        .princessPeachApiModule(new PrincessPeachApiModule())
        .build();
  }

  public PrincessPeachComponent getPrincessPeachComponent() {
    return princessPeachComponent;
  }
}
