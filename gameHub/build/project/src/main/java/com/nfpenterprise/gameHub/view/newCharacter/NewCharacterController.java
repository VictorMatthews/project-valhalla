package com.nfpenterprise.gameHub.view.newCharacter;

import java.net.URL;
import java.util.Optional;
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
import com.nfpenterprise.gameHub.constants.PersonalityTraits;
import com.nfpenterprise.gameHub.constants.Races;
import com.nfpenterprise.gameHub.constants.SubRaces;
import com.nfpenterprise.gameHub.util.AttributesSkillsUtil;
import com.nfpenterprise.gameHub.util.DataController;
import com.nfpenterprise.gameHub.util.KeyValue;

import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
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
import javafx.scene.control.TextInputDialog;
import javafx.scene.web.WebView;

public class NewCharacterController {

	protected Main mainApp;
	protected AttributesSkillsUtil attributesSkillsUtil;
	protected CharacterDto newCharacter;
	protected CharacterDto characterBeingEdited;
	protected SingleSelectionModel<Tab> tabSelectionModel;
	protected DataController dataController;
	public ObservableList<Races> raceData;
	public ObservableList<SubRaces> subRaceData;
	public ObservableList<Classes> classData;
	protected final static Integer BASE_ATTRIBUTE_INCREASE = 27;
	protected final static Integer MIN_ATTRIBUTE_VALUE = 8;
	protected final static Integer MAX_ATTRIBUTE_VALUE = 15;
	protected Integer profSkillsToChoose = 0;
	protected ObservableList<SubRaces> subRacesFromRaces;
	protected boolean isEdit = false;

	@FXML
	protected TabPane tabs;
	@FXML
	protected Tab raceTab;
	@FXML
	protected Tab subRaceTab;
	@FXML
	protected Tab classTab;
	@FXML
	protected Tab backgorundTab;
	@FXML
	protected Tab attributesSkillsTab;
	@FXML
	protected TableView<Races> racesTable;
	@FXML
	protected TableColumn<Races, String> racesColumn;
	@FXML
	protected TableView<SubRaces> subRacesTable;
	@FXML
	protected TableColumn<SubRaces, String> subRacesColumn;
	@FXML
	protected TableView<Classes> classesTable;
	@FXML
	protected TableColumn<Classes, String> classesColumn;
	@FXML
	protected ComboBox<Backgrounds> cmbBackground;
	@FXML
	protected ComboBox<PersonalityTraits> cmbPersonalityTraits;
	@FXML
	protected ComboBox<Ideals> cmbIdeals;
	@FXML
	protected ComboBox<Bonds> cmbBonds;
	@FXML
	protected ComboBox<Flaws> cmbFlaws;
	@FXML
	protected WebView raceWebView;
	@FXML
	protected WebView subRaceWebView;
	@FXML
	protected WebView classWebView;
	@FXML
	protected WebView spellWebView;

	@FXML
	protected Label acrobaticsIncrease;
	@FXML
	protected Label animalHandlingIncrease;
	@FXML
	protected Label arcanaIncrease;
	@FXML
	protected Label athleticsIncrease;
	@FXML
	protected Label deceptionIncrease;
	@FXML
	protected Label historyIncrease;
	@FXML
	protected Label insightIncrease;
	@FXML
	protected Label intimidationIncrease;
	@FXML
	protected Label investigationIncrease;
	@FXML
	protected Label medicineIncrease;
	@FXML
	protected Label natureIncrease;
	@FXML
	protected Label perceptionIncrease;
	@FXML
	protected Label performanceIncrease;
	@FXML
	protected Label persuasionIncrease;
	@FXML
	protected Label religionIncrease;
	@FXML
	protected Label sleightOfHandIncrease;
	@FXML
	protected Label stealthIncrease;
	@FXML
	protected Label survivalIncrease;

