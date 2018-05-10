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

import io.github.erikcaffrey.kata_dagger2_mariokart.data.Repository
import io.github.erikcaffrey.kata_dagger2_mariokart.domain.model.Character
import io.reactivex.Observable
import javax.inject.Inject

class GetCharacters @Inject constructor(private val repository: Repository) : UseCase<List<Character>>() {

  override fun buildUseCaseObservable(): Observable<List<Character>> {
    return repository.all
  }
}
