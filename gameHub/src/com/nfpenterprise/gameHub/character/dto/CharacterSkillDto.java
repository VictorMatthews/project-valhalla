package com.nfpenterprise.gameHub.character.dto;

public class CharacterSkillDto {
	private Integer characterId;
	private String skillName;
	private String attributeName;
	private boolean proficient;
	
	public CharacterSkillDto(Integer characterId) {
		this.characterId = characterId;		
	}

	public Integer getCharacterId() {
		return characterId;
	}

	public String getSkillName() {
		return skillName;
	}

	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}

	public String getAttributeName() {
		return attributeName;
	}

	public void setAttributeName(String attributeName) {
		this.attributeName = attributeName;
	}

	public boolean isProficient() {
		return proficient;
	}

	public void setProficient(boolean proficient) {
		this.proficient = proficient;
	}
}
