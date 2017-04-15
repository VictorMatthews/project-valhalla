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
    private MyCharactersController mcc;

    @Before
    public void onSetUpInTransaction() {
    	mcc = new MyCharactersController();
    	mcc.strengthTxt = new TextField();
    	mcc.dexterityTxt = new TextField();
    	mcc.constitutionTxt = new TextField();
    	mcc.intelligenceTxt = new TextField();
    	mcc.wisdomTxt = new TextField();
    	mcc.charismaTxt = new TextField();
    	mcc.raceTxt = new TextField();
    	mcc.classTxt = new TextField();
    	mcc.personalityTraitLabel = new Label();
    	mcc.idealLabel = new Label();
    	mcc.bondLabel = new Label();
    	mcc.flawLabel = new Label();
    	mcc.acrobaticsIncrease = new Label();
    	mcc.animalHandlingIncrease = new Label();
    	mcc.arcanaIncrease = new Label();
    	mcc.athleticsIncrease = new Label();
    	mcc.deceptionIncrease = new Label();
    	mcc.historyIncrease = new Label();
    	mcc.insightIncrease = new Label();
    	mcc.intimidationIncrease = new Label();
    	mcc.investigationIncrease = new Label();
    	mcc.medicineIncrease = new Label();
    	mcc.natureIncrease = new Label();
    	mcc.perceptionIncrease = new Label();
    	mcc.performanceIncrease = new Label();
    	mcc.persuasionIncrease = new Label();
    	mcc.religionIncrease = new Label();
    	mcc.sleightOfHandIncrease = new Label();
    	mcc.stealthIncrease = new Label();
    	mcc.survivalIncrease = new Label();
    	mcc.acrobaticsRadioButton = new RadioButton();
    	mcc.animalHandlingRadioButton = new RadioButton();
    	mcc.arcanaRadioButton = new RadioButton();
    	mcc.athleticsRadioButton = new RadioButton();
    	mcc.deceptionRadioButton = new RadioButton();
    	mcc.historyRadioButton = new RadioButton();
    	mcc.insightRadioButton = new RadioButton();
    	mcc.intimidationRadioButton = new RadioButton();
    	mcc.investigationRadioButton = new RadioButton();
    	mcc.medicineRadioButton = new RadioButton();
    	mcc.natureRadioButton = new RadioButton();
    	mcc.perceptionRadioButton = new RadioButton();
    	mcc.performanceRadioButton = new RadioButton();
    	mcc.persuasionRadioButton = new RadioButton();
    	mcc.religionRadioButton = new RadioButton();
    	mcc.sleightOfHandRadioButton = new RadioButton();
    	mcc.stealthRadioButton = new RadioButton();
    	mcc.survivalRadioButton = new RadioButton();

    	mcc.attributesSkillsUtil = new AttributesSkillsUtil(mcc.acrobaticsIncrease, mcc.animalHandlingIncrease, mcc.arcanaIncrease,
    			mcc.athleticsIncrease, mcc.deceptionIncrease, mcc.historyIncrease, mcc.insightIncrease, mcc.intimidationIncrease,
    			mcc.investigationIncrease, mcc.medicineIncrease, mcc.natureIncrease, mcc.perceptionIncrease, mcc.performanceIncrease,
    			mcc.persuasionIncrease, mcc.religionIncrease, mcc.sleightOfHandIncrease, mcc.stealthIncrease, mcc.survivalIncrease,
    			mcc.acrobaticsRadioButton, mcc.animalHandlingRadioButton, mcc.arcanaRadioButton, mcc.athleticsRadioButton,
    			mcc.deceptionRadioButton, mcc.historyRadioButton, mcc.insightRadioButton, mcc.intimidationRadioButton,
    			mcc.investigationRadioButton, mcc.medicineRadioButton, mcc.natureRadioButton, mcc.perceptionRadioButton,
    			mcc.performanceRadioButton, mcc.persuasionRadioButton, mcc.religionRadioButton, mcc.sleightOfHandRadioButton,
				mcc.stealthRadioButton, mcc.survivalRadioButton, mcc.strengthTxt, mcc.dexterityTxt, mcc.intelligenceTxt, mcc.wisdomTxt,
				mcc.charismaTxt, null);
    }
	
    /**
     * <pre>
     * @requirement PVQC-A
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
    	String characterName = "Aifur Gott";
    	CharacterDto character = CharacterDtoFixture.createCharacterDto(characterName);

    	mcc.showCharacterDetails(character);

    	Assert.assertEquals(character.getSubRace(), mcc.raceTxt.getText());
    	Assert.assertEquals(character.getClassName(), mcc.classTxt.getText());
    	Assert.assertEquals(character.getStrength().toString(), mcc.strengthTxt.getText());
    	Assert.assertEquals(character.getDexterity().toString(), mcc.dexterityTxt.getText());
    	Assert.assertEquals(character.getConstitution().toString(), mcc.constitutionTxt.getText());
    	Assert.assertEquals(character.getIntelligence().toString(), mcc.intelligenceTxt.getText());
    	Assert.assertEquals(character.getWisdom().toString(), mcc.wisdomTxt.getText());
    	Assert.assertEquals(character.getCharisma().toString(), mcc.charismaTxt.getText());
    	Assert.assertEquals(character.getPersonalityTrait(), mcc.personalityTraitLabel.getText());
    	Assert.assertEquals(character.getIdeals(), mcc.idealLabel.getText());
    	Assert.assertEquals(character.getBonds(), mcc.bondLabel.getText());
    	Assert.assertEquals(character.getFlaws(), mcc.flawLabel.getText());
    }
}
