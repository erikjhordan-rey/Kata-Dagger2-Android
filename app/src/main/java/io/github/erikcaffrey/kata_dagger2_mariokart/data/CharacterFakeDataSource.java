package io.github.erikcaffrey.kata_dagger2_mariokart.data;


import java.util.LinkedList;
import java.util.List;

import io.github.erikcaffrey.kata_dagger2_mariokart.domain.model.Abilities;
import io.github.erikcaffrey.kata_dagger2_mariokart.domain.model.Character;

public class CharacterFakeDataSource {

    private final List<Character> characters;

    public CharacterFakeDataSource() {
        this.characters = new LinkedList<>();
    }

    List<Character> provideCharacterList() {
        addCharacter(getMarioBros());
        addCharacter(getLuigi());
        addCharacter(getDaisy());
        addCharacter(getDkong());
        addCharacter(getToad());
        addCharacter(getYoshi());
        addCharacter(getBowser());
        addCharacter(getWario());
        return this.characters;
    }


    private Character getMarioBros() {

        final int accelerate = 100;
        final int steer = 95;
        final int brake = 83;
        final int reverse = 87;
        final int lookBehind = 100;
        final int drift = 100;

        final String name = "Mario Bros";
        final int photo = 0;
        final int cover = 0;
        final String description = "";
        final Abilities abilities = Abilities.Builder.create()
                .setAccelerate(accelerate)
                .setBrake(steer)
                .setDrift(brake)
                .setLookBehind(reverse)
                .setReverse(lookBehind)
                .setSteer(drift).build();

        return new Character(name, photo, cover, description, abilities);
    }

    private Character getLuigi() {

        final int accelerate = 100;
        final int steer = 95;
        final int brake = 83;
        final int reverse = 87;
        final int lookBehind = 100;
        final int drift = 100;

        final String name = "Luigi";
        final int photo = 0;
        final int cover = 0;
        final String description = "";
        final Abilities abilities = Abilities.Builder.create()
                .setAccelerate(accelerate)
                .setBrake(steer)
                .setDrift(brake)
                .setLookBehind(reverse)
                .setReverse(lookBehind)
                .setSteer(drift).build();

        return new Character(name, photo, cover, description, abilities);
    }

    private Character getDaisy() {

        final int accelerate = 100;
        final int steer = 95;
        final int brake = 83;
        final int reverse = 87;
        final int lookBehind = 100;
        final int drift = 100;

        final String name = "Daisy";
        final int photo = 0;
        final int cover = 0;
        final String description = "";
        final Abilities abilities = Abilities.Builder.create()
                .setAccelerate(accelerate)
                .setBrake(steer)
                .setDrift(brake)
                .setLookBehind(reverse)
                .setReverse(lookBehind)
                .setSteer(drift).build();

        return new Character(name, photo, cover, description, abilities);
    }

    private Character getToad() {

        final int accelerate = 100;
        final int steer = 95;
        final int brake = 83;
        final int reverse = 87;
        final int lookBehind = 100;
        final int drift = 100;

        final String name = "Toad";
        final int photo = 0;
        final int cover = 0;
        final String description = "";
        final Abilities abilities = Abilities.Builder.create()
                .setAccelerate(accelerate)
                .setBrake(steer)
                .setDrift(brake)
                .setLookBehind(reverse)
                .setReverse(lookBehind)
                .setSteer(drift).build();

        return new Character(name, photo, cover, description, abilities);
    }

    private Character getYoshi() {

        final int accelerate = 100;
        final int steer = 95;
        final int brake = 83;
        final int reverse = 87;
        final int lookBehind = 100;
        final int drift = 100;

        final String name = "Yoshi";
        final int photo = 0;
        final int cover = 0;
        final String description = "";
        final Abilities abilities = Abilities.Builder.create()
                .setAccelerate(accelerate)
                .setBrake(steer)
                .setDrift(brake)
                .setLookBehind(reverse)
                .setReverse(lookBehind)
                .setSteer(drift).build();

        return new Character(name, photo, cover, description, abilities);
    }

    private Character getDkong() {

        final int accelerate = 100;
        final int steer = 95;
        final int brake = 83;
        final int reverse = 87;
        final int lookBehind = 100;
        final int drift = 100;

        final String name = "Donkey Kong";
        final int photo = 0;
        final int cover = 0;
        final String description = "";
        final Abilities abilities = Abilities.Builder.create()
                .setAccelerate(accelerate)
                .setBrake(steer)
                .setDrift(brake)
                .setLookBehind(reverse)
                .setReverse(lookBehind)
                .setSteer(drift).build();

        return new Character(name, photo, cover, description, abilities);
    }

    private Character getWario() {

        final int accelerate = 100;
        final int steer = 95;
        final int brake = 83;
        final int reverse = 87;
        final int lookBehind = 100;
        final int drift = 100;

        final String name = "Wario";
        final int photo = 0;
        final int cover = 0;
        final String description = "";
        final Abilities abilities = Abilities.Builder.create()
                .setAccelerate(accelerate)
                .setBrake(steer)
                .setDrift(brake)
                .setLookBehind(reverse)
                .setReverse(lookBehind)
                .setSteer(drift).build();

        return new Character(name, photo, cover, description, abilities);
    }

    private Character getBowser() {

        final int accelerate = 100;
        final int steer = 95;
        final int brake = 83;
        final int reverse = 87;
        final int lookBehind = 100;
        final int drift = 100;

        final String name = "Bowser";
        final int photo = 0;
        final int cover = 0;
        final String description = "";
        final Abilities abilities = Abilities.Builder.create()
                .setAccelerate(accelerate)
                .setBrake(steer)
                .setDrift(brake)
                .setLookBehind(reverse)
                .setReverse(lookBehind)
                .setSteer(drift).build();

        return new Character(name, photo, cover, description, abilities);
    }

    private void addCharacter(Character character) {
        this.characters.add(character);
    }
}
