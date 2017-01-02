package io.github.erikcaffrey.kata_dagger2_mariokart.domain.model;

public class Abilities {

  private final int accelerate;
  private final int steer;
  private final int brake;
  private final int reverse;
  private final int lookBehind;
  private final int drift;

  private Abilities(Builder builder) {
    this.accelerate = builder.accelerate;
    this.steer = builder.steer;
    this.brake = builder.brake;
    this.reverse = builder.reverse;
    this.lookBehind = builder.lookBehind;
    this.drift = builder.drift;
  }

  public int getAccelerate() {
    return accelerate;
  }

  public int getSteer() {
    return steer;
  }

  public int getBrake() {
    return brake;
  }

  public int getReverse() {
    return reverse;
  }

  public int getLookBehind() {
    return lookBehind;
  }

  public int getDrift() {
    return drift;
  }

  public static class Builder {

    private int accelerate;
    private int steer;
    private int brake;
    private int reverse;
    private int lookBehind;
    private int drift;

    private Builder() {

    }

    public static Builder create() {
      return new Builder();
    }

    public Builder setAccelerate(int accelerate) {
      this.accelerate = accelerate;
      return this;
    }

    public Builder setSteer(int steer) {
      this.steer = steer;
      return this;
    }

    public Builder setBrake(int brake) {
      this.brake = brake;
      return this;
    }

    public Builder setReverse(int reverse) {
      this.reverse = reverse;
      return this;
    }

    public Builder setLookBehind(int lookBehind) {
      this.lookBehind = lookBehind;
      return this;
    }

    public Builder setDrift(int drift) {
      this.drift = drift;
      return this;
    }

    public Abilities build() {
      return new Abilities(this);
    }
  }
}