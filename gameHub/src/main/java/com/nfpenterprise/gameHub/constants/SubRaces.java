package com.nfpenterprise.gameHub.constants;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public enum SubRaces {
	//@formatter:off
	
	HILL_DWARF				(Races.DWARF.getRaceId(), 		"Hill Dwarf", 			new HashSet<Integer>(Arrays.asList(Skills.ACROBATICS.getSkillId()))), 
	MOUNTAIN_DWARF			(Races.DWARF.getRaceId(), 		"Mountain Dwarf",		new HashSet<Integer>(Arrays.asList(Skills.ACROBATICS.getSkillId()))),
	HIGH_ELF				(Races.ELF.getRaceId(), 		"High Elf",				new HashSet<Integer>(Arrays.asList(Skills.ACROBATICS.getSkillId()))),
	WOOD_ELF				(Races.ELF.getRaceId(), 		"Wood Elf",				new HashSet<Integer>(Arrays.asList(Skills.ACROBATICS.getSkillId()))),
	DARK_ELF				(Races.ELF.getRaceId(), 		"Dark Elf (Drow)",		new HashSet<Integer>(Arrays.asList(Skills.ACROBATICS.getSkillId()))),
	LIGHT_FOOT_HALFLING		(Races.HALFLING.getRaceId(), 	"Lightfoot Halfling",	new HashSet<Integer>(Arrays.asList(Skills.ACROBATICS.getSkillId()))),
	STOUT_HALFLING			(Races.HALFLING.getRaceId(), 	"Stout Halfling",		new HashSet<Integer>(Arrays.asList(Skills.ACROBATICS.getSkillId()))),
	ROCK_GNOME				(Races.GNOME.getRaceId(),		"Rock Gnome",			new HashSet<Integer>(Arrays.asList(Skills.ACROBATICS.getSkillId()))),
	FOREST_GNOME			(Races.GNOME.getRaceId(),		"Forest Gnome",			new HashSet<Integer>(Arrays.asList(Skills.ACROBATICS.getSkillId()))),
	HUMAN					(Races.HUMAN.getRaceId(),		"Human",				new HashSet<Integer>(Arrays.asList(Skills.ACROBATICS.getSkillId()))),
	VARIANT_HUMAN			(Races.HUMAN.getRaceId(),		"Variant Human",		new HashSet<Integer>(Arrays.asList(Skills.ACROBATICS.getSkillId())));
	
	//@formatter:on

	private final Integer raceId;
	private final String subRaceName;
	private final Set<Integer> profSkills;

	SubRaces(Integer raceId, String raceName, Set<Integer> profSkills) {
		this.raceId = raceId;
		this.subRaceName = raceName;
		this.profSkills = profSkills;
	}

	public String getSubRaceName() {
		return subRaceName;
	}

	public Integer getRaceId() {
		return raceId;
	}

	public Set<Integer> getProfSkills() {
		return profSkills;
	}

	public static SubRaces[] getSubRaces() {
		return SubRaces.values();
	}

	@Override
	public String toString() {
		return this.subRaceName;
	}

}
