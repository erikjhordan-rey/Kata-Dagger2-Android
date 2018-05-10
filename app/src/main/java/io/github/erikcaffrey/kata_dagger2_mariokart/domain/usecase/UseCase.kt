/*
 * Copyright (C) 2017 Erik Jhordan Rey.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.github.erikcaffrey.kata_dagger2_mariokart.domain.usecase

import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers

abstract class UseCase<T> {

  private val compositeDisposable: CompositeDisposable = CompositeDisposable()

  fun execute(disposableObserver: DisposableObserver<T>) {
    val observable = this.buildUseCaseObservable()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())

    val observer = observable.subscribeWith(disposableObserver)
    compositeDisposable.add(observer)
  }

  fun dispose() {
    if (!compositeDisposable.isDisposed) {
      compositeDisposable.dispose()
    }
  }

  abstract fun buildUseCaseObservable(): Observable<T>
}
