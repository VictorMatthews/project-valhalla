package com.nfpenterprise.gameHub.view.newCharacter;

import java.net.URL;
import java.util.Arrays;
import java.util.HashSet;
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
import com.nfpenterprise.gameHub.constants.Message;
import com.nfpenterprise.gameHub.constants.PersonalityTraits;
import com.nfpenterprise.gameHub.constants.Races;
import com.nfpenterprise.gameHub.constants.Skills;
import com.nfpenterprise.gameHub.constants.SubRaces;
import com.nfpenterprise.gameHub.util.DataController;
import com.nfpenterprise.gameHub.util.KeyValue;

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
import javafx.scene.control.TextInputDialog;
import javafx.scene.web.WebView;

public class NewCharacterController {

	private Main mainApp;
	private CharacterDto newCharacter;
	private SingleSelectionModel<Tab> tabSelectionModel;
	private DataController dataController;
	public ObservableList<Races> raceData;
	public ObservableList<SubRaces> subRaceData;
	public ObservableList<Classes> classData;
	private final static Integer PROF_BONUS = 2;
	private final static Integer BASE_ATTRIBUTE_INCREASE = 27;
	private final static Integer MIN_ATTRIBUTE_VALUE = 8;
	private final static Integer MAX_ATTRIBUTE_VALUE = 15;
	private Set<Integer> profSkillChoices = new HashSet<Integer>();
	private Integer profSkillsToChoose = 0;
	private ObservableList<SubRaces> subRacesFromRaces;

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

	private Set<KeyValue<Integer, KeyValue<RadioButton, Label>>> skillRadioButtons = null;
	
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

