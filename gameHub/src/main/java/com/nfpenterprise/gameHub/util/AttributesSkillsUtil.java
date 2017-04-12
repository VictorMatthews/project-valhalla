package com.nfpenterprise.gameHub.util;

import com.nfpenterprise.gameHub.constants.Attributes;

import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

public class AttributesSkillsUtil {
	private final static Integer PROF_BONUS = 2;
	
	private Label acrobaticsIncrease;
	private Label animalHandlingIncrease;
	private Label arcanaIncrease;
	private Label athleticsIncrease;
	private Label deceptionIncrease;
	private Label historyIncrease;
	private Label insightIncrease;
	private Label intimidationIncrease;
	private Label investigationIncrease;
	private Label medicineIncrease;
	private Label natureIncrease;
	private Label perceptionIncrease;
	private Label performanceIncrease;
	private Label persuasionIncrease;
	private Label religionIncrease;
	private Label sleightOfHandIncrease;
	private Label stealthIncrease;
	private Label survivalIncrease;
	
	private RadioButton acrobaticsRadioButton;
	private RadioButton animalHandlingRadioButton;
	private RadioButton arcanaRadioButton;
	private RadioButton athleticsRadioButton;
	private RadioButton deceptionRadioButton;
	private RadioButton historyRadioButton;
	private RadioButton insightRadioButton;
	private RadioButton intimidationRadioButton;
	private RadioButton investigationRadioButton;
	private RadioButton medicineRadioButton;
	private RadioButton natureRadioButton;
	private RadioButton perceptionRadioButton;
	private RadioButton performanceRadioButton;
	private RadioButton persuasionRadioButton;
	private RadioButton religionRadioButton;
	private RadioButton sleightOfHandRadioButton;
	private RadioButton stealthRadioButton;
	private RadioButton survivalRadioButton;

	private TextField strengthTxt;
	private TextField dexterityTxt;
	private TextField intelligenceTxt;
	private TextField wisdomTxt;
	private TextField charismaTxt;

	public AttributesSkillsUtil(Label acrobaticsIncrease, Label animalHandlingIncrease, Label arcanaIncrease, Label athleticsIncrease, Label deceptionIncrease, Label historyIncrease,
			 Label insightIncrease, Label intimidationIncrease, Label investigationIncrease, Label medicineIncrease, Label natureIncrease, Label perceptionIncrease, Label performanceIncrease,
			 Label persuasionIncrease, Label religionIncrease, Label sleightOfHandIncrease, Label stealthIncrease, Label survivalIncrease, RadioButton acrobaticsRadioButton, RadioButton animalHandlingRadioButton,
			 RadioButton arcanaRadioButton, RadioButton athleticsRadioButton, RadioButton deceptionRadioButton, RadioButton historyRadioButton, RadioButton insightRadioButton, RadioButton intimidationRadioButton,
			 RadioButton investigationRadioButton, RadioButton medicineRadioButton, RadioButton natureRadioButton, RadioButton perceptionRadioButton, RadioButton performanceRadioButton, RadioButton persuasionRadioButton,
			 RadioButton religionRadioButton, RadioButton sleightOfHandRadioButton, RadioButton stealthRadioButton, RadioButton survivalRadioButton, TextField strengthTxt, TextField dexterityTxt,
			 TextField intelligenceTxt, TextField wisdomTxt, TextField charismaTxt) {
		
		 this.acrobaticsIncrease = acrobaticsIncrease;
		 this.animalHandlingIncrease = animalHandlingIncrease;
		 this.arcanaIncrease = arcanaIncrease;
		 this.athleticsIncrease = athleticsIncrease;
		 this.deceptionIncrease = deceptionIncrease;
		 this.historyIncrease = historyIncrease;
		 this.insightIncrease = insightIncrease;
		 this.intimidationIncrease = intimidationIncrease;
		 this.investigationIncrease = investigationIncrease;
		 this.medicineIncrease = medicineIncrease;
		 this.natureIncrease = natureIncrease;
		 this.perceptionIncrease = perceptionIncrease;
		 this.performanceIncrease = performanceIncrease;
		 this.persuasionIncrease = persuasionIncrease;
		 this.religionIncrease = religionIncrease;
		 this.sleightOfHandIncrease = sleightOfHandIncrease;
		 this.stealthIncrease = stealthIncrease;
		 this.survivalIncrease = survivalIncrease;
		
		 this.acrobaticsRadioButton = acrobaticsRadioButton;
		 this.animalHandlingRadioButton = animalHandlingRadioButton;
		 this.arcanaRadioButton = arcanaRadioButton;
		 this.athleticsRadioButton = athleticsRadioButton;
		 this.deceptionRadioButton = deceptionRadioButton;
		 this.historyRadioButton = historyRadioButton;
		 this.insightRadioButton = insightRadioButton;
		 this.intimidationRadioButton = intimidationRadioButton;
		 this.investigationRadioButton = investigationRadioButton;
		 this.medicineRadioButton = medicineRadioButton;
		 this.natureRadioButton = natureRadioButton;
		 this.perceptionRadioButton = perceptionRadioButton;
		 this.performanceRadioButton = performanceRadioButton;
		 this.persuasionRadioButton = persuasionRadioButton;
		 this.religionRadioButton = religionRadioButton;
		 this.sleightOfHandRadioButton = sleightOfHandRadioButton;
		 this.stealthRadioButton = stealthRadioButton;
		 this.survivalRadioButton = survivalRadioButton;

		 this.strengthTxt = strengthTxt;
		 this.dexterityTxt = dexterityTxt;
		 this.intelligenceTxt = intelligenceTxt;
		 this.wisdomTxt = wisdomTxt;
		 this.charismaTxt = charismaTxt;
	}

	public void updateSkills(Attributes attribute) {
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
}
