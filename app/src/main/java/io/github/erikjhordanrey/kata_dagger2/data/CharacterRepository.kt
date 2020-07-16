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

package io.github.erikjhordanrey.kata_dagger2.data

import io.github.erikjhordanrey.kata_dagger2.domain.model.Character
import io.reactivex.Observable
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class CharacterRepository @Inject constructor(dataSource: DataSource) : Repository {

  private val characters: List<Character> = dataSource.provideCharacterList()

  override val all: Observable<List<Character>>
    get() = Observable.just(characters).delay(2000L, TimeUnit.MILLISECONDS)
}
