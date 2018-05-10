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

package io.github.erikcaffrey.kata_dagger2_mariokart.domain.model

import java.io.Serializable

class Abilities private constructor(builder: Builder) : Serializable {

  val accelerate: Int
  val steer: Int
  val brake: Int
  val reverse: Int
  val lookBehind: Int
  val drift: Int

  init {
    this.accelerate = builder.accelerate
    this.steer = builder.steer
    this.brake = builder.brake
    this.reverse = builder.reverse
    this.lookBehind = builder.lookBehind
    this.drift = builder.drift
  }

  class Builder private constructor() {

    var accelerate: Int = 0
    var steer: Int = 0
    var brake: Int = 0
    var reverse: Int = 0
    var lookBehind: Int = 0
    var drift: Int = 0

    fun setAccelerate(accelerate: Int): Builder {
      this.accelerate = accelerate
      return this
    }

    fun setSteer(steer: Int): Builder {
      this.steer = steer
      return this
    }

    fun setBrake(brake: Int): Builder {
      this.brake = brake
      return this
    }

    fun setReverse(reverse: Int): Builder {
      this.reverse = reverse
      return this
    }

    fun setLookBehind(lookBehind: Int): Builder {
      this.lookBehind = lookBehind
      return this
    }

    fun setDrift(drift: Int): Builder {
      this.drift = drift
      return this
    }

    fun build(): Abilities {
      return Abilities(this)
    }

    companion object {

      fun create(): Builder {
        return Builder()
      }
    }
  }
}
