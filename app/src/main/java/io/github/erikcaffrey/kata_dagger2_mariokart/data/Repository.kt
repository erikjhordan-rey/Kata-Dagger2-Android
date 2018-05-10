package io.github.erikcaffrey.kata_dagger2_mariokart.data

import io.github.erikcaffrey.kata_dagger2_mariokart.domain.model.Character
import io.reactivex.Observable

interface Repository {

  val all: Observable<List<Character>>
}
