package io.github.erikcaffrey.kata_dagger2_mariokart.domain.usecase;

import io.reactivex.observers.DisposableObserver;

public class UseCaseObserver<T> extends DisposableObserver<T> {

  @Override public void onComplete() {
  }

  @Override public void onError(Throwable e) {
  }

  @Override public void onNext(T t) {
  }
}