	@FXML
	protected RadioButton acrobaticsRadioButton;
	@FXML
	protected RadioButton animalHandlingRadioButton;
	@FXML
	protected RadioButton arcanaRadioButton;
	@FXML
	protected RadioButton athleticsRadioButton;
	@FXML
	protected RadioButton deceptionRadioButton;
	@FXML
	protected RadioButton historyRadioButton;
	@FXML
	protected RadioButton insightRadioButton;
	@FXML
	protected RadioButton intimidationRadioButton;
	@FXML
	protected RadioButton investigationRadioButton;
	@FXML
	protected RadioButton medicineRadioButton;
	@FXML
	protected RadioButton natureRadioButton;
	@FXML
	protected RadioButton perceptionRadioButton;
	@FXML
	protected RadioButton performanceRadioButton;
	@FXML
	protected RadioButton persuasionRadioButton;
	@FXML
	protected RadioButton religionRadioButton;
	@FXML
	protected RadioButton sleightOfHandRadioButton;
	@FXML
	protected RadioButton stealthRadioButton;
	@FXML
	protected RadioButton survivalRadioButton;

	protected Set<KeyValue<Integer, KeyValue<RadioButton, Label>>> skillRadioButtons = null;

	@FXML
	protected Button strengthAdd;
	@FXML
	protected Button strengthSub;
	@FXML
	protected Button dexterityAdd;
	@FXML
	protected Button dexteritySub;
	@FXML
	protected Button constitutionAdd;
	@FXML
	protected Button constitutionSub;
	@FXML
	protected Button intelligenceAdd;
	@FXML
	protected Button intelligenceSub;
	@FXML
	protected Button wisdomAdd;
	@FXML
	protected Button wisdomSub;
	@FXML
	protected Button charismaAdd;
	@FXML
	protected Button charismaSub;

	@FXML
	protected TextField strengthTxt;
	@FXML
	protected TextField dexterityTxt;
	@FXML
	protected TextField constitutionTxt;
	@FXML
	protected TextField intelligenceTxt;
	@FXML
	protected TextField wisdomTxt;
	@FXML
	protected TextField charismaTxt;

	@FXML
	protected Label remainingAttributeIncrease;
	@FXML
	protected Label remainingSkillChoices;

	public NewCharacterController() {

	}

