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

package io.github.erikcaffrey.kata_dagger2_mariokart.domain.model;

import java.io.Serializable;

public class Abilities implements Serializable {

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