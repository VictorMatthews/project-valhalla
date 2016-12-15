package com.nfpenterprise.gameHub.character.dto;

public class CharacterStatDto {
	private Integer characterId;
	private Integer characterLevel;
	private Integer characterHitPoints;
	private Integer characterExperience;
	
	public CharacterStatDto(Integer characterId) {
		this.characterId = characterId;
	}

	public Integer getCharacterId() {
		return characterId;
	}

	public Integer getCharacterLevel() {
		return characterLevel;
	}

	public void setCharacterLevel(Integer characterLevel) {
		this.characterLevel = characterLevel;
	}

	public Integer getCharacterHitPoints() {
		return characterHitPoints;
	}

	public void setCharacterHitPoints(Integer characterHitPoints) {
		this.characterHitPoints = characterHitPoints;
	}

	public Integer getCharacterExperience() {
		return characterExperience;
	}

	public void setCharacterExperience(Integer characterExperience) {
		this.characterExperience = characterExperience;
	}
}
