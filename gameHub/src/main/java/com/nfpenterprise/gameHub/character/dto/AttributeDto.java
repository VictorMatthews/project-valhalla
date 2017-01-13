package com.nfpenterprise.gameHub.character.dto;

import com.nfpenterprise.gameHub.util.KeyValue;

public class AttributeDto {
	KeyValue<Integer, Integer> increasedAttribute;

	public AttributeDto(Integer attributeId, Integer increaseBy) {
		this.increasedAttribute = new KeyValue<Integer, Integer>(attributeId, increaseBy);
	}

	public Integer getAttributeId() {
		return increasedAttribute.getKey();
	}

	public Integer getIncreasedValue() {
		return increasedAttribute.getValue();
	}
}
