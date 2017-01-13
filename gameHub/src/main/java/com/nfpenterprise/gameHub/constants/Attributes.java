package com.nfpenterprise.gameHub.constants;

public enum Attributes {
	
	STRENGTH 		(1, "Strength"),
	DEXTERITY 		(2, "Dexterity"),
	CONSTITUTION 	(3, "Constitution"),
	INTELLIGENCE 	(4, "Intelligence"),
	WISDOM 			(5, "Wisdom"),
	CHARISMA 		(6, "Charisma");

	private final Integer attributeId;
	private final String attributeName;

	private static final Integer DEFAULT_VALUE = 8;

	Attributes(Integer attributeId, String attributeName) {
		this.attributeId = attributeId;
		this.attributeName = attributeName;
	}

	public Integer getAttributeId() {
		return attributeId;
	}

	public String getAttributeName() {
		return attributeName;
	}

	public static Integer getDefaultValue() {
		return DEFAULT_VALUE;
	}
}
