package io.github.erikcaffrey.kata_dagger2_mariokart.another_mario_kart_sample;

import io.github.erikcaffrey.kata_dagger2_mariokart.R;

/**
 * 08/01/17.
 */

public class PrincesPeach {

  private String name;
  private int photo;

  public PrincesPeach() {
    this.name = "Princes Peach";
    this.photo = R.drawable.ic_peach;
  }

  public String getName() {
    return name;
  }

  public int getPhoto() {
    return photo;
  }
}
