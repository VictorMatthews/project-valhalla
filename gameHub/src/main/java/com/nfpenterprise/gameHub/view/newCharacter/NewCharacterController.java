package com.nfpenterprise.gameHub.view.newCharacter;

import java.net.URL;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import com.nfpenterprise.gameHub.Main;
import com.nfpenterprise.gameHub.character.dto.AttributeDto;
import com.nfpenterprise.gameHub.character.dto.CharacterDto;
import com.nfpenterprise.gameHub.constants.Attributes;
import com.nfpenterprise.gameHub.constants.Backgrounds;
import com.nfpenterprise.gameHub.constants.Bonds;
import com.nfpenterprise.gameHub.constants.Classes;
import com.nfpenterprise.gameHub.constants.Flaws;
import com.nfpenterprise.gameHub.constants.Ideals;
import com.nfpenterprise.gameHub.constants.Message;
import com.nfpenterprise.gameHub.constants.PersonalityTraits;
import com.nfpenterprise.gameHub.constants.Races;
import com.nfpenterprise.gameHub.constants.SubRaces;
import com.nfpenterprise.gameHub.util.DataController;

import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.SingleSelectionModel;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.web.WebView;

public class NewCharacterController {

	private Main mainApp;
	private CharacterDto newCharacter;
	private SingleSelectionModel<Tab> tabSelectionModel;
	private DataController dataController;
	ObservableList<Races> raceData;
	ObservableList<SubRaces> subRaceData;
	ObservableList<Classes> classData;
	private final static Integer PROF_BONUS = 2;
	private final static Integer BASE_SKILL = -1;
	private final static Integer BASE_ATTRIBUTE_INCREASE = 27;
	private final static Integer MIN_ATTRIBUTE_VALUE = 8;
	private final static Integer MAX_ATTRIBUTE_VALUE = 15;
	private Set<Integer> profSkillChoices = new HashSet<Integer>();
	private Integer profSkillsToChoose = 0;

	@FXML private TabPane tabs;
	@FXML private Tab raceTab;
	@FXML private Tab subRaceTab;
	@FXML private Tab classTab;
	@FXML private Tab backgorundTab;
	@FXML private Tab attributesSkillsTab;
	@FXML private Tab spellsTab;
	@FXML private TableView<Races> racesTable;
    @FXML private TableColumn<Races, String> racesColumn;
	@FXML private TableView<SubRaces> subRacesTable;
    @FXML private TableColumn<SubRaces, String> subRacesColumn;
	@FXML private TableView<Classes> classesTable;
    @FXML private TableColumn<Classes, String> classesColumn;
	@FXML private ComboBox<Backgrounds> cmbBackground;
	@FXML private ComboBox<PersonalityTraits> cmbPersonalityTraits;
	@FXML private ComboBox<Ideals> cmbIdeals;
	@FXML private ComboBox<Bonds> cmbBonds;
	@FXML private ComboBox<Flaws> cmbFlaws;
	@FXML private WebView raceWebView;
	@FXML private WebView subRaceWebView;
	@FXML private WebView classWebView;
	@FXML private WebView spellWebView;
	
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
	private Set<RadioButton> skillRadioButtons = new HashSet<RadioButton>(Arrays.asList(acrobaticsRadioButton, animalHandlingRadioButton, arcanaRadioButton, athleticsRadioButton,
			deceptionRadioButton, historyRadioButton, insightRadioButton, intimidationRadioButton, investigationRadioButton, medicineRadioButton, natureRadioButton, perceptionRadioButton,
			performanceRadioButton, persuasionRadioButton, religionRadioButton, sleightOfHandRadioButton, stealthRadioButton, survivalRadioButton));
	
	@FXML private Button strengthAdd;
	@FXML private Button strengthSub;
	@FXML private Button dexterityAdd;
	@FXML private Button dexteritySub;
	@FXML private Button constitutionAdd;
	@FXML private Button constitutionSub;
	@FXML private Button intelligenceAdd;
	@FXML private Button intelligenceSub;
	@FXML private Button wisdomAdd;
	@FXML private Button wisdomSub;
	@FXML private Button charismaAdd;
	@FXML private Button charismaSub;

