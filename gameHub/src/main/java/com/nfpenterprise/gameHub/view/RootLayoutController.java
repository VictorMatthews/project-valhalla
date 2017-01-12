package com.nfpenterprise.gameHub.view;

import java.io.File;

import com.nfpenterprise.gameHub.Main;
import com.nfpenterprise.gameHub.character.dto.CharacterDto;
import com.nfpenterprise.gameHub.constants.Backgrounds;
import com.nfpenterprise.gameHub.constants.Bonds;
import com.nfpenterprise.gameHub.constants.Classes;
import com.nfpenterprise.gameHub.constants.Flaws;
import com.nfpenterprise.gameHub.constants.Ideals;
import com.nfpenterprise.gameHub.constants.PersonalityTraits;
import com.nfpenterprise.gameHub.constants.Races;
import com.nfpenterprise.gameHub.constants.SubRaces;

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
    	CharacterDto newCharacter = new CharacterDto();
    	newCharacter.setCharacterId(123456789);
    	newCharacter.setCharacterName("Aifur Gott");
    	newCharacter.setAlignment("Neutral Good");
    	newCharacter.setBackground(Backgrounds.CRIMINAL);
    	newCharacter.setRace(Races.GNOME);
    	newCharacter.setSubRace(SubRaces.FOREST_GNOME);
    	newCharacter.setClassName(Classes.BARD);
    	newCharacter.setClassLevel(1);
    	newCharacter.setExperience(0);
    	newCharacter.setStrength(8);
    	newCharacter.setDexterity(14);
    	newCharacter.setConstitution(14);
    	newCharacter.setIntelligence(14);
    	newCharacter.setWisdom(12);
    	newCharacter.setCharisma(14);
    	newCharacter.setPersonalityTrait(PersonalityTraits.CRIMINAL_3);
    	newCharacter.setIdeals(Ideals.CRIMINAL_5);
    	newCharacter.setBonds(Bonds.CRIMINAL_2);
    	newCharacter.setFlaws(Flaws.CRIMINAL_1);

    	return newCharacter;
    }

	public void setMainApp(Main main) {
		this.mainApp = main;
	}
}
