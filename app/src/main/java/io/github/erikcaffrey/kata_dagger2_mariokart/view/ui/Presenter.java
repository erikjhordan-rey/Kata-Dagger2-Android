package io.github.erikcaffrey.kata_dagger2_mariokart.view.ui;

class Presenter<T extends Presenter.View> {

  private T view;

  public void setView(T view) {
    this.view = view;
  }

  public T getView() {
    return view;
  }

  public void initialize() {

  }

  public void terminate(){

  }

  public interface View {

  }
}