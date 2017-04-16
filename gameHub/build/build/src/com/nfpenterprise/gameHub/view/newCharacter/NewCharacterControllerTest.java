package com.nfpenterprise.gameHub.view.newCharacter;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

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
    private NewCharacterController ncc;

    @Before
    public void onSetUpInTransaction() {
    	ncc = new NewCharacterController();

    	ncc.tabs = new TabPane();
    	ncc.raceTab = new Tab();
    	ncc.subRaceTab = new Tab();
    	ncc.classTab = new Tab();
    	ncc.backgorundTab = new Tab();
    	ncc.attributesSkillsTab = new Tab();
    	ncc.racesTable = new TableView<Races>();
        ncc.racesColumn = new TableColumn<Races, String>();
    	ncc.subRacesTable = new TableView<SubRaces>();
        ncc.subRacesColumn = new TableColumn<SubRaces, String>();
    	ncc.classesTable = new TableView<Classes>();
        ncc.classesColumn = new TableColumn<Classes, String>();
    	ncc.cmbBackground = new ComboBox<Backgrounds>();
    	ncc.cmbPersonalityTraits = new ComboBox<PersonalityTraits>();
    	ncc.cmbIdeals = new ComboBox<Ideals>();
    	ncc.cmbBonds = new ComboBox<Bonds>();
    	ncc.cmbFlaws = new ComboBox<Flaws>();
//    	ncc.raceWebView = new WebView();
//    	ncc.subRaceWebView = new WebView();
//    	ncc.classWebView = new WebView();
//    	ncc.spellWebView = new WebView();
    	
    	ncc.acrobaticsIncrease = new Label();
    	ncc.animalHandlingIncrease = new Label();
    	ncc.arcanaIncrease = new Label();
    	ncc.athleticsIncrease = new Label();
    	ncc.deceptionIncrease = new Label();
    	ncc.historyIncrease = new Label();
    	ncc.insightIncrease = new Label();
    	ncc.intimidationIncrease = new Label();
    	ncc.investigationIncrease = new Label();
    	ncc.medicineIncrease = new Label();
    	ncc.natureIncrease = new Label();
    	ncc.perceptionIncrease = new Label();
    	ncc.performanceIncrease = new Label();
    	ncc.persuasionIncrease = new Label();
    	ncc.religionIncrease = new Label();
    	ncc.sleightOfHandIncrease = new Label();
    	ncc.stealthIncrease = new Label();
    	ncc.survivalIncrease = new Label();
    	
    	ncc.acrobaticsRadioButton = new RadioButton();
    	ncc.animalHandlingRadioButton = new RadioButton();
    	ncc.arcanaRadioButton = new RadioButton();
    	ncc.athleticsRadioButton = new RadioButton();
    	ncc.deceptionRadioButton = new RadioButton();
    	ncc.historyRadioButton = new RadioButton();
    	ncc.insightRadioButton = new RadioButton();
    	ncc.intimidationRadioButton = new RadioButton();
    	ncc.investigationRadioButton = new RadioButton();
    	ncc.medicineRadioButton = new RadioButton();
    	ncc.natureRadioButton = new RadioButton();
    	ncc.perceptionRadioButton = new RadioButton();
    	ncc.performanceRadioButton = new RadioButton();
    	ncc.persuasionRadioButton = new RadioButton();
    	ncc.religionRadioButton = new RadioButton();
    	ncc.sleightOfHandRadioButton = new RadioButton();
    	ncc.stealthRadioButton = new RadioButton();
    	ncc.survivalRadioButton = new RadioButton();
    	
    	ncc.strengthAdd= new Button();
    	ncc.strengthSub= new Button();
    	ncc.dexterityAdd= new Button();
    	ncc.dexteritySub= new Button();
    	ncc.constitutionAdd= new Button();
    	ncc.constitutionSub= new Button();
    	ncc.intelligenceAdd= new Button();
    	ncc.intelligenceSub= new Button();
    	ncc.wisdomAdd= new Button();
    	ncc.wisdomSub= new Button();
    	ncc.charismaAdd= new Button();
    	ncc.charismaSub= new Button();

    	ncc.strengthTxt= new TextField();
    	ncc.dexterityTxt= new TextField();
    	ncc.constitutionTxt= new TextField();
    	ncc.intelligenceTxt= new TextField();
    	ncc.wisdomTxt= new TextField();
    	ncc.charismaTxt= new TextField();

    	ncc.remainingAttributeIncrease = new Label();
    	ncc.remainingSkillChoices = new Label();
    	
    	ncc.initialize();
    }
	
    /**
     * <pre>
     * @requirement NCCQC-A
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
    	Races oldRace = ncc.racesTable.getSelectionModel().getSelectedItem();
    	Integer currentSelectedRace = ncc.racesTable.getSelectionModel().getSelectedIndex();
    	ncc.racesTable.getSelectionModel().select(Math.addExact(currentSelectedRace, 1));
    	Races newRace = ncc.racesTable.getSelectionModel().getSelectedItem();
    	
    	ncc.subRacesTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    	ncc.subRacesTable.getSelectionModel().selectAll();
    	ObservableList<SubRaces> subRacesInSubRaceTable = ncc.subRacesTable.getSelectionModel().getSelectedItems();
    	
    	Assert.assertNotEquals(oldRace, newRace);
    	Assert.assertEquals(ncc.dataController.populateSubRaceData(newRace), subRacesInSubRaceTable);
    }
	
    /**
     * <pre>
     * @requirement NCCQC-B
     *
     * Feature: The next and back button move the through the tabs
     * 
     * Given a user is at the races tab
     * When they click next
     * Then the selected tab will switch to sub races
     * 
     * When they click the back button
     * Then the selected tab will switch back to the race tab
     *
     * </pre>
     */
    @Test
    public void test_NextBackButtons() {
    	Tab currentTab = ncc.tabs.getSelectionModel().getSelectedItem();
    	Assert.assertEquals(ncc.raceTab, currentTab);

    	ncc.handleNext();

    	currentTab = ncc.tabSelectionModel.getSelectedItem();
    	Assert.assertEquals(ncc.subRaceTab, currentTab);

    	ncc.handleBack();

    	currentTab = ncc.tabSelectionModel.getSelectedItem();
    	Assert.assertEquals(ncc.raceTab, currentTab);
    }
	
    /**
     * <pre>
     * @requirement NCCQC-?
     *
     * Feature: 
     * 
     * Given
     * When
     * Then
     *
     * </pre>
     */
    @Test
    public void test_() {

    }
}
