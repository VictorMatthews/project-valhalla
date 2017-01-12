package com.nfpenterprise.gameHub.constants;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public enum Races {
	//@formatter:off
	
	DWARF		(1, 	"Dwarf",		25, new HashSet<Integer>(Arrays.asList(Skills.ACROBATICS.getSkillId()))), 
	ELF			(2, 	"Elf",			30, new HashSet<Integer>(Arrays.asList(Skills.ACROBATICS.getSkillId()))), 
	HALFLING	(3, 	"Halfling",		25, new HashSet<Integer>(Arrays.asList(Skills.ACROBATICS.getSkillId()))), 
	HUMAN		(4, 	"Human",		30, new HashSet<Integer>()), //There are no proficient skills from the base human race. They will be on the human sub race, becuase of variant human
	DRAGONBORN	(5, 	"Dragonbord",   30, new HashSet<Integer>(Arrays.asList(Skills.ACROBATICS.getSkillId()))), 
	GNOME		(6, 	"Gnome",		25, new HashSet<Integer>(Arrays.asList(Skills.ACROBATICS.getSkillId()))), 
	HALF_ELF	(7, 	"Half-Elf",		30, new HashSet<Integer>(Arrays.asList(Skills.ACROBATICS.getSkillId()))), 
	HALF_ORC	(8, 	"Half-Orc",		30, new HashSet<Integer>(Arrays.asList(Skills.ACROBATICS.getSkillId()))), 
	TIEFLING	(9, 	"Tiefling",		30, new HashSet<Integer>(Arrays.asList(Skills.ACROBATICS.getSkillId())));
	
	//@formatter:on

	private final Integer raceId;
	private final String raceName;
	private final Integer raceSpeed;
	private final Set<Integer> profSkills;

	Races(Integer raceId, String raceName, Integer raceSpeed, Set<Integer> profSkills) {
		this.raceId = raceId;
		this.raceName = raceName;
		this.raceSpeed = raceSpeed;
		this.profSkills = profSkills;
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

	public Set<Integer> getProfSkills() {
		return profSkills;
	}

	public static Races[] getRaces() {
		return Races.values();
	}

	@Override
	public String toString() {
		return this.raceName;
	}
}
