package io.github.erikcaffrey.kata_dagger2_mariokart;

import android.app.Application;
import io.github.erikcaffrey.kata_dagger2_mariokart.di.CharactersComponent;
import io.github.erikcaffrey.kata_dagger2_mariokart.di.CharactersModule;
import io.github.erikcaffrey.kata_dagger2_mariokart.di.DaggerCharactersComponent;

public class SuperMarioKartApplication extends Application {

  private CharactersComponent charactersComponent;

  @Override public void onCreate() {
    super.onCreate();

    charactersComponent = DaggerCharactersComponent.builder().charactersModule(new CharactersModule()).build();
  }

  public CharactersComponent getCharactersComponent() {
    return charactersComponent;
  }
}
