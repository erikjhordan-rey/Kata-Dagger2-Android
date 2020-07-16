package io.github.erikjhordanrey.kata_dagger2.data

import io.github.erikjhordanrey.kata_dagger2.domain.model.Character
import io.reactivex.Observable

interface Repository {

  val all: Observable<List<Character>>
}
