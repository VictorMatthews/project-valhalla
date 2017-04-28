package com.nfpenterprise.gameHub.view.newCharacter;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.nfpenterprise.gameHub.character.dto.CharacterDtoFixture;
import com.nfpenterprise.gameHub.constants.Backgrounds;
import com.nfpenterprise.gameHub.constants.Bonds;
import com.nfpenterprise.gameHub.constants.Classes;
import com.nfpenterprise.gameHub.constants.Flaws;
import com.nfpenterprise.gameHub.constants.Ideals;
import com.nfpenterprise.gameHub.constants.PersonalityTraits;
import com.nfpenterprise.gameHub.constants.Races;
import com.nfpenterprise.gameHub.constants.SubRaces;
import com.nfpenterprise.gameHub.testUtil.JfxTestRunner;

import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

@RunWith( JfxTestRunner.class )
public class NewCharacterControllerTest {
    private NewCharacterController controller;

    @Before
    public void onSetUpInTransaction() {
    	controller = new NewCharacterController();

    	controller.tabs = new TabPane();
    	controller.raceTab = new Tab();
    	controller.subRaceTab = new Tab();
    	controller.classTab = new Tab();
    	controller.backgorundTab = new Tab();
    	controller.attributesSkillsTab = new Tab();
    	controller.tabs.getTabs().addAll(controller.raceTab, controller.subRaceTab, controller.classTab, controller.backgorundTab, controller.attributesSkillsTab);

    	controller.racesTable = new TableView<Races>();
        controller.racesColumn = new TableColumn<Races, String>();
    	controller.subRacesTable = new TableView<SubRaces>();
        controller.subRacesColumn = new TableColumn<SubRaces, String>();
    	controller.classesTable = new TableView<Classes>();
        controller.classesColumn = new TableColumn<Classes, String>();
    	controller.cmbBackground = new ComboBox<Backgrounds>();
    	controller.cmbPersonalityTraits = new ComboBox<PersonalityTraits>();
    	controller.cmbIdeals = new ComboBox<Ideals>();
    	controller.cmbBonds = new ComboBox<Bonds>();
    	controller.cmbFlaws = new ComboBox<Flaws>();
    	
    	controller.acrobaticsIncrease = new Label();
    	controller.animalHandlingIncrease = new Label();
    	controller.arcanaIncrease = new Label();
    	controller.athleticsIncrease = new Label();
    	controller.deceptionIncrease = new Label();
    	controller.historyIncrease = new Label();
    	controller.insightIncrease = new Label();
    	controller.intimidationIncrease = new Label();
    	controller.investigationIncrease = new Label();
    	controller.medicineIncrease = new Label();
    	controller.natureIncrease = new Label();
    	controller.perceptionIncrease = new Label();
    	controller.performanceIncrease = new Label();
    	controller.persuasionIncrease = new Label();
    	controller.religionIncrease = new Label();
    	controller.sleightOfHandIncrease = new Label();
    	controller.stealthIncrease = new Label();
    	controller.survivalIncrease = new Label();
    	
    	controller.acrobaticsRadioButton = new RadioButton();
    	controller.animalHandlingRadioButton = new RadioButton();
    	controller.arcanaRadioButton = new RadioButton();
    	controller.athleticsRadioButton = new RadioButton();
    	controller.deceptionRadioButton = new RadioButton();
    	controller.historyRadioButton = new RadioButton();
    	controller.insightRadioButton = new RadioButton();
    	controller.intimidationRadioButton = new RadioButton();
    	controller.investigationRadioButton = new RadioButton();
    	controller.medicineRadioButton = new RadioButton();
    	controller.natureRadioButton = new RadioButton();
    	controller.perceptionRadioButton = new RadioButton();
    	controller.performanceRadioButton = new RadioButton();
    	controller.persuasionRadioButton = new RadioButton();
    	controller.religionRadioButton = new RadioButton();
    	controller.sleightOfHandRadioButton = new RadioButton();
    	controller.stealthRadioButton = new RadioButton();
    	controller.survivalRadioButton = new RadioButton();
    	
    	controller.strengthAdd= new Button();
    	controller.strengthSub= new Button();
    	controller.dexterityAdd= new Button();
    	controller.dexteritySub= new Button();
    	controller.constitutionAdd= new Button();
    	controller.constitutionSub= new Button();
    	controller.intelligenceAdd= new Button();
    	controller.intelligenceSub= new Button();
    	controller.wisdomAdd= new Button();
    	controller.wisdomSub= new Button();
    	controller.charismaAdd= new Button();
    	controller.charismaSub= new Button();

    	controller.strengthTxt= new TextField();
    	controller.dexterityTxt= new TextField();
    	controller.constitutionTxt= new TextField();
    	controller.intelligenceTxt= new TextField();
    	controller.wisdomTxt= new TextField();
    	controller.charismaTxt= new TextField();

    	controller.remainingAttributeIncrease = new Label();
    	controller.remainingSkillChoices = new Label();
    	
    	controller.initialize();
    }
	
    /**
     * <pre>
     * @requirement QC-A
     *
     * Feature: Subraces populate off of selected race
     * 
     * Given the user is on the races tab
     * When they select a new race
     * Then the subraces table will populate with the sub races of the new race
     *
     * </pre>
     */
    @Test
    public void test_SubRaceTablePopulation() {
    	Races oldRace = controller.racesTable.getSelectionModel().getSelectedItem();
    	Integer currentSelectedRace = controller.racesTable.getSelectionModel().getSelectedIndex();
    	controller.racesTable.getSelectionModel().select(Math.addExact(currentSelectedRace, 1));
    	Races newRace = controller.racesTable.getSelectionModel().getSelectedItem();
    	
    	controller.subRacesTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    	controller.subRacesTable.getSelectionModel().selectAll();
    	ObservableList<SubRaces> subRacesInSubRaceTable = controller.subRacesTable.getSelectionModel().getSelectedItems();
    	
    	Assert.assertNotEquals(oldRace, newRace);
    	Assert.assertEquals(controller.dataController.populateSubRaceData(newRace), subRacesInSubRaceTable);
    }
	
