package io.github.frostzie.bedwars_sounds.config;

public enum SoundOptions {
    NONE("None"),
    BOOMER("Boomer"),
    BRUH("Bruh"),
    GOTCHA("Gotcha"),
    NOICE("Noice"),
    OKEY("Okey"),
    OOF("Oof"),
    QUACK("Quack"),
    SKEPPYJSP("SkeppyJSP");

    private final String name;

    SoundOptions(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    public String getSoundName() {
        if (this == NONE) {
            return null;
        }
        return "bedwars_sounds:" + this.name().toLowerCase();
    }
}
