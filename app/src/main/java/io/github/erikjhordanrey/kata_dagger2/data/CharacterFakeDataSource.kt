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

package io.github.erikjhordanrey.kata_dagger2.data

import io.github.erikjhordanrey.kata_dagger2.R
import io.github.erikjhordanrey.kata_dagger2.domain.model.Abilities
import io.github.erikjhordanrey.kata_dagger2.domain.model.Character

class CharacterFakeDataSource : DataSource {

    private val characters: MutableList<Character> = mutableListOf()

    private val marioBros: Character
        get() {

            val accelerate = 100
            val steer = 95
            val brake = 83
            val reverse = 87
            val lookBehind = 100
            val drift = 100

            val id = "1"
            val name = "Mario Bros"
            val photo = R.drawable.ic_mario
            val cover = R.mipmap.mario
            val description = "The plumber star of the series. His kart is average across the board. When Mario is controlled by the computer, his main item used is the Star."
            val abilities = Abilities.Builder.create()
                    .setAccelerate(accelerate)
                    .setBrake(steer)
                    .setDrift(brake)
                    .setLookBehind(reverse)
                    .setReverse(lookBehind)
                    .setSteer(drift)
                    .build()

            return Character.Builder.create()
                    .setId(id)
                    .setName(name)
                    .setPhoto(photo)
                    .setCover(cover)
                    .setDescription(description)
                    .setAbilities(abilities)
                    .build()
        }

    private val luigi: Character
        get() {

            val accelerate = 97
            val steer = 95
            val brake = 73
            val reverse = 97
            val lookBehind = 87
            val drift = 88

            val id = "2"
            val name = "Luigi"
            val photo = R.drawable.ic_luigi
            val cover = R.mipmap.luigi
            val description = "Similar to his brother, Mario, his kart also have average status across the board. Also like Mario, when computer-controlled, his main item is the Star."
            val abilities = Abilities.Builder.create()
                    .setAccelerate(accelerate)
                    .setBrake(steer)
                    .setDrift(brake)
                    .setLookBehind(reverse)
                    .setReverse(lookBehind)
                    .setSteer(drift)
                    .build()

            return Character.Builder.create()
                    .setId(id)
                    .setName(name)
                    .setPhoto(photo)
                    .setCover(cover)
                    .setDescription(description)
                    .setAbilities(abilities)
                    .build()
        }

    private val daisy: Character
        get() {

            val accelerate = 88
            val steer = 95
            val brake = 85
            val reverse = 97
            val lookBehind = 89
            val drift = 82

            val id = "3"
            val name = "Daisy"
            val photo = R.drawable.ic_daisy
            val cover = R.mipmap.daisy
            val description = "Princess Daisy is a “tomboy.” I’m not sure how this boyishness manifests itself in the character design—her choice of an unflattering yellow dress, maybe? But this “tomboy” stuff is euphemistic nonsense, anyway. I imagine Daisy is a closeted lesbian, plucked from the socially liberal dream world of Super Mario Land’s Sarasaland and forced to mold her identity to the Mushroom Kingdom’s rigid gender roles."
            val abilities = Abilities.Builder.create()
                    .setAccelerate(accelerate)
                    .setBrake(steer)
                    .setDrift(brake)
                    .setLookBehind(reverse)
                    .setReverse(lookBehind)
                    .setSteer(drift)
                    .build()

            return Character.Builder.create()
                    .setId(id)
                    .setName(name)
                    .setPhoto(photo)
                    .setCover(cover)
                    .setDescription(description)
                    .setAbilities(abilities)
                    .build()
        }

    private val toad: Character
        get() {

            val accelerate = 79
            val steer = 98
            val brake = 86
            val reverse = 89
            val lookBehind = 90
            val drift = 93

            val id = "4"
            val name = "Toad"
            val photo = R.drawable.ic_toad
            val cover = R.mipmap.toad
            val description = "Below par speed-wise. His kart turns the best, but often loses control when hit by larger opponents. Like Princess Peach, he'll try throwing mushrooms in your way when he's controlled by the computer."
            val abilities = Abilities.Builder.create()
                    .setAccelerate(accelerate)
                    .setBrake(steer)
                    .setDrift(brake)
                    .setLookBehind(reverse)
                    .setReverse(lookBehind)
                    .setSteer(drift)
                    .build()

            return Character.Builder.create()
                    .setId(id)
                    .setName(name)
                    .setPhoto(photo)
                    .setCover(cover)
                    .setDescription(description)
                    .setAbilities(abilities)
                    .build()
        }

