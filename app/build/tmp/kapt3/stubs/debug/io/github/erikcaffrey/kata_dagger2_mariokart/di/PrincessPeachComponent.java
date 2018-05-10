package io.github.erikcaffrey.kata_dagger2_mariokart.di;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 9}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0006"}, d2 = {"Lio/github/erikcaffrey/kata_dagger2_mariokart/di/PrincessPeachComponent;", "", "inject", "", "princessPeachActivity", "Lio/github/erikcaffrey/kata_dagger2_mariokart/view/ui/PrincessPeachActivity;", "app_debug"})
@dagger.Component(modules = {io.github.erikcaffrey.kata_dagger2_mariokart.di.PrincessPeachApiModule.class})
@javax.inject.Singleton()
public abstract interface PrincessPeachComponent {
    
    public abstract void inject(@org.jetbrains.annotations.NotNull()
    io.github.erikcaffrey.kata_dagger2_mariokart.view.ui.PrincessPeachActivity princessPeachActivity);
}