    /**
     * <pre>
     * @requirement QC-B
     *
     * Feature: User Clicks Next and Back button to move through tabs
     * 
     * Given the user is on the race tab
     * When they click next
     * Then they will be on the subrace tab
     * When they click back
     * Then they will be on the race tab again
     *
     * </pre>
     */
    @Test
    public void test_NextBackButtons() {
    	controller.tabSelectionModel.select(controller.raceTab);
    	Assert.assertEquals(controller.raceTab, controller.tabSelectionModel.getSelectedItem());
    	controller.handleNext();
    	Assert.assertEquals(controller.subRaceTab, controller.tabSelectionModel.getSelectedItem());
    	controller.handleBack();
    	Assert.assertEquals(controller.raceTab, controller.tabSelectionModel.getSelectedItem());
    }
	
    /**
     * <pre>
     * @requirement QC-C
     *
     * Feature: User can add or remove attributes points
     * 
     * Given a strength of 8 
	 * And the subtract button disabled 
	 * And the add button enabled
     * When the user clicks the add button
     * Then the strength will increase to 9 and the subtract button will enable
     * When the user clicks the subtract button
     * Then the strength will decrease to 8 and the subtract button will be disabled again
     * 
     * Given a strength of 14
     * And both buttons enabled
     * When the user clicks the add button
     * Then the strength will increase to 15 and the add button will be disabled
     * When the user clicks the subtract button
     * Then the strength will decrease to 14 and the add button will be enabled again
     *
     * </pre>
     */
    @Test
    public void test_AddSubAttributes() {
    	controller.newCharacter = CharacterDtoFixture.createCharacterDto();
    	controller.handleAttributes();
    	Integer fourteen = 14;

    	controller.handleAddStr();
    	Assert.assertEquals(false, controller.strengthSub.isDisable());
    	Assert.assertEquals(9, Integer.parseInt(controller.strengthTxt.getText()));

    	controller.handleSubStr();
    	Assert.assertEquals(true, controller.strengthSub.isDisable());
    	Assert.assertEquals(8, Integer.parseInt(controller.strengthTxt.getText()));

    	controller.strengthTxt.setText(fourteen.toString());
    	controller.strengthSub.setDisable(false);
    	controller.strengthAdd.setDisable(false);

    	controller.handleAddStr();
    	Assert.assertEquals(true, controller.strengthAdd.isDisable());
    	Assert.assertEquals(15, Integer.parseInt(controller.strengthTxt.getText()));

    	controller.handleSubStr();
    	Assert.assertEquals(false, controller.strengthAdd.isDisable());
    	Assert.assertEquals(14, Integer.parseInt(controller.strengthTxt.getText()));
    }
	
    /**
     * <pre>
     * @requirement QC-D
     *
     * Feature: The user can select select skills
     * 
     * Given the user is on the attributeSkillsTab
     * When the users selects a skill
     * Then the remaining skill points goes down
     *
     * </pre>
     */
    @Test
    public void test_SkillSelection() {
    	controller.newCharacter = CharacterDtoFixture.createCharacterDto();
    	controller.tabSelectionModel.select(controller.attributesSkillsTab);
    	controller.handleAttributes();
    	controller.handleAttributesAndSkills();
    	String currentRemainingSkills = controller.remainingSkillChoices.getText();
    	
    	controller.handleSkillAcrobatics();
    	Assert.assertNotEquals(currentRemainingSkills, controller.remainingSkillChoices.getText());
    }
	
    /**
     * <pre>
     * @requirement QC-E
     *
     * Feature: User can select characters background and traits that go along with it.
     * 
     * Given the user is on the background tab
     * When the user selects a background in the background combo box
     * Then all the combo boxes below it populate with the correct background data
     *
     * </pre>
     */
    @Test
    public void test_Background() {
    	controller.newCharacter = CharacterDtoFixture.createCharacterDto();
    	controller.tabSelectionModel.select(controller.backgorundTab);

    	for (Backgrounds selectedBackground : Backgrounds.getBackgrounds()) {
	    	controller.cmbBackground.getSelectionModel().select(selectedBackground);
	    	controller.refreshBackground();
	
	    	ObservableList<PersonalityTraits> expectedPersonalityTraits = controller.dataController.populatePersonalityTraitData(controller.cmbBackground.getSelectionModel().getSelectedItem());
	    	ObservableList<Bonds> expectedBonds = controller.dataController.populateBondData(controller.cmbBackground.getSelectionModel().getSelectedItem());
	    	ObservableList<Ideals> expectedIdeals = controller.dataController.populateIdealData(controller.cmbBackground.getSelectionModel().getSelectedItem());
	    	ObservableList<Flaws> expectedFlaws = controller.dataController.populateFlawData(controller.cmbBackground.getSelectionModel().getSelectedItem());
	
	    	Assert.assertEquals(expectedPersonalityTraits, controller.cmbPersonalityTraits.getItems());
	    	Assert.assertEquals(expectedBonds, controller.cmbBonds.getItems());
	    	Assert.assertEquals(expectedIdeals, controller.cmbIdeals.getItems());
	    	Assert.assertEquals(expectedFlaws, controller.cmbFlaws.getItems());
    	}
    }
}
