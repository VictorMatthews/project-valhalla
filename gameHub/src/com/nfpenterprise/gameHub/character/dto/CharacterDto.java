package com.nfpenterprise.gameHub.character.dto;

public class CharacterDto {
	private Integer characterId;

	private String characterName;
	private String alignment;
	private String background;
	private String race;
	private String className;
	private Integer classLevel;
	private Integer experience;

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

	private Integer newCharacterId() {
		// TODO Auto-generated method stub
		return null;
	}

	public CharacterDto() {
		new CharacterDto(newCharacterId());
	}

	public CharacterDto(Integer characterId) {
		this.characterId = characterId;
	}

	public Integer getCharacterId() {
		return characterId;
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
}
