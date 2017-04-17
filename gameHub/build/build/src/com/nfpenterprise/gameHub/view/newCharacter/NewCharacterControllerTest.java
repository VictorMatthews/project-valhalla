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
//    	controller.raceWebView = new WebView();
//    	controller.subRaceWebView = new WebView();
//    	controller.classWebView = new WebView();
//    	controller.spellWebView = new WebView();
    	
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
     * @requirement QC-?
     *
     * Feature: 
     * 
     * Given
     * When
     * Then
     *
     * </pre>
     */
//    @Test
//    public void test_() {
//
//    }
}
