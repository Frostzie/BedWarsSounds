package io.github.frostzie.bedwars_sounds.config.categories;

import com.google.gson.annotations.Expose;
import io.github.frostzie.bedwars_sounds.config.SoundOptions;
import io.github.notenoughupdates.moulconfig.annotations.ConfigEditorDropdown;
import io.github.notenoughupdates.moulconfig.annotations.ConfigOption;

public class SoundCategory {

    @Expose
    @ConfigOption(name = "Normal Kill", desc = "Sound for a normal kill.")
    @ConfigEditorDropdown
    public SoundOptions normalKillSound = SoundOptions.OOF;

    @Expose
    @ConfigOption(name = "Void Kill", desc = "Sound for a void kill.")
    @ConfigEditorDropdown
    public SoundOptions voidKillSound = SoundOptions.OOF;

    @Expose
    @ConfigOption(name = "Bow Kill", desc = "Sound for a bow kill.")
    @ConfigEditorDropdown
    public SoundOptions bowKillSound = SoundOptions.OOF;

    @Expose
    @ConfigOption(name = "Ground Kill", desc = "Sound for a fall damage kill.")
    @ConfigEditorDropdown
    public SoundOptions groundKillSound = SoundOptions.OOF;

    @Expose
    @ConfigOption(name = "Golem Kill", desc = "Sound for a golem kill.")
    @ConfigEditorDropdown
    public SoundOptions golemKillSound = SoundOptions.OOF;

    @Expose
    @ConfigOption(name = "Bed Break", desc = "Sound for breaking a bed.")
    @ConfigEditorDropdown
    public SoundOptions bedBreakSound = SoundOptions.OOF;

    @Expose
    @ConfigOption(name = "Final Kill", desc = "Sound for a final kill.")
    @ConfigEditorDropdown
    public SoundOptions customFinalSound = SoundOptions.OOF;
}
