package com.nfpenterprise.gameHub.character.dto;

public class CharacterAttributeDto {
	private Integer characterId;
	private String attributeName;
	private Integer attributeValue;
	
	public CharacterAttributeDto(Integer characterId) {
		this.characterId = characterId;
	}

	public Integer getCharacterId() {
		return characterId;
	}

	public String getAttributeName() {
		return attributeName;
	}

	public void setAttributeName(String attributeName) {
		this.attributeName = attributeName;
	}

	public Integer getAttributeValue() {
		return attributeValue;
	}

	public void setAttributeValue(Integer attributeValue) {
		this.attributeValue = attributeValue;
	}
}
