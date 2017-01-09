package io.github.erikcaffrey.kata_dagger2_mariokart.domain;

import io.github.erikcaffrey.kata_dagger2_mariokart.R;

/**
 * 08/01/17.
 */

public class PrincessPeach {

  private int name;
  private int photo;

  public PrincessPeach() {
    this.name = R.string.princess_name;
    this.photo = R.drawable.ic_peach;
  }

  public int getName() {
    return name;
  }

  public int getPhoto() {
    return photo;
  }
}
