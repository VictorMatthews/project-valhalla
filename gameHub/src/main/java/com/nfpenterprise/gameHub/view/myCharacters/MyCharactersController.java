package com.nfpenterprise.gameHub.view.myCharacters;

import com.nfpenterprise.gameHub.Main;
import com.nfpenterprise.gameHub.character.dto.CharacterDto;
import com.nfpenterprise.gameHub.constants.Attributes;
import com.nfpenterprise.gameHub.constants.SubRaces;
import com.nfpenterprise.gameHub.util.AttributesSkillsUtil;

import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class MyCharactersController {
	private AttributesSkillsUtil attributesSkillsUtil;

    @FXML private TableView<CharacterDto> myCharacterTable;
    @FXML private TableColumn<CharacterDto, String> characterNameColumn;

	@FXML private TextField strengthTxt;
	@FXML private TextField dexterityTxt;
	@FXML private TextField constitutionTxt;
	@FXML private TextField intelligenceTxt;
	@FXML private TextField wisdomTxt;
	@FXML private TextField charismaTxt;
	
	@FXML private TextField raceTxt;
	@FXML private TextField classTxt;

	@FXML private Label personalityTraitLabel;
	@FXML private Label idealLabel;
	@FXML private Label bondLabel;
	@FXML private Label flawLabel;

	@FXML private Label acrobaticsIncrease;
	@FXML private Label animalHandlingIncrease;
	@FXML private Label arcanaIncrease;
	@FXML private Label athleticsIncrease;
	@FXML private Label deceptionIncrease;
	@FXML private Label historyIncrease;
	@FXML private Label insightIncrease;
	@FXML private Label intimidationIncrease;
	@FXML private Label investigationIncrease;
	@FXML private Label medicineIncrease;
	@FXML private Label natureIncrease;
	@FXML private Label perceptionIncrease;
	@FXML private Label performanceIncrease;
	@FXML private Label persuasionIncrease;
	@FXML private Label religionIncrease;
	@FXML private Label sleightOfHandIncrease;
	@FXML private Label stealthIncrease;
	@FXML private Label survivalIncrease;

	@FXML private RadioButton acrobaticsRadioButton;
	@FXML private RadioButton animalHandlingRadioButton;
	@FXML private RadioButton arcanaRadioButton;
	@FXML private RadioButton athleticsRadioButton;
	@FXML private RadioButton deceptionRadioButton;
	@FXML private RadioButton historyRadioButton;
	@FXML private RadioButton insightRadioButton;
	@FXML private RadioButton intimidationRadioButton;
	@FXML private RadioButton investigationRadioButton;
	@FXML private RadioButton medicineRadioButton;
	@FXML private RadioButton natureRadioButton;
	@FXML private RadioButton perceptionRadioButton;
	@FXML private RadioButton performanceRadioButton;
	@FXML private RadioButton persuasionRadioButton;
	@FXML private RadioButton religionRadioButton;
	@FXML private RadioButton sleightOfHandRadioButton;
	@FXML private RadioButton stealthRadioButton;
	@FXML private RadioButton survivalRadioButton;

	private Main mainApp;

	public MyCharactersController() {
	}

	@FXML
	private void initialize() {
	    // Initialize the character table with the character name.
		characterNameColumn.setCellValueFactory(
	            cellData -> new ReadOnlyStringWrapper(cellData.getValue().getCharacterName()));

	    // Clear character details.
	    showCharacterDetails(null);

	    // Listen for selection changes and show the person details when changed.
	    myCharacterTable.getSelectionModel().selectedItemProperty().addListener(
	            (observable, oldValue, newValue) -> showCharacterDetails(newValue));

	    raceTxt.setDisable(true);
		classTxt.setDisable(true);
		strengthTxt.setDisable(true);
		dexterityTxt.setDisable(true);
		constitutionTxt.setDisable(true);
		intelligenceTxt.setDisable(true);
		wisdomTxt.setDisable(true);
		charismaTxt.setDisable(true);

		attributesSkillsUtil = new AttributesSkillsUtil(acrobaticsIncrease, animalHandlingIncrease, arcanaIncrease, athleticsIncrease, deceptionIncrease, historyIncrease,
				 insightIncrease, intimidationIncrease, investigationIncrease, medicineIncrease, natureIncrease, perceptionIncrease, performanceIncrease,
				 persuasionIncrease, religionIncrease, sleightOfHandIncrease, stealthIncrease, survivalIncrease, acrobaticsRadioButton, animalHandlingRadioButton,
				 arcanaRadioButton, athleticsRadioButton, deceptionRadioButton, historyRadioButton, insightRadioButton, intimidationRadioButton,
				 investigationRadioButton, medicineRadioButton, natureRadioButton, perceptionRadioButton, performanceRadioButton, persuasionRadioButton,
				 religionRadioButton, sleightOfHandRadioButton, stealthRadioButton, survivalRadioButton, strengthTxt, dexterityTxt,
				 intelligenceTxt, wisdomTxt, charismaTxt);
	}

	private void showCharacterDetails(CharacterDto character) {
		// TODO Auto-generated method stub
		if (character != null) {
			raceTxt.setText(character.getSubRace() == null ? "" : character.getSubRace().equalsIgnoreCase(SubRaces.NO_SUBRACE.getSubRaceName()) ? character.getRace() : character.getSubRace());
			classTxt.setText(character.getClassName() == null ? "" : character.getClassName());
			strengthTxt.setText(character.getStrength().toString());
			dexterityTxt.setText(character.getDexterity().toString());
			constitutionTxt.setText(character.getConstitution().toString());
			intelligenceTxt.setText(character.getIntelligence().toString());
			wisdomTxt.setText(character.getWisdom().toString());
			charismaTxt.setText(character.getCharisma().toString());
			personalityTraitLabel.setText(character.getPersonalityTrait());
			idealLabel.setText(character.getIdeals());
			bondLabel.setText(character.getBonds());
			flawLabel.setText(character.getFlaws());
		}

		attributesSkillsUtil.updateSkills(Attributes.STRENGTH);
		attributesSkillsUtil.updateSkills(Attributes.DEXTERITY);
		attributesSkillsUtil.updateSkills(Attributes.INTELLIGENCE);
		attributesSkillsUtil.updateSkills(Attributes.WISDOM);
		attributesSkillsUtil.updateSkills(Attributes.CHARISMA);
	}

	/**
     * Called when the user clicks the new button.
     */
    @FXML
    private void handleNewCharacter() {
        mainApp.showNewCharacterMain(false, null);
    }

    @FXML
    private void handleEditCharacter() {
    	CharacterDto selectedCharacter = null;
    	if (myCharacterTable != null && myCharacterTable.getSelectionModel() != null) {
    		selectedCharacter = myCharacterTable.getSelectionModel().getSelectedItem();
    	}
        mainApp.showNewCharacterMain(true, selectedCharacter);
    }

    @FXML
    private void handleDeleteCharacter() {
    	// TODO
    	if (myCharacterTable != null && myCharacterTable.getSelectionModel() != null) {
            int selectedIndex = myCharacterTable.getSelectionModel().getSelectedIndex();
            myCharacterTable.getItems().remove(selectedIndex);
    	}
    }

    @FXML
    private void handleExportCharacter() {
    	// TODO
    }

	public void setMainApp(Main main) {
		this.mainApp = main;

        // Add observable list data to the table
		if (myCharacterTable != null && mainApp != null) {
			myCharacterTable.setItems(mainApp.getMyCharacterData());
		}
	}

}
