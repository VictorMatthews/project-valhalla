package com.nfpenterprise.gameHub.constants;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public enum Classes {
	//@formatter:off
	
	BARBARIAN	("Barbarian", 	new HashSet<Integer>(Arrays.asList(Skills.ACROBATICS.getSkillId()))),
	BARD		("Bard", 		new HashSet<Integer>(Arrays.asList(Skills.ACROBATICS.getSkillId()))),
	CLERIC		("Cleric", 		new HashSet<Integer>(Arrays.asList(Skills.ACROBATICS.getSkillId()))),
	DRUID		("Druid", 		new HashSet<Integer>(Arrays.asList(Skills.ACROBATICS.getSkillId()))),
	FIGHTER		("Fighter",		new HashSet<Integer>(Arrays.asList(Skills.ACROBATICS.getSkillId()))),
	MONK		("Monk", 		new HashSet<Integer>(Arrays.asList(Skills.ACROBATICS.getSkillId()))),
	PALADIN		("Paladin", 	new HashSet<Integer>(Arrays.asList(Skills.ACROBATICS.getSkillId()))),
	RANGER		("Ranger", 		new HashSet<Integer>(Arrays.asList(Skills.ACROBATICS.getSkillId()))),
	ROGUE		("Rogue", 		new HashSet<Integer>(Arrays.asList(Skills.ACROBATICS.getSkillId()))),
	SORCERER	("Sorcerer", 	new HashSet<Integer>(Arrays.asList(Skills.ACROBATICS.getSkillId()))),
	WARLOCK		("Warlock", 	new HashSet<Integer>(Arrays.asList(Skills.ACROBATICS.getSkillId()))),
	WIZARD		("Wizard", 		new HashSet<Integer>(Arrays.asList(Skills.ACROBATICS.getSkillId())));

	//@formatter:on

	private final String className;
	private final Set<Integer> profSkills;

	Classes(String className, Set<Integer> profSkills) {
		this.className = className;
		this.profSkills = profSkills;
	}

	public String getClassName() {
		return className;
	}

	public Set<Integer> getProfSkills() {
		return profSkills;
	}

	public static Classes[] getClasses() {
		return Classes.values();
	}

	@Override
	public String toString() {
		return this.className;
	}

}
