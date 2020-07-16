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

package io.github.erikjhordanrey.kata_dagger2.domain.model

import java.io.Serializable

class Character(builder: Builder) : Serializable {

    val id: String?
    val name: String?
    val photo: Int
    val cover: Int
    val description: String?
    val abilities: Abilities?

    init {
        this.id = builder.id
        this.name = builder.name
        this.photo = builder.photo
        this.cover = builder.cover
        this.description = builder.description
        this.abilities = builder.abilities
    }

    class Builder private constructor() {
        var id: String? = null
        var name: String? = null
        var photo: Int = 0
        var cover: Int = 0
        var description: String? = null
        var abilities: Abilities? = null

        fun setId(id: String): Builder {
            this.id = id
            return this
        }

        fun setName(name: String): Builder {
            this.name = name
            return this
        }

        fun setPhoto(photo: Int): Builder {
            this.photo = photo
            return this
        }

        fun setCover(cover: Int): Builder {
            this.cover = cover
            return this
        }

        fun setDescription(description: String): Builder {
            this.description = description
            return this
        }

        fun setAbilities(abilities: Abilities): Builder {
            this.abilities = abilities
            return this
        }

        fun build(): Character {
            return Character(this)
        }

        companion object {

            fun create(): Builder {
                return Builder()
            }
        }
    }
}
