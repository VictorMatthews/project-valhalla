package com.nfpenterprise.projectValhalla.constants;

public enum Races {
	//@formatter:off
	
	DWARF("Dwarf"), 
	ELF("Elf"), 
	HALFLING("Halfling"), 
	HUMAN("Human"), 
	DRAGONBORN("Dragonbord"), 
	GNOME("Gnome"), 
	HALF_ELF("Half-Elf"), 
	HALF_ORC("Half-Orc"), 
	TIEFLING("Tiefling");
	
	//@formatter:on

	private final String race;

	Races(String race) {
		this.race = race;
	}

	public String getRace() {
		return race;
	}
}
