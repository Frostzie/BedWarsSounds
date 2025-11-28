package io.github.frostzie.bedwars_sounds.config.categories;

import com.google.gson.annotations.Expose;
import io.github.notenoughupdates.moulconfig.annotations.ConfigEditorBoolean;
import io.github.notenoughupdates.moulconfig.annotations.ConfigEditorText;
import io.github.notenoughupdates.moulconfig.annotations.ConfigOption;

public class MainCategory {

    @Expose
    @ConfigOption(name = "Enable", desc = "Enable the mods features")
    @ConfigEditorBoolean
    public Boolean enableMod = false;

    @Expose
    @ConfigOption(name = "Nick Name", desc = "Enter nick name if you have one if not leave empty!")
    @ConfigEditorText
    public String nickName = "";
}
