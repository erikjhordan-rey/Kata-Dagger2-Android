package io.github.erikcaffrey.kata_dagger2_mariokart.data;

import io.github.erikcaffrey.kata_dagger2_mariokart.domain.model.Character;
import java.util.List;

public interface DataSource {

  List<Character> provideCharacterList();
}
