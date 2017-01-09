package io.github.erikcaffrey.kata_dagger2_mariokart.di;

import dagger.Component;
import io.github.erikcaffrey.kata_dagger2_mariokart.view.ui.PrincessPeachActivity;
import javax.inject.Singleton;

@Singleton @Component(modules = { PrincessPeachApiModule.class })
public interface PrincessPeachComponent {

  void inject(PrincessPeachActivity princessPeachActivity);
}
