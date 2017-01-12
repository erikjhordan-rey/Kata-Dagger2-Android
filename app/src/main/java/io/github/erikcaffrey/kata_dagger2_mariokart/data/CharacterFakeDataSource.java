package io.github.erikcaffrey.kata_dagger2_mariokart.data;

import io.github.erikcaffrey.kata_dagger2_mariokart.R;
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
    final int photo = R.drawable.ic_mario;
    final int cover = R.mipmap.mario;
    final String description = "The plumber star of the series. His kart is average across the board. When Mario is controlled by the computer, his main item used is the Star.";
    final Abilities abilities = Abilities.Builder.create()
        .setAccelerate(accelerate)
        .setBrake(steer)
        .setDrift(brake)
        .setLookBehind(reverse)
        .setReverse(lookBehind)
        .setSteer(drift)
        .build();

    return new Character(name, photo, cover, description, abilities);
  }

  private Character getLuigi() {

    final int accelerate = 97;
    final int steer = 95;
    final int brake = 73;
    final int reverse = 97;
    final int lookBehind = 87;
    final int drift = 88;

    final String name = "Luigi";
    final int photo = R.drawable.ic_luigi;
    final int cover = R.mipmap.luigi;
    final String description = "Similar to his brother, Mario, his kart also have average status across the board. Also like Mario, when computer-controlled, his main item is the Star.";
    final Abilities abilities = Abilities.Builder.create()
        .setAccelerate(accelerate)
        .setBrake(steer)
        .setDrift(brake)
        .setLookBehind(reverse)
        .setReverse(lookBehind)
        .setSteer(drift)
        .build();

    return new Character(name, photo, cover, description, abilities);
  }

  private Character getDaisy() {

    final int accelerate = 88;
    final int steer = 95;
    final int brake = 85;
    final int reverse = 97;
    final int lookBehind = 89;
    final int drift = 82;

    final String name = "Daisy";
    final int photo = R.drawable.ic_daisy;
    final int cover = R.mipmap.daisy;
    final String description = "Princess Daisy is a “tomboy.” I’m not sure how this boyishness manifests itself in the character design—her choice of an unflattering yellow dress, maybe? But this “tomboy” stuff is euphemistic nonsense, anyway. I imagine Daisy is a closeted lesbian, plucked from the socially liberal dream world of Super Mario Land’s Sarasaland and forced to mold her identity to the Mushroom Kingdom’s rigid gender roles.";
    final Abilities abilities = Abilities.Builder.create()
        .setAccelerate(accelerate)
        .setBrake(steer)
        .setDrift(brake)
        .setLookBehind(reverse)
        .setReverse(lookBehind)
        .setSteer(drift)
        .build();

    return new Character(name, photo, cover, description, abilities);
  }

  private Character getToad() {

    final int accelerate = 79;
    final int steer = 98;
    final int brake = 86;
    final int reverse = 89;
    final int lookBehind = 90;
    final int drift = 93;

    final String name = "Toad";
    final int photo = R.drawable.ic_toad;
    final int cover = R.mipmap.toad;
    final String description = "Below par speed-wise. His kart turns the best, but often loses control when hit by larger opponents. Like Princess Peach, he'll try throwing mushrooms in your way when he's controlled by the computer.";
    final Abilities abilities = Abilities.Builder.create()
        .setAccelerate(accelerate)
        .setBrake(steer)
        .setDrift(brake)
        .setLookBehind(reverse)
        .setReverse(lookBehind)
        .setSteer(drift)
        .build();

    return new Character(name, photo, cover, description, abilities);
  }

  private Character getYoshi() {

    final int accelerate = 89;
    final int steer = 98;
    final int brake = 86;
    final int reverse = 82;
    final int lookBehind = 96;
    final int drift = 88;

    final String name = "Yoshi";
    final int photo = R.drawable.ic_yoshi;
    final int cover = R.mipmap.yoshi;
    final String description = "Yoshi is the green dinosaur-like creature from Super Mario World. His kart has the highest acceleration. When playing against him, he'll try throwing eggs in your way.";
    final Abilities abilities = Abilities.Builder.create()
        .setAccelerate(accelerate)
        .setBrake(steer)
        .setDrift(brake)
        .setLookBehind(reverse)
        .setReverse(lookBehind)
        .setSteer(drift)
        .build();

    return new Character(name, photo, cover, description, abilities);
  }

  private Character getDkong() {

    final int accelerate = 90;
    final int steer = 98;
    final int brake = 89;
    final int reverse = 97;
    final int lookBehind = 89;
    final int drift = 96;

    final String name = "Donkey Kong";
    final int photo = R.drawable.ic_dkong;
    final int cover = R.mipmap.dk;
    final String description = "The son of the famous gorilla, Donkey Kong. His kart's attributes are similar to Bowser's. His main item is bananas, which is what the computer uses when controlling him.";
    final Abilities abilities = Abilities.Builder.create()
        .setAccelerate(accelerate)
        .setBrake(steer)
        .setDrift(brake)
        .setLookBehind(reverse)
        .setReverse(lookBehind)
        .setSteer(drift)
        .build();

    return new Character(name, photo, cover, description, abilities);
  }

  private Character getWario() {

    final int accelerate = 98;
    final int steer = 92;
    final int brake = 86;
    final int reverse = 88;
    final int lookBehind = 96;
    final int drift = 89;

    final String name = "Wario";
    final int photo = R.drawable.ic_wario;
    final int cover = R.mipmap.wario;
    final String description = "Wario's dirty tricks bring him dangerously close to disqualification but somehow is always greenlit for the seasons that follow. Wario is the torrential counterpart and brother to Waluigi.";
    final Abilities abilities = Abilities.Builder.create()
        .setAccelerate(accelerate)
        .setBrake(steer)
        .setDrift(brake)
        .setLookBehind(reverse)
        .setReverse(lookBehind)
        .setSteer(drift)
        .build();

    return new Character(name, photo, cover, description, abilities);
  }

  private Character getBowser() {

    final int accelerate = 89;
    final int steer = 94;
    final int brake = 87;
    final int reverse = 82;
    final int lookBehind = 94;
    final int drift = 87;

    final String name = "Bowser";
    final int photo = R.drawable.ic_bowser;
    final int cover = R.mipmap.bowser;
    final String description = "Bowser is the king of the turtle-like creatures called Koopas. His kart is good at crashing into other karts, due to the size. He'll usually try throwing lava balls to stop you.";
    final Abilities abilities = Abilities.Builder.create()
        .setAccelerate(accelerate)
        .setBrake(steer)
        .setDrift(brake)
        .setLookBehind(reverse)
        .setReverse(lookBehind)
        .setSteer(drift)
        .build();

    return new Character(name, photo, cover, description, abilities);
  }

  private void addCharacter(Character character) {
    this.characters.add(character);
  }
}