		skillRadioButtons = setupSkillKeyValues();
	}

	private void showRaceDetails(Races oldRace, Races newRace) {
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
		subRacesFromRaces = dataController.populateSubRaceData(race);
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
		if (tabSelectionModel.getSelectedItem().equals(classTab) && subRacesFromRaces.contains(SubRaces.NO_SUBRACE)) {
			tabSelectionModel.selectPrevious();
			subRaceTab.setDisable(true);
		}
    	tabSelectionModel.selectPrevious();
    }

	@FXML
    private void handleNext() {
		if (tabSelectionModel.getSelectedItem().equals(raceTab) && subRacesFromRaces.contains(SubRaces.NO_SUBRACE)) {
			tabSelectionModel.selectNext();
			subRaceTab.setDisable(true);
		}
		tabSelectionModel.selectNext();
		tabSelectionModel.getSelectedItem().setDisable(false);
    }

    private boolean updateCharacterData() {
		// TODO Not Finished
    	boolean dataChanged = false;
		if (tabSelectionModel != null) {
			String oldRace = newCharacter.getRace();
			String oldSubRace = newCharacter.getSubRace();
			String oldClass = newCharacter.getClassName();
			String oldBackground = newCharacter.getBackground();
			if (oldRace == null || (oldSubRace == null && !subRacesFromRaces.contains(SubRaces.NO_SUBRACE)) || oldClass == null || oldBackground.equals(null)) {
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
			profSkillChoices = selectedClass.getProfSkillsChoices();
			profSkillsToChoose = selectedClass.getProfSkillsToChoose();

			if ((oldRace != null && !oldRace.equals(selectedRace.getRaceName())) || 
					(oldSubRace != null &&  !oldSubRace.equals(selectedSubRace.getSubRaceName())) ||
					(oldClass != null &&  !oldClass.equals(selectedClass.getClassName())) || 
					(oldBackground != null &&  !oldBackground.equals(selectedBackground.getBackgroundName()))) {
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
	private void handleAttributesAndSkills() {
		if (tabSelectionModel != null && tabSelectionModel.getSelectedItem().equals(attributesSkillsTab)) {
			boolean dataChanged = updateCharacterData();
			if (dataChanged) {
				handleAttributes();
				handleSkills(profSkillsToChoose);	
			}		
		}
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
		diasableAddButtons(false);
	}

	private void handleAttributeAddSubBtn(TextField attributeValue, Button btnAdd, Button btnSub, Attributes attribute, boolean isAddition) {
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

		updateSkills(attribute);
	}

	private void enableAttributeBtn(Integer trueValue, Button btnAdd, Button btnSub, boolean isAddition) {
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

	private Integer getAttributeCost(Integer trueValue, boolean isAddition) {
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

	private void handleSkills(Integer skillsRemaining) {
		for (KeyValue<Integer, KeyValue<RadioButton, Label>> skillKV : skillRadioButtons) {
			skillKV.getValue().getKey().setSelected(false);
		}

		remainingSkillChoices.setText(skillsRemaining.toString());
		disableAllUnselectedSkillChoices(false);
		for (Integer skill : newCharacter.getProfSkills()) {
			for (KeyValue<Integer, KeyValue<RadioButton, Label>> skillKV : skillRadioButtons) {
				if (!profSkillChoices.contains(skillKV.getKey())) {
					skillKV.getValue().getKey().setDisable(true);
				}
				if (skillKV.getKey().equals(skill)) {
					skillKV.getValue().getKey().setSelected(true);
					handleSkillSelected(skillKV.getValue().getKey(), skillKV.getValue().getValue(), false /*fromUserClick*/);
				}
			}
		}
	}

	private void handleSkillSelected(RadioButton skill, Label skillIncrease, boolean fromUserClick) {
		Integer oldSkillValue = Integer.parseInt(skillIncrease.getText());
		Integer oldSkillsRemaining = Integer.parseInt(remainingSkillChoices.getText());
		Integer newSkillsRemaining = oldSkillsRemaining;
		if (skill.isSelected()) {
			Integer newSkillValue = oldSkillValue + PROF_BONUS;
			skillIncrease.setText(newSkillValue.toString());

			if (fromUserClick) {
				newSkillsRemaining = Math.subtractExact(oldSkillsRemaining, 1);
				remainingSkillChoices.setText(newSkillsRemaining.toString());
			} else {
				skill.setDisable(true);
			}
		} else {
			Integer newSkillValue = oldSkillValue - PROF_BONUS;
			skillIncrease.setText(newSkillValue.toString());

			if (fromUserClick) {
				newSkillsRemaining = Math.addExact(oldSkillsRemaining, 1);
				remainingSkillChoices.setText(newSkillsRemaining.toString());
			}
		}
		if (newSkillsRemaining.equals(0)) {
			disableAllUnselectedSkillChoices(true);
		}
		if (oldSkillsRemaining.equals(0) && newSkillsRemaining.equals(1)) {
			disableAllUnselectedSkillChoices(false);
		}
	}

    private void disableAllUnselectedSkillChoices(boolean disable) {
    	for (KeyValue<Integer, KeyValue<RadioButton, Label>> skillKV : skillRadioButtons) {
			skillKV.getValue().getKey().setDisable(disable);
			if (skillKV.getValue().getKey().isSelected()) {
				skillKV.getValue().getKey().setDisable(false);
			}
			if (!profSkillChoices.contains(skillKV.getKey())) {
				skillKV.getValue().getKey().setDisable(true);
			}
			if (newCharacter.getProfSkills().contains(skillKV.getKey())) {
				skillKV.getValue().getKey().setDisable(true);				
			}
    	}
	}

	private void updateSkills(Attributes attribute) {
    	if (attribute.equals(Attributes.STRENGTH)) {
        	Integer strengthInc = getAttributeIncease(Integer.parseInt(strengthTxt.getText()));

        	Integer athletics = athleticsRadioButton.isSelected() ? Math.addExact(strengthInc, PROF_BONUS) : strengthInc;
    		athleticsIncrease.setText(athletics.toString());
    	}
    	if (attribute.equals(Attributes.DEXTERITY)) {
        	Integer dexterityInc = getAttributeIncease(Integer.parseInt(dexterityTxt.getText()));

        	Integer acrobatics = acrobaticsRadioButton.isSelected() ? Math.addExact(dexterityInc, PROF_BONUS) : dexterityInc;
    	    acrobaticsIncrease.setText(acrobatics.toString());

        	Integer sleightOfHand = sleightOfHandRadioButton.isSelected() ? Math.addExact(dexterityInc, PROF_BONUS) : dexterityInc;
    		sleightOfHandIncrease.setText(sleightOfHand.toString());

        	Integer stealth = stealthRadioButton.isSelected() ? Math.addExact(dexterityInc, PROF_BONUS) : dexterityInc;
    		stealthIncrease.setText(stealth.toString());
    	}
    	if (attribute.equals(Attributes.INTELLIGENCE)) {
        	Integer intelligenceInc = getAttributeIncease(Integer.parseInt(intelligenceTxt.getText()));

        	Integer arcana = arcanaRadioButton.isSelected() ? Math.addExact(intelligenceInc, PROF_BONUS) : intelligenceInc;
    		arcanaIncrease.setText(arcana.toString());

        	Integer history = historyRadioButton.isSelected() ? Math.addExact(intelligenceInc, PROF_BONUS) : intelligenceInc;
    		historyIncrease.setText(history.toString());

    		Integer investigation = investigationRadioButton.isSelected() ? Math.addExact(intelligenceInc, PROF_BONUS) : intelligenceInc;
    		investigationIncrease.setText(investigation.toString());

        	Integer nature = natureRadioButton.isSelected() ? Math.addExact(intelligenceInc, PROF_BONUS) : intelligenceInc;
    		natureIncrease.setText(nature.toString());

        	Integer religion = religionRadioButton.isSelected() ? Math.addExact(intelligenceInc, PROF_BONUS) : intelligenceInc;
    		religionIncrease.setText(religion.toString());
    	}
    	if (attribute.equals(Attributes.WISDOM)) {
        	Integer wisdomInc = getAttributeIncease(Integer.parseInt(wisdomTxt.getText()));
        	
        	Integer animalHandling = animalHandlingRadioButton.isSelected() ? Math.addExact(wisdomInc, PROF_BONUS) : wisdomInc;
    		animalHandlingIncrease.setText(animalHandling.toString());
    		
        	Integer insight = insightRadioButton.isSelected() ? Math.addExact(wisdomInc, PROF_BONUS) : wisdomInc;
    		insightIncrease.setText(insight.toString());
    		
        	Integer medicine = medicineRadioButton.isSelected() ? Math.addExact(wisdomInc, PROF_BONUS) : wisdomInc;
    		medicineIncrease.setText(medicine.toString());
    		
        	Integer perception = perceptionRadioButton.isSelected() ? Math.addExact(wisdomInc, PROF_BONUS) : wisdomInc;
    		perceptionIncrease.setText(perception.toString());

        	Integer survival = survivalRadioButton.isSelected() ? Math.addExact(wisdomInc, PROF_BONUS) : wisdomInc;
    		survivalIncrease.setText(survival.toString());
    	}
    	if (attribute.equals(Attributes.CHARISMA)) {
        	Integer charismaInc = getAttributeIncease(Integer.parseInt(charismaTxt.getText()));
        	
        	Integer deception = deceptionRadioButton.isSelected() ? Math.addExact(charismaInc, PROF_BONUS) : charismaInc;
    		deceptionIncrease.setText(deception.toString());
    		
        	Integer intimidation = intimidationRadioButton.isSelected() ? Math.addExact(charismaInc, PROF_BONUS) : charismaInc;
    		intimidationIncrease.setText(intimidation.toString());
    		
        	Integer performance = performanceRadioButton.isSelected() ? Math.addExact(charismaInc, PROF_BONUS) : charismaInc;
    		performanceIncrease.setText(performance.toString());
    		
        	Integer persuasion = persuasionRadioButton.isSelected() ? Math.addExact(charismaInc, PROF_BONUS) : charismaInc;
    		persuasionIncrease.setText(persuasion.toString());
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

	private void diasableAddButtons(boolean disable) {
		strengthAdd.setDisable(disable);
		dexterityAdd.setDisable(disable);
		constitutionAdd.setDisable(disable);
		intelligenceAdd.setDisable(disable);
		wisdomAdd.setDisable(disable);
		charismaAdd.setDisable(disable);
	}

	private void enableAddButtons(Integer attributePoints) {
		Integer str = Math.subtractExact(Integer.parseInt(strengthTxt.getText()), getRaceAttributeIncrease(Attributes.STRENGTH));
		Integer dex = Math.subtractExact(Integer.parseInt(dexterityTxt.getText()), getRaceAttributeIncrease(Attributes.DEXTERITY));
		Integer con = Math.subtractExact(Integer.parseInt(constitutionTxt.getText()), getRaceAttributeIncrease(Attributes.CONSTITUTION));
		Integer intel = Math.subtractExact(Integer.parseInt(intelligenceTxt.getText()), getRaceAttributeIncrease(Attributes.INTELLIGENCE));
		Integer wis = Math.subtractExact(Integer.parseInt(wisdomTxt.getText()), getRaceAttributeIncrease(Attributes.WISDOM));
		Integer cha = Math.subtractExact(Integer.parseInt(charismaTxt.getText()), getRaceAttributeIncrease(Attributes.CHARISMA));

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

	private Integer getRaceAttributeIncrease(Attributes attribute) {
		for (AttributeDto attributeDto : newCharacter.getIncreaseAttributes()) {
			if (attributeDto.getAttributeId().equals(attribute.getAttributeId())) {
				return attributeDto.getIncreasedValue();
			}
		}
		return 0;
	}

	@FXML
    private void handleFinish() {
		// TODO Not Finished
		updateCharacterData();
		nameCharacter();
		newCharacter.getCharacterName();
		mainApp.getMyCharacterData().add(newCharacter);
		mainApp.showMyCharacters();
    }

	private void nameCharacter() {
		TextInputDialog dialog = new TextInputDialog("");
		dialog.setTitle("Character Name");
		dialog.setHeaderText("What would you like to name your new character?");
		dialog.setContentText("Please enter your characters name:");
		Optional<String> result = dialog.showAndWait();
		result.ifPresent(characterName -> newCharacter.setCharacterName(characterName));
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

    @FXML
    private void handleSkillAcrobatics() {
    	handleSkillSelected(acrobaticsRadioButton, acrobaticsIncrease, true /*fromUserClick*/);
    }

    @FXML
    private void handleSkillAnimalHandling() {
    	handleSkillSelected(animalHandlingRadioButton, animalHandlingIncrease, true /*fromUserClick*/);
    }

    @FXML
    private void handleSkillArcana() {
    	handleSkillSelected(arcanaRadioButton, arcanaIncrease, true /*fromUserClick*/);
    }

    @FXML
    private void handleSkillAthletics() {
    	handleSkillSelected(athleticsRadioButton, athleticsIncrease, true /*fromUserClick*/);
    }

    @FXML
    private void handleSkillDeception() {
    	handleSkillSelected(deceptionRadioButton, deceptionIncrease, true /*fromUserClick*/);
    }

    @FXML
    private void handleSkillHistory() {
    	handleSkillSelected(historyRadioButton, historyIncrease, true /*fromUserClick*/);
    }

    @FXML
    private void handleSkillInsight() {
    	handleSkillSelected(insightRadioButton, insightIncrease, true /*fromUserClick*/);
    }

    @FXML
    private void handleSkillIntimidation() {
    	handleSkillSelected(intimidationRadioButton, intimidationIncrease, true /*fromUserClick*/);
    }

    @FXML
    private void handleSkillInvestigation() {
    	handleSkillSelected(investigationRadioButton, investigationIncrease, true /*fromUserClick*/);
    }

    @FXML
    private void handleSkillMedicine() {
    	handleSkillSelected(medicineRadioButton, medicineIncrease, true /*fromUserClick*/);
    }

    @FXML
    private void handleSkillNature() {
    	handleSkillSelected(natureRadioButton, natureIncrease, true /*fromUserClick*/);
    }

    @FXML
    private void handleSkillPerception() {
    	handleSkillSelected(perceptionRadioButton, perceptionIncrease, true /*fromUserClick*/);
    }

    @FXML
    private void handleSkillPerformance() {
    	handleSkillSelected(performanceRadioButton, performanceIncrease, true /*fromUserClick*/);
    }

    @FXML
    private void handleSkillPersuasion() {
    	handleSkillSelected(persuasionRadioButton, persuasionIncrease, true /*fromUserClick*/);
    }

    @FXML
    private void handleSkillReligion() {
    	handleSkillSelected(religionRadioButton, religionIncrease, true /*fromUserClick*/);
    }

    @FXML
    private void handleSkillSleightOfHand() {
    	handleSkillSelected(sleightOfHandRadioButton, sleightOfHandIncrease, true /*fromUserClick*/);
    }

    @FXML
    private void handleSkillStealth() {
    	handleSkillSelected(stealthRadioButton, stealthIncrease, true /*fromUserClick*/);
    }

    @FXML
    private void handleSkillSurvival() {
    	handleSkillSelected(survivalRadioButton, survivalIncrease, true /*fromUserClick*/);
    }

	@FXML
	private void handleAddStr() {
		handleAttributeAddSubBtn(strengthTxt, strengthAdd, strengthSub, Attributes.STRENGTH, true /*isAddition*/);
	}

	@FXML
	private void handleSubStr() {
		handleAttributeAddSubBtn(strengthTxt, strengthAdd, strengthSub, Attributes.STRENGTH, false /*isAddition*/);		
	}

	@FXML
	private void handleAddDex() {
		handleAttributeAddSubBtn(dexterityTxt, dexterityAdd, dexteritySub, Attributes.DEXTERITY, true /*isAddition*/);
	}

	@FXML
	private void handleSubDex() {
		handleAttributeAddSubBtn(dexterityTxt, dexterityAdd, dexteritySub, Attributes.DEXTERITY, false /*isAddition*/);
	}

	@FXML
	private void handleAddCon() {
		handleAttributeAddSubBtn(constitutionTxt, constitutionAdd, constitutionSub, Attributes.CONSTITUTION, true /*isAddition*/);
		
	}

	@FXML
	private void handleSubCon() {
		handleAttributeAddSubBtn(constitutionTxt, constitutionAdd, constitutionSub, Attributes.CONSTITUTION, false /*isAddition*/);
	}

	@FXML
	private void handleAddInt() {
		handleAttributeAddSubBtn(intelligenceTxt, intelligenceAdd, intelligenceSub, Attributes.INTELLIGENCE, true /*isAddition*/);
	}

	@FXML
	private void handleSubInt() {
		handleAttributeAddSubBtn(intelligenceTxt, intelligenceAdd, intelligenceSub, Attributes.INTELLIGENCE, false /*isAddition*/);
	}

	@FXML
	private void handleAddWis() {
		handleAttributeAddSubBtn(wisdomTxt, wisdomAdd, wisdomSub, Attributes.WISDOM, true /*isAddition*/);
	}

	@FXML
	private void handleSubWis() {
		handleAttributeAddSubBtn(wisdomTxt, wisdomAdd, wisdomSub, Attributes.WISDOM, false /*isAddition*/);
	}

	@FXML
	private void handleAddCha() {
		handleAttributeAddSubBtn(charismaTxt, charismaAdd, charismaSub, Attributes.CHARISMA, true /*isAddition*/);
	}

	@FXML
	private void handleSubCha() {
		handleAttributeAddSubBtn(charismaTxt, charismaAdd, charismaSub, Attributes.CHARISMA, false /*isAddition*/);
	}

	private HashSet<KeyValue<Integer, KeyValue<RadioButton, Label>>> setupSkillKeyValues() {
		return new HashSet<KeyValue<Integer, KeyValue<RadioButton, Label>>>(Arrays.asList(
			new KeyValue<Integer, KeyValue<RadioButton, Label>>(Skills.ACROBATICS.getSkillId(), new KeyValue<RadioButton, Label>(acrobaticsRadioButton, acrobaticsIncrease)),
			new KeyValue<Integer, KeyValue<RadioButton, Label>>(Skills.ANIMAL_HANDLING.getSkillId(), new KeyValue<RadioButton, Label>(animalHandlingRadioButton, animalHandlingIncrease)),
			new KeyValue<Integer, KeyValue<RadioButton, Label>>(Skills.ARCANA.getSkillId(), new KeyValue<RadioButton, Label>(arcanaRadioButton, arcanaIncrease)),
			new KeyValue<Integer, KeyValue<RadioButton, Label>>(Skills.ATHLETICS.getSkillId(), new KeyValue<RadioButton, Label>(athleticsRadioButton, athleticsIncrease)),
			new KeyValue<Integer, KeyValue<RadioButton, Label>>(Skills.DECEPTION.getSkillId(), new KeyValue<RadioButton, Label>(deceptionRadioButton, deceptionIncrease)),
			new KeyValue<Integer, KeyValue<RadioButton, Label>>(Skills.HISTORY.getSkillId(), new KeyValue<RadioButton, Label>(historyRadioButton, historyIncrease)),
			new KeyValue<Integer, KeyValue<RadioButton, Label>>(Skills.INSIGHT.getSkillId(), new KeyValue<RadioButton, Label>(insightRadioButton, insightIncrease)),
			new KeyValue<Integer, KeyValue<RadioButton, Label>>(Skills.INTIMIDATION.getSkillId(), new KeyValue<RadioButton, Label>(intimidationRadioButton, intimidationIncrease)),
			new KeyValue<Integer, KeyValue<RadioButton, Label>>(Skills.INVESTIGATION.getSkillId(), new KeyValue<RadioButton, Label>(investigationRadioButton, investigationIncrease)),
			new KeyValue<Integer, KeyValue<RadioButton, Label>>(Skills.MEDICINE.getSkillId(), new KeyValue<RadioButton, Label>(medicineRadioButton, medicineIncrease)),
			new KeyValue<Integer, KeyValue<RadioButton, Label>>(Skills.NATURE.getSkillId(), new KeyValue<RadioButton, Label>(natureRadioButton, natureIncrease)),
			new KeyValue<Integer, KeyValue<RadioButton, Label>>(Skills.PERCEPTION.getSkillId(), new KeyValue<RadioButton, Label>(perceptionRadioButton, perceptionIncrease)),
			new KeyValue<Integer, KeyValue<RadioButton, Label>>(Skills.PERFORMANCE.getSkillId(), new KeyValue<RadioButton, Label>(performanceRadioButton, performanceIncrease)),
			new KeyValue<Integer, KeyValue<RadioButton, Label>>(Skills.PERSUASION.getSkillId(), new KeyValue<RadioButton, Label>(persuasionRadioButton, persuasionIncrease)),
			new KeyValue<Integer, KeyValue<RadioButton, Label>>(Skills.RELIGION.getSkillId(), new KeyValue<RadioButton, Label>(religionRadioButton, religionIncrease)),
			new KeyValue<Integer, KeyValue<RadioButton, Label>>(Skills.SLEIGHT_OF_HAND.getSkillId(), new KeyValue<RadioButton, Label>(sleightOfHandRadioButton, sleightOfHandIncrease)),
			new KeyValue<Integer, KeyValue<RadioButton, Label>>(Skills.STEALTH.getSkillId(), new KeyValue<RadioButton, Label>(stealthRadioButton, stealthIncrease)),
			new KeyValue<Integer, KeyValue<RadioButton, Label>>(Skills.SURVIVAL.getSkillId(), new KeyValue<RadioButton, Label>(survivalRadioButton, survivalIncrease))));
	}
}
