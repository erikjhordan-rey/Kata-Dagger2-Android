package io.github.erikcaffrey.kata_dagger2_mariokart.view.ui;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 9}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003:\u0001\u000eB\u0005\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u000b\u001a\u00020\fJ\u0006\u0010\r\u001a\u00020\fR\u001e\u0010\u0005\u001a\u0004\u0018\u00018\u0000X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t\u00a8\u0006\u000f"}, d2 = {"Lio/github/erikcaffrey/kata_dagger2_mariokart/view/ui/Presenter;", "T", "Lio/github/erikcaffrey/kata_dagger2_mariokart/view/ui/Presenter$View;", "", "()V", "view", "getView", "()Lio/github/erikcaffrey/kata_dagger2_mariokart/view/ui/Presenter$View;", "setView", "(Lio/github/erikcaffrey/kata_dagger2_mariokart/view/ui/Presenter$View;)V", "Lio/github/erikcaffrey/kata_dagger2_mariokart/view/ui/Presenter$View;", "initialize", "", "terminate", "View", "app_debug"})
public final class Presenter<T extends io.github.erikcaffrey.kata_dagger2_mariokart.view.ui.Presenter.View> {
    @org.jetbrains.annotations.Nullable()
    private T view;
    
    @org.jetbrains.annotations.Nullable()
    public final T getView() {
        return null;
    }
    
    public final void setView(@org.jetbrains.annotations.Nullable()
    T p0) {
    }
    
    public final void initialize() {
    }
    
    public final void terminate() {
    }
    
    public Presenter() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 9}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u00002\u00020\u0001\u00a8\u0006\u0002"}, d2 = {"Lio/github/erikcaffrey/kata_dagger2_mariokart/view/ui/Presenter$View;", "", "app_debug"})
    public static abstract interface View {
    }
}