package io.github.frostzie.bedwars_sounds.config.categories;

import com.google.gson.annotations.Expose;
import io.github.frostzie.bedwars_sounds.config.SoundOptions;
import io.github.notenoughupdates.moulconfig.annotations.ConfigEditorDropdown;
import io.github.notenoughupdates.moulconfig.annotations.ConfigEditorSlider;
import io.github.notenoughupdates.moulconfig.annotations.ConfigOption;

public class SoundCategory {

    @Expose
    @ConfigOption(name = "Sound Volume", desc = "Adjust the volume of all kill sounds (0-100%)")
    @ConfigEditorSlider(minValue = 0, maxValue = 100, minStep = 5)
    public int soundVolume = 100;

    @Expose
    @ConfigOption(name = "Custom Final Kill Sound", desc = "If it should play a different sound on final kills")
    @ConfigEditorDropdown
    public SoundOptions customFinalSound = SoundOptions.NONE;

    @Expose
    @ConfigOption(name = "Normal Kill", desc = "Sound for a normal kill.")
    @ConfigEditorDropdown
    public SoundOptions normalKillSound = SoundOptions.NONE;

    @Expose
    @ConfigOption(name = "Void Kill", desc = "Sound for a void kill.")
    @ConfigEditorDropdown
    public SoundOptions voidKillSound = SoundOptions.NONE;

    @Expose
    @ConfigOption(name = "Bow Kill", desc = "Sound for a bow kill.")
    @ConfigEditorDropdown
    public SoundOptions bowKillSound = SoundOptions.NONE;

    @Expose
    @ConfigOption(name = "Ground Kill", desc = "Sound for a fall damage kill.")
    @ConfigEditorDropdown
    public SoundOptions groundKillSound = SoundOptions.NONE;

    @Expose
    @ConfigOption(name = "Golem Kill", desc = "Sound for a golem kill.")
    @ConfigEditorDropdown
    public SoundOptions golemKillSound = SoundOptions.NONE;

    @Expose
    @ConfigOption(name = "Bed Break", desc = "Sound for breaking a bed.")
    @ConfigEditorDropdown
    public SoundOptions bedBreakSound = SoundOptions.NONE;

    @Expose
    @ConfigOption(name = "Custom Kill", desc = "Few Templates have custom kill messages like Glorious adding stats.")
    @ConfigEditorDropdown
    public SoundOptions customKillSound = SoundOptions.NONE;
}