	@FXML
	protected void initialize() {
		isEdit = false;
		newCharacter = new CharacterDto();
		tabSelectionModel = tabs.getSelectionModel();
		dataController = new DataController();

		racesColumn.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getRaceName() + " " +
				mainApp.getClass().getClassLoader().getResource(cellData.getValue().getHtmlPath()).getPath() ));
		racesTable.getSelectionModel().selectedItemProperty()
				.addListener((observable, oldValue, newValue) -> showRaceDetails(oldValue, newValue));
		subRacesColumn.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getSubRaceName()));
		subRacesTable.getSelectionModel().selectedItemProperty()
				.addListener((observable, oldValue, newValue) -> showSubRaceDetails(newValue));
		classesColumn.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getClassName()));
		classesTable.getSelectionModel().selectedItemProperty()
				.addListener((observable, oldValue, newValue) -> showClassDetails(newValue));
		racesTable.setItems(dataController.populateRaceData());
		racesTable.getSelectionModel().selectFirst();

		classesTable.setItems(dataController.populateClassData());
		classesTable.getSelectionModel().selectFirst();
		loadHtmlIntoWebView(classesTable.getSelectionModel().getSelectedItem().getHtmlPath(), classWebView);

		cmbBackground.setItems(dataController.populateBackgroundData());
		cmbBackground.getSelectionModel().selectFirst();
		refreshBackground();

		attributesSkillsUtil = new AttributesSkillsUtil(acrobaticsIncrease, animalHandlingIncrease, arcanaIncrease,
				athleticsIncrease, deceptionIncrease, historyIncrease, insightIncrease, intimidationIncrease,
				investigationIncrease, medicineIncrease, natureIncrease, perceptionIncrease, performanceIncrease,
				persuasionIncrease, religionIncrease, sleightOfHandIncrease, stealthIncrease, survivalIncrease,
				acrobaticsRadioButton, animalHandlingRadioButton, arcanaRadioButton, athleticsRadioButton,
				deceptionRadioButton, historyRadioButton, insightRadioButton, intimidationRadioButton,
				investigationRadioButton, medicineRadioButton, natureRadioButton, perceptionRadioButton,
				performanceRadioButton, persuasionRadioButton, religionRadioButton, sleightOfHandRadioButton,
				stealthRadioButton, survivalRadioButton, strengthTxt, dexterityTxt, intelligenceTxt, wisdomTxt,
				charismaTxt, remainingSkillChoices);

		skillRadioButtons = attributesSkillsUtil.setupSkillKeyValues();
	}

	public void loadCharacter(CharacterDto characterToEdit) {
		isEdit = true;
		characterBeingEdited = characterToEdit;
		newCharacter = characterToEdit;

		loadTablesForEditableCharacter(racesTable, dataController.populateRaceData(), newCharacter.getRace());
		showRaceDetails(null, racesTable.getSelectionModel().getSelectedItem());
		loadTablesForEditableCharacter(subRacesTable,
				dataController.populateSubRaceData(racesTable.getSelectionModel().getSelectedItem()),
				newCharacter.getSubRace());
		showSubRaceDetails(subRacesTable.getSelectionModel().getSelectedItem());
		loadTablesForEditableCharacter(classesTable, dataController.populateClassData(), newCharacter.getClassName());
		showClassDetails(classesTable.getSelectionModel().getSelectedItem());
		loadCharacterBackgroundData(cmbBackground, dataController.populateBackgroundData(),
				newCharacter.getBackground());
		refreshBackground(cmbBackground.getSelectionModel().getSelectedItem(), newCharacter);
		updateCharacterData();

		handleAttributes();
		attributesSkillsUtil.handleSkills(profSkillsToChoose, newCharacter);
	}

	protected <T> void loadTablesForEditableCharacter(TableView<T> table, ObservableList<T> dataList, String newCharacterData) {
		if (table != null && table.getSelectionModel() != null) {
			for (T data : dataList) {
				if (newCharacterData.equals(data.toString())) {
					table.getSelectionModel().select(data);
					break;
				}
			}
		}
	}

	protected void showRaceDetails(Races oldRace, Races newRace) {
		if (oldRace == null) {
			oldRace = newRace;
			populateSubRaces(newRace);
		}

		if (!oldRace.equals(newRace) && !racesTable.getSelectionModel().getSelectedIndices().isEmpty()) {
			loadHtmlIntoWebView(newRace.getHtmlPath(), raceWebView);
			populateSubRaces(newRace);
		}
	}

	protected void populateSubRaces(Races race) {
		subRacesFromRaces = dataController.populateSubRaceData(race);
		if (subRacesFromRaces != null && !subRacesFromRaces.isEmpty()) {
			if (!subRacesFromRaces.contains(SubRaces.NO_SUBRACE)) {
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

	protected void showSubRaceDetails(SubRaces newSubRace) {
		if (newSubRace != null) {
			loadHtmlIntoWebView(newSubRace.getHtmlPath(), subRaceWebView);
		}
	}

	protected void showClassDetails(Classes newClass) {
		if (newClass != null) {
			loadHtmlIntoWebView(newClass.getHtmlPath(), classWebView);
		}
	}

	protected void loadHtmlIntoWebView(String htmlPath, WebView webView) {
		if (mainApp != null) {
			URL url = mainApp.getClass().getClassLoader().getResource(htmlPath);
			if (url != null) {
				webView.getEngine().load(url.toExternalForm());
			}
		}
	}

	public void setMainApp(Main main) {
		this.mainApp = main;
		if (racesTable != null && raceWebView != null && racesTable.getSelectionModel().getSelectedItem() != null) {
			loadHtmlIntoWebView(racesTable.getSelectionModel().getSelectedItem().getHtmlPath(), raceWebView);
		}
		if (racesTable != null && subRaceWebView != null
				&& subRacesTable.getSelectionModel().getSelectedItem() != null) {
			loadHtmlIntoWebView(subRacesTable.getSelectionModel().getSelectedItem().getHtmlPath(), subRaceWebView);
		}
		if (racesTable != null && classWebView != null && classesTable.getSelectionModel().getSelectedItem() != null) {
			loadHtmlIntoWebView(classesTable.getSelectionModel().getSelectedItem().getHtmlPath(), classWebView);
		}
	}

	@FXML
	protected void handleBack() {
		if (tabSelectionModel.getSelectedItem().equals(classTab) && subRacesFromRaces.contains(SubRaces.NO_SUBRACE)) {
			tabSelectionModel.selectPrevious();
			subRaceTab.setDisable(true);
		}
		tabSelectionModel.selectPrevious();
	}

	@FXML
	protected void handleNext() {
		if (tabSelectionModel.getSelectedItem().equals(raceTab) && subRacesFromRaces.contains(SubRaces.NO_SUBRACE)) {
			tabSelectionModel.selectNext();
			subRaceTab.setDisable(true);
		}
		tabSelectionModel.selectNext();
		tabSelectionModel.getSelectedItem().setDisable(false);
	}

	protected boolean updateCharacterData() {
		boolean dataChanged = false;
		if (tabSelectionModel != null) {
			String oldRace = newCharacter.getRace();
			String oldSubRace = newCharacter.getSubRace();
			String oldClass = newCharacter.getClassName();
			String oldBackground = newCharacter.getBackground();
			if (oldRace == null || (oldSubRace == null && !subRacesFromRaces.contains(SubRaces.NO_SUBRACE))
					|| oldClass == null || oldBackground.equals(null)) {
				dataChanged = true;
			}

			newCharacter.resetSetLists();
			Races selectedRace = racesTable.getSelectionModel().selectedItemProperty().getValue();
			SubRaces selectedSubRace = subRacesTable.getSelectionModel().selectedItemProperty().getValue();
			Classes selectedClass = classesTable.getSelectionModel().selectedItemProperty().getValue();
			Backgrounds selectedBackground = cmbBackground.getSelectionModel().getSelectedItem();
			PersonalityTraits selectedPersonalityTrait = cmbPersonalityTraits.getSelectionModel().getSelectedItem();
			Ideals selectedIdeal = cmbIdeals.getSelectionModel().getSelectedItem();
			Bonds selectedBond = cmbBonds.getSelectionModel().getSelectedItem();
			Flaws selectedFlaw = cmbFlaws.getSelectionModel().getSelectedItem();
			attributesSkillsUtil.setProfSkillChoices(selectedClass.getProfSkillsChoices());
			profSkillsToChoose = selectedClass.getProfSkillsToChoose();

			if ((oldRace != null && !oldRace.equals(selectedRace.getRaceName()))
					|| (oldSubRace != null && !oldSubRace.equals(selectedSubRace.getSubRaceName()))
					|| (oldClass != null && !oldClass.equals(selectedClass.getClassName()))
					|| (oldBackground != null && !oldBackground.equals(selectedBackground.getBackgroundName()))) {
				dataChanged = true;
			}

			newCharacter.setRace(selectedRace);
			newCharacter.setSubRace(selectedSubRace);
			newCharacter.setClassName(selectedClass);
			newCharacter.setBackground(selectedBackground);
			newCharacter.setPersonalityTrait(selectedPersonalityTrait);
			newCharacter.setIdeals(selectedIdeal);
			newCharacter.setBonds(selectedBond);
			newCharacter.setFlaws(selectedFlaw);
			newCharacter.setStrength(Integer.parseInt(strengthTxt.getText()));
			newCharacter.setDexterity(Integer.parseInt(dexterityTxt.getText()));
			newCharacter.setConstitution(Integer.parseInt(constitutionTxt.getText()));
			newCharacter.setIntelligence(Integer.parseInt(intelligenceTxt.getText()));
			newCharacter.setWisdom(Integer.parseInt(wisdomTxt.getText()));
			newCharacter.setCharisma(Integer.parseInt(charismaTxt.getText()));
			if (skillRadioButtons != null && !skillRadioButtons.isEmpty()) {
				for (KeyValue<Integer, KeyValue<RadioButton, Label>> skill : skillRadioButtons) {
					if (skill.getValue().getKey().isSelected()) {
						newCharacter.addProfSkill(skill.getKey());
					}
				}
			}
		}
		return dataChanged;
	}

	@FXML
	protected void handleAttributesAndSkills() {
		if (tabSelectionModel != null && tabSelectionModel.getSelectedItem().equals(attributesSkillsTab)) {
			boolean dataChanged = updateCharacterData();
			if (dataChanged) {
				handleAttributes();
				attributesSkillsUtil.handleSkills(profSkillsToChoose, newCharacter);
			}
		}
	}

	protected void handleAttributes() {
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

		attributesSkillsUtil.updateSkills(Attributes.STRENGTH);
		attributesSkillsUtil.updateSkills(Attributes.DEXTERITY);
		attributesSkillsUtil.updateSkills(Attributes.INTELLIGENCE);
		attributesSkillsUtil.updateSkills(Attributes.WISDOM);
		attributesSkillsUtil.updateSkills(Attributes.CHARISMA);

		strengthSub.setDisable(true);
		dexteritySub.setDisable(true);
		constitutionSub.setDisable(true);
		intelligenceSub.setDisable(true);
		wisdomSub.setDisable(true);
		charismaSub.setDisable(true);
		diasableAddButtons(false);
	}

	protected void handleAttributeAddSubBtn(TextField attributeValue, Button btnAdd, Button btnSub,
			Attributes attribute, boolean isAddition) {
		Integer oldValue = Integer.parseInt(attributeValue.getText());
		Integer newValue = oldValue;
		Integer raceAttributeIncrease = getRaceAttributeIncrease(attribute);
		Integer trueValue = Math.subtractExact(oldValue, raceAttributeIncrease);
		Integer oldAttributePoints = Integer.parseInt(remainingAttributeIncrease.getText());
		Integer newAttributePoints = oldAttributePoints;
		Integer attributeCost = getAttributeCost(trueValue, isAddition);

		if (isAddition) {
			newAttributePoints = Math.subtractExact(oldAttributePoints, attributeCost);
			newValue = Math.addExact(oldValue, 1);
			attributeValue.setText(newValue.toString());
			trueValue = Math.subtractExact(newValue, raceAttributeIncrease);
			enableAttributeBtn(trueValue, btnAdd, btnSub, isAddition);
		} else {
			newAttributePoints = Math.addExact(oldAttributePoints, attributeCost);
			newValue = Math.subtractExact(oldValue, 1);
			attributeValue.setText(newValue.toString());
			trueValue = Math.subtractExact(newValue, raceAttributeIncrease);
			enableAttributeBtn(trueValue, btnAdd, btnSub, isAddition);
			enableAddButtons(newAttributePoints);
		}

		remainingAttributeIncrease.setText(newAttributePoints.toString());

		if (newAttributePoints.equals(0)) {
			diasableAddButtons(true);
		}
		if ((oldAttributePoints.equals(2) || oldAttributePoints.equals(3)) && newAttributePoints.equals(1)) {
			enableAddButtons(newAttributePoints);
		}

		attributesSkillsUtil.updateSkills(attribute);
	}

	protected void enableAttributeBtn(Integer trueValue, Button btnAdd, Button btnSub, boolean isAddition) {
		if (isAddition) {
			if (!MIN_ATTRIBUTE_VALUE.equals(trueValue) && btnSub.isDisabled()) {
				btnSub.setDisable(false);
			}
			if (MAX_ATTRIBUTE_VALUE.equals(trueValue)) {
				btnAdd.setDisable(true);
			}
		} else {
			if (!MAX_ATTRIBUTE_VALUE.equals(trueValue) && btnAdd.isDisabled()) {
				btnAdd.setDisable(false);
			}
			if (MIN_ATTRIBUTE_VALUE.equals(trueValue)) {
				btnSub.setDisable(true);
			}
		}
	}

	protected Integer getAttributeCost(Integer trueValue, boolean isAddition) {
		Integer cost = 1;
		if (isAddition) {
			if (trueValue.equals(13) || trueValue.equals(14)) {
				cost = 2;
			}
		} else {
			if (trueValue.equals(14) || trueValue.equals(15)) {
				cost = 2;
			}
		}
		return cost;
	}

	protected void diasableAddButtons(boolean disable) {
		strengthAdd.setDisable(disable);
		dexterityAdd.setDisable(disable);
		constitutionAdd.setDisable(disable);
		intelligenceAdd.setDisable(disable);
		wisdomAdd.setDisable(disable);
		charismaAdd.setDisable(disable);
	}

	protected void enableAddButtons(Integer attributePoints) {
		Integer str = Math.subtractExact(Integer.parseInt(strengthTxt.getText()),
				getRaceAttributeIncrease(Attributes.STRENGTH));
		Integer dex = Math.subtractExact(Integer.parseInt(dexterityTxt.getText()),
				getRaceAttributeIncrease(Attributes.DEXTERITY));
		Integer con = Math.subtractExact(Integer.parseInt(constitutionTxt.getText()),
				getRaceAttributeIncrease(Attributes.CONSTITUTION));
		Integer intel = Math.subtractExact(Integer.parseInt(intelligenceTxt.getText()),
				getRaceAttributeIncrease(Attributes.INTELLIGENCE));
		Integer wis = Math.subtractExact(Integer.parseInt(wisdomTxt.getText()),
				getRaceAttributeIncrease(Attributes.WISDOM));
		Integer cha = Math.subtractExact(Integer.parseInt(charismaTxt.getText()),
				getRaceAttributeIncrease(Attributes.CHARISMA));

		strengthAdd.setDisable(false);
		dexterityAdd.setDisable(false);
		constitutionAdd.setDisable(false);
		intelligenceAdd.setDisable(false);
		wisdomAdd.setDisable(false);
		charismaAdd.setDisable(false);

		if (str.equals(15) || ((str.equals(13) || str.equals(14)) && attributePoints.equals(1))) {
			strengthAdd.setDisable(true);
		}
		if (dex.equals(15) || ((dex.equals(13) || dex.equals(14)) && attributePoints.equals(1))) {
			dexterityAdd.setDisable(true);
		}
		if (con.equals(15) || ((con.equals(13) || con.equals(14)) && attributePoints.equals(1))) {
			constitutionAdd.setDisable(true);
		}
		if (intel.equals(15) || ((intel.equals(13) || intel.equals(14)) && attributePoints.equals(1))) {
			intelligenceAdd.setDisable(true);
		}
		if (wis.equals(15) || ((wis.equals(13) || wis.equals(14)) && attributePoints.equals(1))) {
			wisdomAdd.setDisable(true);
		}
		if (cha.equals(15) || ((cha.equals(13) || cha.equals(14)) && attributePoints.equals(1))) {
			charismaAdd.setDisable(true);
		}
	}

	protected Integer getRaceAttributeIncrease(Attributes attribute) {
		for (AttributeDto attributeDto : newCharacter.getIncreaseAttributes()) {
			if (attributeDto.getAttributeId().equals(attribute.getAttributeId())) {
				return attributeDto.getIncreasedValue();
			}
		}
		return 0;
	}

	@FXML
	protected void handleFinish() {
		updateCharacterData();
		nameCharacter();
		newCharacter.getCharacterName();
		mainApp.getMyCharacterData().add(newCharacter);
		mainApp.saveCharacterDataToFile(mainApp.getCharactersFile());
		mainApp.showMyCharacters();
	}

	protected void nameCharacter() {
		TextInputDialog dialog = new TextInputDialog("");
		dialog.setTitle("Character Name");
		dialog.setHeaderText("What would you like to name your new character?");
		dialog.setContentText("Please enter your characters name:");
		Optional<String> result = dialog.showAndWait();
		result.ifPresent(characterName -> newCharacter.setCharacterName(characterName));
	}

	@FXML
	protected void handleCancel() {
		if (isEdit) {
			newCharacter = characterBeingEdited;
		}
		if (mainApp != null) {
			mainApp.showMyCharacters();
		}
	}

	@FXML
	protected void refreshBackground() {
		Backgrounds background = cmbBackground.getSelectionModel().getSelectedItem();
		if (background != null) {
			refreshBackground(background, newCharacter);
		}
	}

	protected void refreshBackground(Backgrounds background, CharacterDto character) {
		loadCharacterBackgroundData(cmbPersonalityTraits, dataController.populatePersonalityTraitData(background),
				isEdit == false ? null : character.getPersonalityTrait());
		loadCharacterBackgroundData(cmbIdeals, dataController.populateIdealData(background),
				isEdit == false ? null : character.getIdeals());
		loadCharacterBackgroundData(cmbBonds, dataController.populateBondData(background),
				isEdit == false ? null : character.getBonds());
		loadCharacterBackgroundData(cmbFlaws, dataController.populateFlawData(background),
				isEdit == false ? null : character.getFlaws());
	}

	protected <T> void loadCharacterBackgroundData(ComboBox<T> cmbBox, ObservableList<T> dataList,
			String characterData) {
		if (cmbBox != null && cmbBox.getSelectionModel() != null) {
			cmbBox.setItems(dataList);
			cmbBox.setDisable(false);

			if (characterData != null && !characterData.isEmpty()) {
				for (T data : dataList) {
					if (characterData.equals(data.toString())) {
						cmbBox.getSelectionModel().select(data);
						break;
					}
				}
			} else {
				cmbBox.getSelectionModel().selectFirst();
			}
		}
	}

	@FXML
	protected void handleSkillAcrobatics() {
		attributesSkillsUtil.handleSkillSelected(acrobaticsRadioButton, acrobaticsIncrease, true /* fromUserClick */);
	}

	@FXML
	protected void handleSkillAnimalHandling() {
		attributesSkillsUtil.handleSkillSelected(animalHandlingRadioButton, animalHandlingIncrease,
				true /* fromUserClick */);
	}

	@FXML
	protected void handleSkillArcana() {
		attributesSkillsUtil.handleSkillSelected(arcanaRadioButton, arcanaIncrease, true /* fromUserClick */);
	}

	@FXML
	protected void handleSkillAthletics() {
		attributesSkillsUtil.handleSkillSelected(athleticsRadioButton, athleticsIncrease, true /* fromUserClick */);
	}

	@FXML
	protected void handleSkillDeception() {
		attributesSkillsUtil.handleSkillSelected(deceptionRadioButton, deceptionIncrease, true /* fromUserClick */);
	}

	@FXML
	protected void handleSkillHistory() {
		attributesSkillsUtil.handleSkillSelected(historyRadioButton, historyIncrease, true /* fromUserClick */);
	}

	@FXML
	protected void handleSkillInsight() {
		attributesSkillsUtil.handleSkillSelected(insightRadioButton, insightIncrease, true /* fromUserClick */);
	}

	@FXML
	protected void handleSkillIntimidation() {
		attributesSkillsUtil.handleSkillSelected(intimidationRadioButton, intimidationIncrease,
				true /* fromUserClick */);
	}

	@FXML
	protected void handleSkillInvestigation() {
		attributesSkillsUtil.handleSkillSelected(investigationRadioButton, investigationIncrease,
				true /* fromUserClick */);
	}

	@FXML
	protected void handleSkillMedicine() {
		attributesSkillsUtil.handleSkillSelected(medicineRadioButton, medicineIncrease, true /* fromUserClick */);
	}

	@FXML
	protected void handleSkillNature() {
		attributesSkillsUtil.handleSkillSelected(natureRadioButton, natureIncrease, true /* fromUserClick */);
	}

	@FXML
	protected void handleSkillPerception() {
		attributesSkillsUtil.handleSkillSelected(perceptionRadioButton, perceptionIncrease, true /* fromUserClick */);
	}

	@FXML
	protected void handleSkillPerformance() {
		attributesSkillsUtil.handleSkillSelected(performanceRadioButton, performanceIncrease, true /* fromUserClick */);
	}

	@FXML
	protected void handleSkillPersuasion() {
		attributesSkillsUtil.handleSkillSelected(persuasionRadioButton, persuasionIncrease, true /* fromUserClick */);
	}

	@FXML
	protected void handleSkillReligion() {
		attributesSkillsUtil.handleSkillSelected(religionRadioButton, religionIncrease, true /* fromUserClick */);
	}

	@FXML
	protected void handleSkillSleightOfHand() {
		attributesSkillsUtil.handleSkillSelected(sleightOfHandRadioButton, sleightOfHandIncrease,
				true /* fromUserClick */);
	}

	@FXML
	protected void handleSkillStealth() {
		attributesSkillsUtil.handleSkillSelected(stealthRadioButton, stealthIncrease, true /* fromUserClick */);
	}

	@FXML
	protected void handleSkillSurvival() {
		attributesSkillsUtil.handleSkillSelected(survivalRadioButton, survivalIncrease, true /* fromUserClick */);
	}

	@FXML
	protected void handleAddStr() {
		handleAttributeAddSubBtn(strengthTxt, strengthAdd, strengthSub, Attributes.STRENGTH, true /* isAddition */);
	}

	@FXML
	protected void handleSubStr() {
		handleAttributeAddSubBtn(strengthTxt, strengthAdd, strengthSub, Attributes.STRENGTH, false /* isAddition */);
	}

	@FXML
	protected void handleAddDex() {
		handleAttributeAddSubBtn(dexterityTxt, dexterityAdd, dexteritySub, Attributes.DEXTERITY, true /* isAddition */);
	}

	@FXML
	protected void handleSubDex() {
		handleAttributeAddSubBtn(dexterityTxt, dexterityAdd, dexteritySub, Attributes.DEXTERITY,
				false /* isAddition */);
	}

	@FXML
	protected void handleAddCon() {
		handleAttributeAddSubBtn(constitutionTxt, constitutionAdd, constitutionSub, Attributes.CONSTITUTION,
				true /* isAddition */);

	}

	@FXML
	protected void handleSubCon() {
		handleAttributeAddSubBtn(constitutionTxt, constitutionAdd, constitutionSub, Attributes.CONSTITUTION,
				false /* isAddition */);
	}

	@FXML
	protected void handleAddInt() {
		handleAttributeAddSubBtn(intelligenceTxt, intelligenceAdd, intelligenceSub, Attributes.INTELLIGENCE,
				true /* isAddition */);
	}

	@FXML
	protected void handleSubInt() {
		handleAttributeAddSubBtn(intelligenceTxt, intelligenceAdd, intelligenceSub, Attributes.INTELLIGENCE,
				false /* isAddition */);
	}

	@FXML
	protected void handleAddWis() {
		handleAttributeAddSubBtn(wisdomTxt, wisdomAdd, wisdomSub, Attributes.WISDOM, true /* isAddition */);
	}

	@FXML
	protected void handleSubWis() {
		handleAttributeAddSubBtn(wisdomTxt, wisdomAdd, wisdomSub, Attributes.WISDOM, false /* isAddition */);
	}

	@FXML
	protected void handleAddCha() {
		handleAttributeAddSubBtn(charismaTxt, charismaAdd, charismaSub, Attributes.CHARISMA, true /* isAddition */);
	}

	@FXML
	protected void handleSubCha() {
		handleAttributeAddSubBtn(charismaTxt, charismaAdd, charismaSub, Attributes.CHARISMA, false /* isAddition */);
	}
}
