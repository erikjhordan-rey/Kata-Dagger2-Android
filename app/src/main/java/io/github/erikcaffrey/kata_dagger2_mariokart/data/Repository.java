package io.github.erikcaffrey.kata_dagger2_mariokart.data;

import io.github.erikcaffrey.kata_dagger2_mariokart.domain.model.Character;
import io.reactivex.Observable;
import java.util.List;

public interface Repository {

  Observable<List<Character>> getAll();

  Observable<Character> getByName(String name);
}
