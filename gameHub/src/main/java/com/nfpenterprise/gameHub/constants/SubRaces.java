package com.nfpenterprise.gameHub.constants;

public enum SubRaces {
	//@formatter:off
	
	HILL_DWARF				(Races.DWARF.getRaceId(), 	"Hill Dwarf"), 
	MOUNTAIN_DWARF			(Races.DWARF.getRaceId(), 	"Mountain Dwarf"),
	HIGH_ELF				(Races.ELF.getRaceId(), 	"High Elf"),
	WOOD_ELF				(Races.ELF.getRaceId(), 	"Wood Elf"),
	DARK_ELF				(Races.ELF.getRaceId(), 	"Dark Elf (Drow)"),
	LIGHT_FOOT_HALFLING		(Races.HALFLING.getRaceId(), 	"Lightfoot Halfling"),
	STOUT_HALFLING			(Races.HALFLING.getRaceId(), 	"Stout Halfling"),
	ROCK_GNOME				(Races.GNOME.getRaceId(),	"Rock Gnome"),
	FOREST_GNOME			(Races.GNOME.getRaceId(),	"Forest Gnome")
	;
	
	//@formatter:on

	private final Integer raceId;
	private final String raceName;

	SubRaces(Integer raceId, String raceName) {
		this.raceId = raceId;
		this.raceName = raceName;
	}

	public String getSubRaceName() {
		return raceName;
	}

	public Integer getRaceId() {
		return raceId;
	}

}
