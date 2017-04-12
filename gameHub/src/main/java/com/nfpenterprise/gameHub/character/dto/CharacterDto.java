package com.nfpenterprise.gameHub.character.dto;

import java.util.HashSet;
import java.util.Set;

import javax.xml.bind.annotation.XmlElement;

import com.nfpenterprise.gameHub.constants.Backgrounds;
import com.nfpenterprise.gameHub.constants.Bonds;
import com.nfpenterprise.gameHub.constants.Classes;
import com.nfpenterprise.gameHub.constants.Flaws;
import com.nfpenterprise.gameHub.constants.Ideals;
import com.nfpenterprise.gameHub.constants.PersonalityTraits;
import com.nfpenterprise.gameHub.constants.Races;
import com.nfpenterprise.gameHub.constants.SubRaces;


public class CharacterDto {

	private String characterName;
	private String background;
	private String race;
	private String subRace;
	private String className;

	private Integer strength;
	private Integer dexterity;
	private Integer constitution;
	private Integer intelligence;
	private Integer wisdom;
	private Integer charisma;

	private String personalityTrait;
	private String ideals;
	private String bonds;
	private String flaws;

	private Set<Integer> profSkills;
	private Set<AttributeDto> increaseAttributes;


	public CharacterDto() {
	}

    @XmlElement(name = "characterName")
	public String getCharacterName() {
		return characterName;
	}

	public void setCharacterName(String characterName) {
		this.characterName = characterName;
	}

    @XmlElement(name = "background")
	public String getBackground() {
		return background;
	}

	public void setBackground(Backgrounds background) {
		if (background != null) {
			this.background =  background.getBackgroundName();
			addProfSkills(background.getProfSkills());
		}
	}

    @XmlElement(name = "race")
	public String getRace() {
		return race;
	}

	public void setRace(Races race) {
		if (race != null) {
			this.race = race.getRaceName();
			addIncreaseAttributes(race.getIncreaseAttribute());
		}
	}

    @XmlElement(name = "subRace")
	public String getSubRace() {
		return subRace;
	}

	public void setSubRace(SubRaces subRace) {
		if (subRace != null) {
			this.subRace = subRace.getSubRaceName();
			addIncreaseAttributes(subRace.getIncreaseAttribute());
		}
	}

    @XmlElement(name = "class")
	public String getClassName() {
		return className;
	}

	public void setClassName(Classes classData) {
		if (classData != null) {
			this.className = classData.getClassName();
		}
	}

    @XmlElement(name = "strength")
	public Integer getStrength() {
		return strength;
	}

	public void setStrength(Integer strength) {
		this.strength = strength;
	}

    @XmlElement(name = "dexterity")
	public Integer getDexterity() {
		return dexterity;
	}

	public void setDexterity(Integer dexterity) {
		this.dexterity = dexterity;
	}

    @XmlElement(name = "constitution")
	public Integer getConstitution() {
		return constitution;
	}

	public void setConstitution(Integer constitution) {
		this.constitution = constitution;
	}

    @XmlElement(name = "intelligence")
	public Integer getIntelligence() {
		return intelligence;
	}

	public void setIntelligence(Integer intelligence) {
		this.intelligence = intelligence;
	}

    @XmlElement(name = "wisdom")
	public Integer getWisdom() {
		return wisdom;
	}

	public void setWisdom(Integer wisdom) {
		this.wisdom = wisdom;
	}

    @XmlElement(name = "charisma")
	public Integer getCharisma() {
		return charisma;
	}

	public void setCharisma(Integer charisma) {
		this.charisma = charisma;
	}

    @XmlElement(name = "personalityTrait")
	public String getPersonalityTrait() {
		return personalityTrait;
	}

	public void setPersonalityTrait(PersonalityTraits personalityTrait) {
		this.personalityTrait = personalityTrait != null ? personalityTrait.getPersonalityTraitText() : null;
	}

    @XmlElement(name = "ideals")
	public String getIdeals() {
		return ideals;
	}

	public void setIdeals(Ideals ideals) {
		this.ideals = ideals != null ? ideals.getIdealText() : null;
	}

    @XmlElement(name = "bonds")
	public String getBonds() {
		return bonds;
	}

	public void setBonds(Bonds bonds) {
		this.bonds = bonds != null ? bonds.getBondText() : null;
	}

    @XmlElement(name = "flaws")
	public String getFlaws() {
		return flaws;
	}

	public void setFlaws(Flaws flaws) {
		this.flaws = flaws != null ? flaws.getFlawText() : null;
	}

    @XmlElement(name = "profSkills")
	public Set<Integer> getProfSkills() {
		return profSkills;
	}

	private void setProfSkills(Set<Integer> profSkills) {
		this.profSkills = profSkills;
	}

	public void addProfSkill(Integer profSkillId) {
		if (profSkills == null) {
			setProfSkills(new HashSet<Integer>());
		}
		profSkills.add(profSkillId);
	}

	private void addProfSkills(Set<Integer> profSkillIds) {
		for (Integer profSkillId : profSkillIds) {
			addProfSkill(profSkillId);
		}
	}

	public Set<AttributeDto> getIncreaseAttributes() {
		return increaseAttributes;
	}

	private void setIncreaseAttributes(Set<AttributeDto> increaseAttributes) {
		this.increaseAttributes = increaseAttributes;
	}

	private void addIncreaseAttributes(Set<AttributeDto> increaseAttributes) {
		if (increaseAttributes == null || this.increaseAttributes == null) {
			setIncreaseAttributes(new HashSet<AttributeDto>());
		}
		for (AttributeDto attribute : increaseAttributes) {
			this.increaseAttributes.add(attribute);
		}
	}

	public void resetSetLists() {
		setProfSkills(new HashSet<Integer>());
		setIncreaseAttributes(new HashSet<AttributeDto>());
	}
}