	@FXML private TextField strengthTxt;
	@FXML private TextField dexterityTxt;
	@FXML private TextField constitutionTxt;
	@FXML private TextField intelligenceTxt;
	@FXML private TextField wisdomTxt;
	@FXML private TextField charismaTxt;

	@FXML private Label remainingAttributeIncrease;
	@FXML private Label remainingSkillChoices;

	public NewCharacterController() {
		
	}

	@FXML
	private void initialize() {
		newCharacter = new CharacterDto();
		newCharacter.setCharacterId(getUniqueId());
		tabSelectionModel = tabs.getSelectionModel();
		dataController = new DataController();

		racesColumn.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getRaceName()));
		racesTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> showRaceDetails(oldValue, newValue));
		subRacesColumn.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getSubRaceName()));
		subRacesTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> showSubRaceDetails(newValue));
		classesColumn.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getClassName()));
		classesTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> showClassDetails(newValue));

		racesTable.setItems(dataController.populateRaceData());
		racesTable.getSelectionModel().selectFirst();

		classesTable.setItems(dataController.populateClassData());
		classesTable.getSelectionModel().selectFirst();
		loadHtmlIntoWebView(classesTable.getSelectionModel().getSelectedItem().getHtmlPath(), classWebView);

		cmbBackground.setItems(dataController.populateBackgroundData());
		cmbBackground.getSelectionModel().selectFirst();
		refreshBackground(); 
	}

	private void showRaceDetails(Races oldRace, Races newRace) {
		// TODO Incomplete
		if (oldRace == null) {
			oldRace = newRace;
			populateSubRaces(newRace);
		}

		if (!oldRace.equals(newRace)) {
			loadHtmlIntoWebView(newRace.getHtmlPath(), raceWebView);
			populateSubRaces(newRace);
		}
	}

	private void populateSubRaces(Races race) {
		ObservableList<SubRaces> subRacesFromRaces = dataController.populateSubRaceData(race);
		if (subRacesFromRaces != null && !subRacesFromRaces.isEmpty()) {
			if  (!subRacesFromRaces.contains(SubRaces.NO_SUBRACE)) {
				subRacesTable.setItems(subRacesFromRaces);
				subRacesTable.getSelectionModel().selectFirst();
				subRaceTab.setDisable(false);
			} else {
				subRaceTab.setDisable(true);
				subRacesTable.setItems(null);
				subRaceWebView.getEngine().load("");
			}
		}
	}

	private void showSubRaceDetails(SubRaces newSubRace) {
		if (newSubRace != null) { 
			loadHtmlIntoWebView(newSubRace.getHtmlPath(), subRaceWebView);
		}
	}

	private void showClassDetails(Classes newClass) {
		if (newClass != null) {
			loadHtmlIntoWebView(newClass.getHtmlPath(), classWebView);
		}
	}

	private void loadHtmlIntoWebView(String htmlPath, WebView webView) {
		if (mainApp != null) {
	        URL url = mainApp.getClass().getClassLoader().getResource(htmlPath);
			if (url != null) {
				webView.getEngine().load(url.toExternalForm());
			}
		}
	}

	private Integer getUniqueId() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setMainApp(Main main) {
		this.mainApp = main;
		if (racesTable.getSelectionModel().getSelectedItem() != null) {
			loadHtmlIntoWebView(racesTable.getSelectionModel().getSelectedItem().getHtmlPath(), raceWebView);
		}
		if (subRacesTable.getSelectionModel().getSelectedItem() != null) {
			loadHtmlIntoWebView(subRacesTable.getSelectionModel().getSelectedItem().getHtmlPath(), subRaceWebView);
		}
		if (classesTable.getSelectionModel().getSelectedItem() != null) {
			loadHtmlIntoWebView(classesTable.getSelectionModel().getSelectedItem().getHtmlPath(), classWebView);
		}
	}

    @FXML
    private void handleBack() {
    	tabSelectionModel.selectPrevious();
    }

	@FXML
    private void handleNext() {
//		if (subRacesFromRaces.contains(SubRaces.NO_SUBRACE)) {
//			subRaceTab.isDisabled();
//		}
		tabSelectionModel.selectNext();
		tabSelectionModel.getSelectedItem().setDisable(false);
    }

    private void updateCharacterData() {
		// TODO Not Finished
		if (tabSelectionModel != null) {
			newCharacter.resetSetLists();
			Races selectedRace = racesTable.getSelectionModel().selectedItemProperty().getValue();
			SubRaces selectedSubRace = subRacesTable.getSelectionModel().selectedItemProperty().getValue();
			Classes selectedClass = classesTable.getSelectionModel().selectedItemProperty().getValue();
			Backgrounds selectedBackground = cmbBackground.getSelectionModel().getSelectedItem();
			PersonalityTraits selectedPersonalityTrait = cmbPersonalityTraits.getSelectionModel().getSelectedItem();
			Ideals selectedIdeal = cmbIdeals.getSelectionModel().getSelectedItem();
			Bonds selectedBond = cmbBonds.getSelectionModel().getSelectedItem();
			Flaws selectedFlaw = cmbFlaws.getSelectionModel().getSelectedItem();
			profSkillChoices = classesTable.getSelectionModel().selectedItemProperty().getValue().getProfSkillsChoices();
			profSkillsToChoose = classesTable.getSelectionModel().selectedItemProperty().getValue().getProfSkillsToChoose();

			newCharacter.setRace(selectedRace);
			newCharacter.setSubRace(selectedSubRace);
			newCharacter.setClassName(selectedClass);
			newCharacter.setBackground(selectedBackground);
			newCharacter.setPersonalityTrait(selectedPersonalityTrait);
			newCharacter.setIdeals(selectedIdeal);
			newCharacter.setBonds(selectedBond);
			newCharacter.setFlaws(selectedFlaw);
		}
	}

	@FXML
	private void handleAttributesAndSkills() {
		updateCharacterData();
		handleAttributes();
		handleSkills();
	}

	private void handleAttributes() {
		remainingAttributeIncrease.setText(BASE_ATTRIBUTE_INCREASE.toString());

		Integer strengthVal = MIN_ATTRIBUTE_VALUE;
		Integer dexterityVal = MIN_ATTRIBUTE_VALUE;
		Integer constitutionVal = MIN_ATTRIBUTE_VALUE;
		Integer intelligenceVal = MIN_ATTRIBUTE_VALUE;
		Integer wisdomVal = MIN_ATTRIBUTE_VALUE;
		Integer charismaVal = MIN_ATTRIBUTE_VALUE;

		for (AttributeDto attributeDto : newCharacter.getIncreaseAttributes()) {
			if (attributeDto.getAttributeId().equals(Attributes.STRENGTH.getAttributeId())) {
				strengthVal = strengthVal + attributeDto.getIncreasedValue();
			}
			if (attributeDto.getAttributeId().equals(Attributes.DEXTERITY.getAttributeId())) {
				dexterityVal = dexterityVal + attributeDto.getIncreasedValue();
			}
			if (attributeDto.getAttributeId().equals(Attributes.CONSTITUTION.getAttributeId())) {
				constitutionVal = constitutionVal + attributeDto.getIncreasedValue();
			}
			if (attributeDto.getAttributeId().equals(Attributes.INTELLIGENCE.getAttributeId())) {
				intelligenceVal = intelligenceVal + attributeDto.getIncreasedValue();
			}
			if (attributeDto.getAttributeId().equals(Attributes.WISDOM.getAttributeId())) {
				wisdomVal = wisdomVal + attributeDto.getIncreasedValue();
			}
			if (attributeDto.getAttributeId().equals(Attributes.CHARISMA.getAttributeId())) {
				charismaVal = charismaVal + attributeDto.getIncreasedValue();
			}
		}

		strengthTxt.setText(strengthVal.toString());
		dexterityTxt.setText(dexterityVal.toString());
		constitutionTxt.setText(constitutionVal.toString());
		intelligenceTxt.setText(intelligenceVal.toString());
		wisdomTxt.setText(wisdomVal.toString());
		charismaTxt.setText(charismaVal.toString());

		updateSkills(Attributes.STRENGTH);
		updateSkills(Attributes.DEXTERITY);
		updateSkills(Attributes.INTELLIGENCE);
		updateSkills(Attributes.WISDOM);
		updateSkills(Attributes.CHARISMA);

		strengthSub.setDisable(true);
		dexteritySub.setDisable(true);
		constitutionSub.setDisable(true);
		intelligenceSub.setDisable(true);
		wisdomSub.setDisable(true);
		charismaSub.setDisable(true);		
	}

	private void handleSkills() {
		remainingSkillChoices.setText(profSkillsToChoose.toString());

	}

	private void handleIncreaseAttribute(TextField attributeValue, Button btnAdd, Button btnSub, Attributes attribute, boolean isAddition) {
		Integer currentValue = Integer.parseInt(attributeValue.getText());
		Integer lowerValue = currentValue -1;
		Integer higherValue = currentValue +1;

		Integer lowerDisableValue = lowerValue;
		Integer higherDisableValue = higherValue;
		
		Integer remainingAttributePoints = Integer.parseInt(remainingAttributeIncrease.getText());
		Integer currentAttributePoints = remainingAttributePoints;
			
		for (AttributeDto attributeDto : newCharacter.getIncreaseAttributes()) {
			if (attributeDto.getAttributeId().equals(attribute.getAttributeId())) {
				lowerDisableValue = lowerDisableValue - attributeDto.getIncreasedValue();
				higherDisableValue = higherDisableValue - attributeDto.getIncreasedValue();
			}
		}
		
		if (isAddition) {
			attributeValue.setText((higherValue).toString());

			if (!MIN_ATTRIBUTE_VALUE.equals(lowerDisableValue) && btnSub.isDisabled()) {
				btnSub.setDisable(false);
			}
			if (MAX_ATTRIBUTE_VALUE.equals(higherDisableValue)) {
				btnAdd.setDisable(true);
			}

			if (higherDisableValue - MIN_ATTRIBUTE_VALUE > 5) {
				remainingAttributePoints = remainingAttributePoints - 2;
			} else {
				remainingAttributePoints = remainingAttributePoints - 1;
			}
		} else {
			attributeValue.setText((lowerValue).toString());

			if (!MAX_ATTRIBUTE_VALUE.equals(higherDisableValue) && btnAdd.isDisabled()) {
				btnAdd.setDisable(false);
			}
			if (MIN_ATTRIBUTE_VALUE.equals(lowerDisableValue)) {
				btnSub.setDisable(true);
			}

			if (lowerDisableValue - MIN_ATTRIBUTE_VALUE > 4) {
				remainingAttributePoints = remainingAttributePoints + 2;
			} else {
				remainingAttributePoints = remainingAttributePoints + 1;
			}
		}

		remainingAttributeIncrease.setText(remainingAttributePoints.toString());

		if (remainingAttributePoints.equals(0)) {
			diasableAddButtons();
		}
		if (currentAttributePoints.equals(0) && remainingAttributePoints.intValue() > 0) {
			enableAddButtons();
		}

		updateSkills(attribute);
	}

	private void handleSkillSelected(RadioButton skill, Label skillIncrease) {
		Integer currentSkillValue = Integer.parseInt(skillIncrease.getText());
		if (skill.isSelected()) {
			Integer newSkillValue = currentSkillValue + PROF_BONUS;
			skillIncrease.setText(newSkillValue.toString());

			Integer skillsLeft = Integer.parseInt(remainingSkillChoices.getText()) - 1;
			remainingSkillChoices.setText(skillsLeft.toString());
		} else {
			Integer newSkillValue = currentSkillValue - PROF_BONUS;
			skillIncrease.setText(newSkillValue.toString());

			Integer skillsLeft = Integer.parseInt(remainingSkillChoices.getText()) + 1;
			remainingSkillChoices.setText(skillsLeft.toString());
		}


	}

    private void updateSkills(Attributes attribute) {
    	if (attribute.equals(Attributes.STRENGTH)) {
        	Integer strengthInc = getAttributeIncease(Integer.parseInt(strengthTxt.getText()));
    		athleticsIncrease.setText(strengthInc.toString());
    	}
    	if (attribute.equals(Attributes.DEXTERITY)) {
        	Integer dexterityInc = getAttributeIncease(Integer.parseInt(dexterityTxt.getText()));
    	    acrobaticsIncrease.setText(dexterityInc.toString());
    		sleightOfHandIncrease.setText(dexterityInc.toString());
    		stealthIncrease.setText(dexterityInc.toString());
    	}
    	if (attribute.equals(Attributes.INTELLIGENCE)) {
        	Integer intelligenceInc = getAttributeIncease(Integer.parseInt(intelligenceTxt.getText()));
    		arcanaIncrease.setText(intelligenceInc.toString());
    		historyIncrease.setText(intelligenceInc.toString());
    		investigationIncrease.setText(intelligenceInc.toString());
    		natureIncrease.setText(intelligenceInc.toString());
    		religionIncrease.setText(intelligenceInc.toString());
    	}
    	if (attribute.equals(Attributes.WISDOM)) {
        	Integer wisdomInc = getAttributeIncease(Integer.parseInt(wisdomTxt.getText()));
    		animalHandlingIncrease.setText(wisdomInc.toString());
    		insightIncrease.setText(wisdomInc.toString());
    		medicineIncrease.setText(wisdomInc.toString());
    		perceptionIncrease.setText(wisdomInc.toString());
    		survivalIncrease.setText(wisdomInc.toString());
    	}
    	if (attribute.equals(Attributes.CHARISMA)) {
        	Integer charismaInc = getAttributeIncease(Integer.parseInt(charismaTxt.getText()));
    		deceptionIncrease.setText(charismaInc.toString());
    		intimidationIncrease.setText(charismaInc.toString());
    		performanceIncrease.setText(charismaInc.toString());
    		persuasionIncrease.setText(charismaInc.toString());
    	}
	}

	private Integer getAttributeIncease(Integer attributeValue) {
		if (attributeValue.equals(8) || attributeValue.equals(9)) {
			return -1;
		}
		if (attributeValue.equals(10) || attributeValue.equals(11)) {
			return 0;
		}
		if (attributeValue.equals(12) || attributeValue.equals(13)) {
			return +1;
		}
		if (attributeValue.equals(14) || attributeValue.equals(15)) {
			return +2;
		}
		if (attributeValue.equals(16) || attributeValue.equals(17)) {
			return +3;
		}
		if (attributeValue.equals(18) || attributeValue.equals(19)) {
			return +4;
		}
		return -2;
	}

	private void diasableAddButtons() {
		strengthAdd.setDisable(true);
		dexterityAdd.setDisable(true);
		constitutionAdd.setDisable(true);
		intelligenceAdd.setDisable(true);
		wisdomAdd.setDisable(true);
		charismaAdd.setDisable(true);
	}

	private void enableAddButtons() {
		Integer str = Integer.parseInt(strengthTxt.getText());
		Integer dex = Integer.parseInt(dexterityTxt.getText());
		Integer con = Integer.parseInt(constitutionTxt.getText());
		Integer intel = Integer.parseInt(intelligenceTxt.getText());
		Integer wis = Integer.parseInt(wisdomTxt.getText());
		Integer cha = Integer.parseInt(charismaTxt.getText());

		strengthAdd.setDisable(false);
		dexterityAdd.setDisable(false);
		constitutionAdd.setDisable(false);
		intelligenceAdd.setDisable(false);
		wisdomAdd.setDisable(false);
		charismaAdd.setDisable(false);

		if (str.intValue() >= 15) {
			strengthAdd.setDisable(true);
		}
		if (dex.intValue() >= 15) {
			dexterityAdd.setDisable(true);
		}
		if (con.intValue() >= 15) {
			constitutionAdd.setDisable(true);
		}
		if (intel.intValue() >= 15) {
			intelligenceAdd.setDisable(true);
		}
		if (wis.intValue() >= 15) {
			wisdomAdd.setDisable(true);
		}
		if (cha.intValue() >= 15) {
			charismaAdd.setDisable(true);
		}	
	}

	@FXML
    private void handleFinish() {
		// TODO Not Finished
    	if (verifyFinished()) {
//    		updateCharacterData();
//    		mainApp.getMyCharacterData().add(newCharacter);
    		mainApp.showMyCharacters();
    	}
    }

	private boolean verifyFinished() {
		// TODO Not Finished
		Set<Message> messages = new HashSet<Message>();
		if (racesTable.getSelectionModel().selectedItemProperty().getValue() == null) {
			messages.add(Message.MUST_COMPLETE_RACE);
		}
		if (subRacesTable.getSelectionModel().selectedItemProperty().getValue() == null) {
			messages.add(Message.MUST_COMPLETE_SUB_RACE);
		}
		if (classesTable.getSelectionModel().selectedItemProperty().getValue() == null) {
			messages.add(Message.MUST_COMPLETE_CLASS);
		}
		if (!messages.isEmpty()) {
			screenNotCompleteError(messages);
			return false;
		}
		return true;
	}

    @FXML
    private void handleCancel() {
        mainApp.showMyCharacters();
    }

    @FXML
    private void refreshBackground() {
    	Backgrounds background = cmbBackground.getSelectionModel().getSelectedItem();
    	if (background != null) {
    		cmbPersonalityTraits.setItems(dataController.populatePersonalityTraitData(background));
    		cmbPersonalityTraits.getSelectionModel().selectFirst();
    		cmbPersonalityTraits.setDisable(false);

    		cmbIdeals.setItems(dataController.populateIdealData(background));
    		cmbIdeals.getSelectionModel().selectFirst();
    		cmbIdeals.setDisable(false);

    		cmbBonds.setItems(dataController.populateBondData(background));
    		cmbBonds.getSelectionModel().selectFirst();
    		cmbBonds.setDisable(false);

    		cmbFlaws.setItems(dataController.populateFlawData(background));
    		cmbFlaws.getSelectionModel().selectFirst();
    		cmbFlaws.setDisable(false);
    	}
    }

    private void screenNotCompleteError(Set<Message> messages) {
    	//TODO this should go in a util class!
    	Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("ERROR");
        alert.setHeaderText("Character Not Finished.");
        StringBuilder content = new StringBuilder();
        for (Message message : messages) {
        	content.append("\n" + message.toString());
        }
        alert.setContentText(content.toString());
        alert.showAndWait();
    }

    @FXML
    private void handleSkillAcrobatics() {
    	handleSkillSelected(acrobaticsRadioButton, acrobaticsIncrease);
    }

    @FXML
    private void handleSkillAnimalHandling() {
    	handleSkillSelected(animalHandlingRadioButton, animalHandlingIncrease);
    }

    @FXML
    private void handleSkillArcana() {
    	handleSkillSelected(arcanaRadioButton, arcanaIncrease);
    }

    @FXML
    private void handleSkillAthletics() {
    	handleSkillSelected(athleticsRadioButton, athleticsIncrease);
    }

    @FXML
    private void handleSkillDeception() {
    	handleSkillSelected(deceptionRadioButton, deceptionIncrease);
    }

    @FXML
    private void handleSkillHistory() {
    	handleSkillSelected(historyRadioButton, historyIncrease);
    }

    @FXML
    private void handleSkillInsight() {
    	handleSkillSelected(insightRadioButton, insightIncrease);
    }

    @FXML
    private void handleSkillIntimidation() {
    	handleSkillSelected(intimidationRadioButton, intimidationIncrease);
    }

    @FXML
    private void handleSkillInvestigation() {
    	handleSkillSelected(investigationRadioButton, investigationIncrease);
    }

    @FXML
    private void handleSkillMedicine() {
    	handleSkillSelected(medicineRadioButton, medicineIncrease);
    }

    @FXML
    private void handleSkillNature() {
    	handleSkillSelected(natureRadioButton, natureIncrease);
    }

    @FXML
    private void handleSkillPerception() {
    	handleSkillSelected(perceptionRadioButton, perceptionIncrease);
    }

    @FXML
    private void handleSkillPerformance() {
    	handleSkillSelected(performanceRadioButton, performanceIncrease);
    }

    @FXML
    private void handleSkillPersuasion() {
    	handleSkillSelected(persuasionRadioButton, persuasionIncrease);
    }

    @FXML
    private void handleSkillReligion() {
    	handleSkillSelected(religionRadioButton, religionIncrease);
    }

    @FXML
    private void handleSkillSleightOfHand() {
    	handleSkillSelected(sleightOfHandRadioButton, sleightOfHandIncrease);
    }

    @FXML
    private void handleSkillStealth() {
    	handleSkillSelected(stealthRadioButton, stealthIncrease);
    }

    @FXML
    private void handleSkillSurvival() {
    	handleSkillSelected(survivalRadioButton, survivalIncrease);
    }

	@FXML
	private void handleAddStr() {
		handleIncreaseAttribute(strengthTxt, strengthAdd, strengthSub, Attributes.STRENGTH, true /*isAddition*/);
	}

	@FXML
	private void handleSubStr() {
		handleIncreaseAttribute(strengthTxt, strengthAdd, strengthSub, Attributes.STRENGTH, false /*isAddition*/);		
	}

	@FXML
	private void handleAddDex() {
		handleIncreaseAttribute(dexterityTxt, dexterityAdd, dexteritySub, Attributes.DEXTERITY, true /*isAddition*/);
	}

	@FXML
	private void handleSubDex() {
		handleIncreaseAttribute(dexterityTxt, dexterityAdd, dexteritySub, Attributes.DEXTERITY, false /*isAddition*/);
	}

	@FXML
	private void handleAddCon() {
		handleIncreaseAttribute(constitutionTxt, constitutionAdd, constitutionSub, Attributes.CONSTITUTION, true /*isAddition*/);
		
	}

	@FXML
	private void handleSubCon() {
		handleIncreaseAttribute(constitutionTxt, constitutionAdd, constitutionSub, Attributes.CONSTITUTION, false /*isAddition*/);
	}

	@FXML
	private void handleAddInt() {
		handleIncreaseAttribute(intelligenceTxt, intelligenceAdd, intelligenceSub, Attributes.INTELLIGENCE, true /*isAddition*/);
	}

	@FXML
	private void handleSubInt() {
		handleIncreaseAttribute(intelligenceTxt, intelligenceAdd, intelligenceSub, Attributes.INTELLIGENCE, false /*isAddition*/);
	}

	@FXML
	private void handleAddWis() {
		handleIncreaseAttribute(wisdomTxt, wisdomAdd, wisdomSub, Attributes.WISDOM, true /*isAddition*/);
	}

	@FXML
	private void handleSubWis() {
		handleIncreaseAttribute(wisdomTxt, wisdomAdd, wisdomSub, Attributes.WISDOM, false /*isAddition*/);
	}

	@FXML
	private void handleAddCha() {
		handleIncreaseAttribute(charismaTxt, charismaAdd, charismaSub, Attributes.CHARISMA, true /*isAddition*/);
	}

	@FXML
	private void handleSubCha() {
		handleIncreaseAttribute(charismaTxt, charismaAdd, charismaSub, Attributes.CHARISMA, true /*isAddition*/);
	}
}
