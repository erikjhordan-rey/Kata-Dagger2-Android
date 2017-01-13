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

public class Character implements Serializable {

  private final String id;
  private final String name;
  private final int photo;
  private final int cover;
  private final String description;
  private final Abilities abilities;

  public Character(Builder builder) {
    this.id = builder.id;
    this.name = builder.name;
    this.photo = builder.photo;
    this.cover = builder.cover;
    this.description = builder.description;
    this.abilities = builder.abilities;
  }

  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public int getPhoto() {
    return photo;
  }

  public int getCover() {
    return cover;
  }

  public String getDescription() {
    return description;
  }

  public Abilities getAbilities() {
    return abilities;
  }

  public static class Builder {
    private String id;
    private String name;
    private int photo;
    private int cover;
    private String description;
    private Abilities abilities;

    private Builder() {
    }

    public static Builder create() {
      return new Builder();
    }

    public Builder setId(String id) {
      this.id = id;
      return this;
    }

    public Builder setName(String name) {
      this.name = name;
      return this;
    }

    public Builder setPhoto(int photo) {
      this.photo = photo;
      return this;
    }

    public Builder setCover(int cover) {
      this.cover = cover;
      return this;
    }

    public Builder setDescription(String description) {
      this.description = description;
      return this;
    }

    public Builder setAbilities(Abilities abilities) {
      this.abilities = abilities;
      return this;
    }

    public Character build() {
      return new Character(this);
    }
  }
}
