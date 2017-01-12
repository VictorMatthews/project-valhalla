package com.nfpenterprise.gameHub.character.dto;

import java.util.HashSet;
import java.util.Set;

import javax.xml.bind.annotation.XmlElement;

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

	public void setBackground(String background) {
		this.background = background;
	}

	public String getRace() {
		return race;
	}

	public void setRace(String race) {
		this.race = race;
	}

	public String getSubRace() {
		return subRace;
	}

	public void setSubRace(String subRace) {
		this.subRace = subRace;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
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

	public void setPersonalityTrait(String personalityTrait) {
		this.personalityTrait = personalityTrait;
	}

	public String getIdeals() {
		return ideals;
	}

	public void setIdeals(String ideals) {
		this.ideals = ideals;
	}

	public String getBonds() {
		return bonds;
	}

	public void setBonds(String bonds) {
		this.bonds = bonds;
	}

	public String getFlaws() {
		return flaws;
	}

	public void setFlaws(String flaws) {
		this.flaws = flaws;
	}

	public Integer getSpeed() {
		return speed;
	}

	public void setSpeed(Integer speed) {
		this.speed = speed;
	}

    @XmlElement(name = "profSkills")
	public Set<Integer> getProfSkills() {
		return profSkills;
	}

	public void setProfSkills(Set<Integer> profSkills) {
		this.profSkills = profSkills;
	}

	public void addProfSkill(Integer profSkillId) {
		if (profSkills == null) {
			setProfSkills(new HashSet<Integer>());
		}
		profSkills.add(profSkillId);
	}

	public void addProfSkills(Set<Integer> profSkillIds) {
		for (Integer profSkillId : profSkillIds) {
			addProfSkill(profSkillId);
		}
	}
}
