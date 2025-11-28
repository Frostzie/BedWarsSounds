package io.github.frostzie.bedwars_sounds.config.categories;

import com.google.gson.annotations.Expose;
import io.github.frostzie.bedwars_sounds.BedWarsSounds;
import io.github.notenoughupdates.moulconfig.Config;
import io.github.notenoughupdates.moulconfig.annotations.Category;

public class ModConfig extends Config {

    @Override
    public void saveNow() {
        BedWarsSounds.configManager.save();
    }

    @Expose
    @Category(name = "Main", desc = "Main category with all the settings!")
    public MainCategory mainCategory = new MainCategory();

    @Expose
    @Category(name = "Sounds", desc = "Configure sounds for different events.")
    public SoundCategory soundCategory = new SoundCategory();

    @Expose
    @Category(name = "Debug", desc = "Few debug features to make it easier to update mod.")
    public DebugCategory debugCategory = new DebugCategory();
}
