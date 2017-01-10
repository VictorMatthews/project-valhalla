package com.nfpenterprise.gameHub.constants;

public enum Races {
	//@formatter:off
	
	DWARF		(1, 	"Dwarf",		25), 
	ELF			(2, 	"Elf",			30), 
	HALFLING	(3, 	"Halfling",		25), 
	HUMAN		(4, 	"Human",		30), 
	DRAGONBORN	(5, 	"Dragonbord",   30), 
	GNOME		(6, 	"Gnome",		25), 
	HALF_ELF	(7, 	"Half-Elf",		30), 
	HALF_ORC	(8, 	"Half-Orc",		30), 
	TIEFLING	(9, 	"Tiefling",		30);
	
	//@formatter:on

	private final Integer raceId;
	private final String raceName;
	private final Integer raceSpeed;

	Races(Integer raceId, String raceName, Integer raceSpeed) {
		this.raceId = raceId;
		this.raceName = raceName;
		this.raceSpeed = raceSpeed;
	}

	public String getRaceName() {
		return raceName;
	}

	public Integer getRaceId() {
		return raceId;
	}

	public Integer getRaceSpeed() {
		return raceSpeed;
	}
}
