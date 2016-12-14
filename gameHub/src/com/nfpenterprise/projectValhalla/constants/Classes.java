package com.nfpenterprise.projectValhalla.constants;

public enum Classes {
	//@formatter:off
	
	BARBARIAN("Barbarian"),
	BARD("Bard"),
	CLERIC("Cleric"),
	DRUID("Druid"),
	FIGHTER("Fighter"),
	MONK("Monk"),
	PALADIN("Paladin"),
	RANGER("Ranger"),
	ROGUE("Rogue"),
	SORCERER("Sorcerer"),
	WARLOCK("Warlock"),
	WIZARD("Wizard");

	//@formatter:on

	private final String className;

	Classes(String className) {
		this.className = className;
	}

	public String getClassName() {
		return className;
	}

}