    private val yoshi: Character
        get() {

            val accelerate = 89
            val steer = 98
            val brake = 86
            val reverse = 82
            val lookBehind = 96
            val drift = 88

            val id = "5"
            val name = "Yoshi"
            val photo = R.drawable.ic_yoshi
            val cover = R.mipmap.yoshi
            val description = "Yoshi is the green dinosaur-like creature from Super Mario World. His kart has the highest acceleration. When playing against him, he'll try throwing eggs in your way."
            val abilities = Abilities.Builder.create()
                    .setAccelerate(accelerate)
                    .setBrake(steer)
                    .setDrift(brake)
                    .setLookBehind(reverse)
                    .setReverse(lookBehind)
                    .setSteer(drift)
                    .build()

            return Character.Builder.create()
                    .setId(id)
                    .setName(name)
                    .setPhoto(photo)
                    .setCover(cover)
                    .setDescription(description)
                    .setAbilities(abilities)
                    .build()
        }

    private val dkong: Character
        get() {

            val accelerate = 90
            val steer = 98
            val brake = 89
            val reverse = 97
            val lookBehind = 89
            val drift = 96

            val id = "6"
            val name = "Donkey Kong"
            val photo = R.drawable.ic_dkong
            val cover = R.mipmap.dk
            val description = "The son of the famous gorilla, Donkey Kong. His kart's attributes are similar to Bowser's. His main item is bananas, which is what the computer uses when controlling him."
            val abilities = Abilities.Builder.create()
                    .setAccelerate(accelerate)
                    .setBrake(steer)
                    .setDrift(brake)
                    .setLookBehind(reverse)
                    .setReverse(lookBehind)
                    .setSteer(drift)
                    .build()

            return Character.Builder.create()
                    .setId(id)
                    .setName(name)
                    .setPhoto(photo)
                    .setCover(cover)
                    .setDescription(description)
                    .setAbilities(abilities)
                    .build()
        }

    private val wario: Character
        get() {

            val accelerate = 98
            val steer = 92
            val brake = 86
            val reverse = 88
            val lookBehind = 96
            val drift = 89

            val id = "7"
            val name = "Wario"
            val photo = R.drawable.ic_wario
            val cover = R.mipmap.wario
            val description = "Wario's dirty tricks bring him dangerously close to disqualification but somehow is always greenlit for the seasons that follow. Wario is the torrential counterpart and brother to Waluigi."
            val abilities = Abilities.Builder.create()
                    .setAccelerate(accelerate)
                    .setBrake(steer)
                    .setDrift(brake)
                    .setLookBehind(reverse)
                    .setReverse(lookBehind)
                    .setSteer(drift)
                    .build()

            return Character.Builder.create()
                    .setId(id)
                    .setName(name)
                    .setPhoto(photo)
                    .setCover(cover)
                    .setDescription(description)
                    .setAbilities(abilities)
                    .build()
        }

    private val bowser: Character
        get() {

            val accelerate = 89
            val steer = 94
            val brake = 87
            val reverse = 82
            val lookBehind = 94
            val drift = 87

            val id = "8"
            val name = "Bowser"
            val photo = R.drawable.ic_bowser
            val cover = R.mipmap.bowser
            val description = "Bowser is the king of the turtle-like creatures called Koopas. His kart is good at crashing into other karts, due to the size. He'll usually try throwing lava balls to stop you."
            val abilities = Abilities.Builder.create()
                    .setAccelerate(accelerate)
                    .setBrake(steer)
                    .setDrift(brake)
                    .setLookBehind(reverse)
                    .setReverse(lookBehind)
                    .setSteer(drift)
                    .build()

            return Character.Builder.create()
                    .setId(id)
                    .setName(name)
                    .setPhoto(photo)
                    .setCover(cover)
                    .setDescription(description)
                    .setAbilities(abilities)
                    .build()
        }

    override fun provideCharacterList(): List<Character> {
        addCharacter(marioBros)
        addCharacter(luigi)
        addCharacter(daisy)
        addCharacter(toad)
        addCharacter(yoshi)
        addCharacter(dkong)
        addCharacter(wario)
        addCharacter(bowser)
        return this.characters
    }

    private fun addCharacter(character: Character) {
        this.characters.add(character)
    }
}
