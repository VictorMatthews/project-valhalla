package com.nfpenterprise.gameHub.view;

import java.io.File;

import com.nfpenterprise.gameHub.Main;
import com.nfpenterprise.gameHub.character.dto.CharacterDto;

import javafx.fxml.FXML;
import javafx.stage.FileChooser;

public class RootLayoutController {

	private Main mainApp;

    @FXML
    public void handleSave() {
        File charactersFile = mainApp.getCharactersFilePath();
        if (charactersFile != null) {
            mainApp.saveCharacterDataToFile(charactersFile);
        } else {
            handleSaveAs();
        }
    }


    @FXML
    private void handleSaveAs() {
        FileChooser fileChooser = new FileChooser();

        // Set extension filter
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter(
                "XML files (*.xml)", "*.xml");
        fileChooser.getExtensionFilters().add(extFilter);

        // Show save file dialog
        File file = fileChooser.showSaveDialog(mainApp.getPrimaryStage());

        if (file != null) {
            // Make sure it has the correct extension
            if (!file.getPath().endsWith(".xml")) {
                file = new File(file.getPath() + ".xml");
            }
            mainApp.saveCharacterDataToFile(file);
        }
    }

    public CharacterDto createTestCharacterData() {
    	CharacterDto newCharacter = new CharacterDto(123456789);
    	newCharacter.setCharacterName("My Character Name");
    	newCharacter.setAlignment("Neutral Good");
    	newCharacter.setBackground("Criminal");
    	newCharacter.setRace("Forest Gnome");
    	newCharacter.setClassName("Bard");
    	newCharacter.setClassLevel(1);
    	newCharacter.setExperience(0);
    	newCharacter.setStrength(8);
    	newCharacter.setDexterity(14);
    	newCharacter.setConstitution(14);
    	newCharacter.setIntelligence(14);
    	newCharacter.setWisdom(12);
    	newCharacter.setCharisma(14);
    	newCharacter.setPersonalityTrait("I do whatever I can to help the group over everything else.");
    	newCharacter.setIdeals("People. I'm loyal to my friends, not to any ideals, and everyone else can take a trip down the Styx for all I care. (Neutral)");
    	newCharacter.setBonds("My ill-gotten gains go to support my family.");
    	newCharacter.setFlaws("When I see something valuable, I can't think about anything but how to steal it.");

    	return newCharacter;
    }

	public void setMainApp(Main main) {
		this.mainApp = main;
	}
}
