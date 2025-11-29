package io.github.frostzie.bedwars_sounds.config.categories;

import com.google.gson.annotations.Expose;
import io.github.notenoughupdates.moulconfig.annotations.ConfigEditorText;
import io.github.notenoughupdates.moulconfig.annotations.ConfigOption;

public class CustomSoundCategory {

    @Expose
    @ConfigOption(name = "Final Kill (Custom)", desc = "Override with custom sound path (e.g., 'bedwars_sounds:mysound'). Leave empty to use dropdown.")
    @ConfigEditorText
    public String finalKillSoundCustom = "";

    @Expose
    @ConfigOption(name = "Normal Kill (Custom)", desc = "Custom sound path. Overrides dropdown if set.")
    @ConfigEditorText
    public String normalKillSoundCustom = "";

    @Expose
    @ConfigOption(name = "Void Kill (Custom)", desc = "Custom sound path. Overrides dropdown if set.")
    @ConfigEditorText
    public String voidKillSoundCustom = "";

    @Expose
    @ConfigOption(name = "Bow Kill (Custom)", desc = "Custom sound path. Overrides dropdown if set.")
    @ConfigEditorText
    public String bowKillSoundCustom = "";

    @Expose
    @ConfigOption(name = "Ground Kill (Custom)", desc = "Custom sound path. Overrides dropdown if set.")
    @ConfigEditorText
    public String groundKillSoundCustom = "";

    @Expose
    @ConfigOption(name = "Golem Kill (Custom)", desc = "Custom sound path. Overrides dropdown if set.")
    @ConfigEditorText
    public String golemKillSoundCustom = "";

    @Expose
    @ConfigOption(name = "Bed Break (Custom)", desc = "Custom sound path. Overrides dropdown if set.")
    @ConfigEditorText
    public String bedBreakSoundCustom = "";
}
