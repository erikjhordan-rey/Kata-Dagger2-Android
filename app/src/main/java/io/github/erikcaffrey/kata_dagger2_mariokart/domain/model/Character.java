package io.github.erikcaffrey.kata_dagger2_mariokart.domain.model;


public class Character {

    private String name;
    private int photo;
    private int cover;
    private String description;
    private Abilities abilities;

    public Character(String name, int photo, int cover, String description, Abilities abilities) {
        this.name = name;
        this.photo = photo;
        this.cover = cover;
        this.description = description;
        this.abilities = abilities;
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
}
