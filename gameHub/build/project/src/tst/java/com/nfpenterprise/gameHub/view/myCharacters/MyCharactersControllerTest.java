package com.nfpenterprise.gameHub.view.myCharacters;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.nfpenterprise.gameHub.character.dto.CharacterDto;
import com.nfpenterprise.gameHub.character.dto.CharacterDtoFixture;
import com.nfpenterprise.gameHub.testUtil.JfxTestRunner;
import com.nfpenterprise.gameHub.util.AttributesSkillsUtil;

import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

@RunWith( JfxTestRunner.class )
public class MyCharactersControllerTest {
    private MyCharactersController controller;

    @Before
    public void onSetUpInTransaction() {
    	controller = new MyCharactersController();
    	controller.strengthTxt = new TextField();
    	controller.dexterityTxt = new TextField();
    	controller.constitutionTxt = new TextField();
    	controller.intelligenceTxt = new TextField();
    	controller.wisdomTxt = new TextField();
    	controller.charismaTxt = new TextField();
    	controller.raceTxt = new TextField();
    	controller.classTxt = new TextField();
    	controller.personalityTraitLabel = new Label();
    	controller.idealLabel = new Label();
    	controller.bondLabel = new Label();
    	controller.flawLabel = new Label();
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

    	controller.attributesSkillsUtil = new AttributesSkillsUtil(controller.acrobaticsIncrease, controller.animalHandlingIncrease, controller.arcanaIncrease,
    			controller.athleticsIncrease, controller.deceptionIncrease, controller.historyIncrease, controller.insightIncrease, controller.intimidationIncrease,
    			controller.investigationIncrease, controller.medicineIncrease, controller.natureIncrease, controller.perceptionIncrease, controller.performanceIncrease,
    			controller.persuasionIncrease, controller.religionIncrease, controller.sleightOfHandIncrease, controller.stealthIncrease, controller.survivalIncrease,
    			controller.acrobaticsRadioButton, controller.animalHandlingRadioButton, controller.arcanaRadioButton, controller.athleticsRadioButton,
    			controller.deceptionRadioButton, controller.historyRadioButton, controller.insightRadioButton, controller.intimidationRadioButton,
    			controller.investigationRadioButton, controller.medicineRadioButton, controller.natureRadioButton, controller.perceptionRadioButton,
    			controller.performanceRadioButton, controller.persuasionRadioButton, controller.religionRadioButton, controller.sleightOfHandRadioButton,
				controller.stealthRadioButton, controller.survivalRadioButton, controller.strengthTxt, controller.dexterityTxt, controller.intelligenceTxt, controller.wisdomTxt,
				controller.charismaTxt, null);
    }
	
    /**
     * <pre>
     * @requirement QC-A
     *
     * Feature: When a user selects a character the character info is updated on the screen.
     * 
     * Given a characterDto that is populated
     * When the characterDto is passed into showCharacterDetails
     * Then the fields on the screen will be populated
     *
     * </pre>
     */
    @Test
    public void test_showCharacterDetails() {
    	CharacterDto character = CharacterDtoFixture.createCharacterDto();

    	controller.showCharacterDetails(character);

    	Assert.assertEquals(character.getSubRace(), controller.raceTxt.getText());
    	Assert.assertEquals(character.getClassName(), controller.classTxt.getText());
    	Assert.assertEquals(character.getStrength().toString(), controller.strengthTxt.getText());
    	Assert.assertEquals(character.getDexterity().toString(), controller.dexterityTxt.getText());
    	Assert.assertEquals(character.getConstitution().toString(), controller.constitutionTxt.getText());
    	Assert.assertEquals(character.getIntelligence().toString(), controller.intelligenceTxt.getText());
    	Assert.assertEquals(character.getWisdom().toString(), controller.wisdomTxt.getText());
    	Assert.assertEquals(character.getCharisma().toString(), controller.charismaTxt.getText());
    	Assert.assertEquals(character.getPersonalityTrait(), controller.personalityTraitLabel.getText());
    	Assert.assertEquals(character.getIdeals(), controller.idealLabel.getText());
    	Assert.assertEquals(character.getBonds(), controller.bondLabel.getText());
    	Assert.assertEquals(character.getFlaws(), controller.flawLabel.getText());
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
