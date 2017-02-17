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

	private Integer characterId;
	private String characterName;
	private String alignment;
	private String background;
	private String race;
	private String subRace;
	private String className;
	private Integer classLevel;
	private Integer experience;
	private Integer speed;
	private Integer hitPoints;

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
	private Set<Integer> savingThrows;


	public CharacterDto() {
	}

	public Integer getCharacterId() {
		return characterId;
	}

	public void setCharacterId(Integer characterId) {
		this.characterId = characterId;
	}

	public String getCharacterName() {
		return characterName;
	}

	public void setCharacterName(String characterName) {
		this.characterName = characterName;
	}

	public String getAlignment() {
		return alignment;
	}

	public void setAlignment(String alignmentId) {
		this.alignment = alignmentId;
	}

	public String getBackground() {
		return background;
	}

	public void setBackground(Backgrounds background) {
		if (background != null) {
			this.background =  background.getBackgroundName();
			addProfSkills(background.getProfSkills());
		}
	}

	public String getRace() {
		return race;
	}

	public void setRace(Races race) {
		if (race != null) {
			this.race = race.getRaceName();
			setSpeed(race.getRaceSpeed());
			addIncreaseAttributes(race.getIncreaseAttribute());
		}
	}

	public String getSubRace() {
		return subRace;
	}

	public void setSubRace(SubRaces subRace) {
		if (subRace != null) {
			this.subRace = subRace.getSubRaceName();
			addIncreaseAttributes(subRace.getIncreaseAttribute());
		}
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(Classes classData) {
		if (classData != null) {
			this.className = classData.getClassName();
			this.setSavingThrows(classData.getSavingThrows());
		}
	}

	public Integer getClassLevel() {
		return classLevel;
	}

	public void setClassLevel(Integer classLevel) {
		this.classLevel = classLevel;
	}

	public Integer getExperience() {
		return experience;
	}

	public void setExperience(Integer experience) {
		this.experience = experience;
	}

	public Integer getStrength() {
		return strength;
	}

	public void setStrength(Integer strength) {
		this.strength = strength;
	}

	public Integer getDexterity() {
		return dexterity;
	}

	public void setDexterity(Integer dexterity) {
		this.dexterity = dexterity;
	}

	public Integer getConstitution() {
		return constitution;
	}

	public void setConstitution(Integer constitution) {
		this.constitution = constitution;
	}

	public Integer getIntelligence() {
		return intelligence;
	}

	public void setIntelligence(Integer intelligence) {
		this.intelligence = intelligence;
	}

	public Integer getWisdom() {
		return wisdom;
	}

	public void setWisdom(Integer wisdom) {
		this.wisdom = wisdom;
	}

	public Integer getCharisma() {
		return charisma;
	}

	public void setCharisma(Integer charisma) {
		this.charisma = charisma;
	}

	public String getPersonalityTrait() {
		return personalityTrait;
	}

	public void setPersonalityTrait(PersonalityTraits personalityTrait) {
		this.personalityTrait = personalityTrait != null ? personalityTrait.getPersonalityTraitText() : null;
	}

	public String getIdeals() {
		return ideals;
	}

	public void setIdeals(Ideals ideals) {
		this.ideals = ideals != null ? ideals.getIdealText() : null;
	}

	public String getBonds() {
		return bonds;
	}

	public void setBonds(Bonds bonds) {
		this.bonds = bonds != null ? bonds.getBondText() : null;
	}

	public String getFlaws() {
		return flaws;
	}

	public void setFlaws(Flaws flaws) {
		this.flaws = flaws != null ? flaws.getFlawText() : null;
	}

	public Integer getSpeed() {
		return speed;
	}

	private void setSpeed(Integer speed) {
		this.speed = speed;
	}

    @XmlElement(name = "profSkills")
	public Set<Integer> getProfSkills() {
		return profSkills;
	}

	private void setProfSkills(Set<Integer> profSkills) {
		this.profSkills = profSkills;
	}

	private void addProfSkill(Integer profSkillId) {
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

    @XmlElement(name = "savingThrows")
	public Set<Integer> getSavingThrows() {
		return savingThrows;
	}

	public void setSavingThrows(Set<Integer> savingThrows) {
		this.savingThrows = savingThrows;
	}
}
