package com.nfpenterprise.gameHub.character.dto;

public class CharacterDto {
	private Integer characterId;
	private String characterName;
	private Integer alignmentId;
	private Integer raceId;
	private Integer subRaceId;
	private Integer classId;
	private Integer archetypeId;
	private Integer backgroundId;
	
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

	public Integer getAlignmentId() {
		return alignmentId;
	}

	public void setAlignmentId(Integer alignmentId) {
		this.alignmentId = alignmentId;
	}

	public Integer getRaceId() {
		return raceId;
	}

	public void setRaceId(Integer raceId) {
		this.raceId = raceId;
	}

	public Integer getSubRaceId() {
		return subRaceId;
	}

	public void setSubRaceId(Integer subRaceId) {
		this.subRaceId = subRaceId;
	}

	public Integer getClassId() {
		return classId;
	}

	public void setClassId(Integer classId) {
		this.classId = classId;
	}

	public Integer getArchetypeId() {
		return archetypeId;
	}

	public void setArchetypeId(Integer archetypeId) {
		this.archetypeId = archetypeId;
	}

	public Integer getBackgroundId() {
		return backgroundId;
	}

	public void setBackgroundId(Integer backgroundId) {
		this.backgroundId = backgroundId;
	}
}
