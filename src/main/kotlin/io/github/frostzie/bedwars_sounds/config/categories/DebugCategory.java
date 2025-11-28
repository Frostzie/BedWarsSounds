package io.github.frostzie.bedwars_sounds.config.categories;

import com.google.gson.annotations.Expose;
import io.github.frostzie.bedwars_sounds.config.SoundOptions;
import io.github.frostzie.bedwars_sounds.features.SoundTest;
import io.github.notenoughupdates.moulconfig.annotations.ConfigEditorBoolean;
import io.github.notenoughupdates.moulconfig.annotations.ConfigEditorButton;
import io.github.notenoughupdates.moulconfig.annotations.ConfigEditorDropdown;
import io.github.notenoughupdates.moulconfig.annotations.ConfigOption;

public class DebugCategory {

    @Expose
    @ConfigOption(name = "Copy Chat to JSON", desc = "Copies all the chat messages and puts them inside a json file.")
    @ConfigEditorBoolean
    public Boolean copyChatToJson = false;
    
    @Expose
    @ConfigOption(name = "Choose the sound", desc = "Choose the sound that will be played when pressing Test Sound.")
    @ConfigEditorDropdown
    public SoundOptions testSoundChoice = SoundOptions.NONE;

    @ConfigOption(name = "Test Sound", desc = "Test out sounds")
    @ConfigEditorButton(buttonText = "Click")
    public Runnable testSound = this::onTestSoundClick;

    public void onTestSoundClick() {
        SoundTest.INSTANCE.playTestSound(testSoundChoice.getSoundName());
    }
}