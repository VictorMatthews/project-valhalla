package com.nfpenterprise.gameHub.constants;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public enum Classes {
	//@formatter:off
	
	BARBARIAN	("Barbarian", 	12,	Paths.BARBARIAN_HTML.getPath(),	new HashSet<Integer>(Arrays.asList(Skills.ACROBATICS.getSkillId())), new HashSet<Integer>(Arrays.asList(Attributes.STRENGTH.getAttributeId()))),
	
	BARD		("Bard", 		12,	Paths.BARD_HTML.getPath(),	new HashSet<Integer>(Arrays.asList(Skills.ACROBATICS.getSkillId())), new HashSet<Integer>(Arrays.asList(Attributes.STRENGTH.getAttributeId()))),
	
	CLERIC		("Cleric", 		12,	Paths.CLERIC_HTML.getPath(),	new HashSet<Integer>(Arrays.asList(Skills.ACROBATICS.getSkillId())), new HashSet<Integer>(Arrays.asList(Attributes.STRENGTH.getAttributeId()))),
	
	DRUID		("Druid", 		12,	Paths.DRUID_HTML.getPath(),	new HashSet<Integer>(Arrays.asList(Skills.ACROBATICS.getSkillId())), new HashSet<Integer>(Arrays.asList(Attributes.STRENGTH.getAttributeId()))),
	
	FIGHTER		("Fighter",		12,	Paths.FIGHTER_HTML.getPath(),	new HashSet<Integer>(Arrays.asList(Skills.ACROBATICS.getSkillId())), new HashSet<Integer>(Arrays.asList(Attributes.STRENGTH.getAttributeId()))),
	
	MONK		("Monk", 		12,	Paths.MONK_HTML.getPath(),	new HashSet<Integer>(Arrays.asList(Skills.ACROBATICS.getSkillId())), new HashSet<Integer>(Arrays.asList(Attributes.STRENGTH.getAttributeId()))),
	
	PALADIN		("Paladin", 	12,	Paths.PALADIN_HTML.getPath(),	new HashSet<Integer>(Arrays.asList(Skills.ACROBATICS.getSkillId())), new HashSet<Integer>(Arrays.asList(Attributes.STRENGTH.getAttributeId()))),
	
	RANGER		("Ranger", 		12,	Paths.RANGER_HTML.getPath(),	new HashSet<Integer>(Arrays.asList(Skills.ACROBATICS.getSkillId())), new HashSet<Integer>(Arrays.asList(Attributes.STRENGTH.getAttributeId()))),
	
	ROGUE		("Rogue", 		12,	Paths.ROGUE_HTML.getPath(),	new HashSet<Integer>(Arrays.asList(Skills.ACROBATICS.getSkillId())), new HashSet<Integer>(Arrays.asList(Attributes.STRENGTH.getAttributeId()))),
	
	SORCERER	("Sorcerer", 	12,	Paths.SORCERER_HTML.getPath(),	new HashSet<Integer>(Arrays.asList(Skills.ACROBATICS.getSkillId())), new HashSet<Integer>(Arrays.asList(Attributes.STRENGTH.getAttributeId()))),
	
	WARLOCK		("Warlock", 	12,	Paths.WARLOCK_HTML.getPath(),	new HashSet<Integer>(Arrays.asList(Skills.ACROBATICS.getSkillId())), new HashSet<Integer>(Arrays.asList(Attributes.STRENGTH.getAttributeId()))),
	
	WIZARD		("Wizard", 		12,	Paths.WIZARD_HTML.getPath(),	new HashSet<Integer>(Arrays.asList(Skills.ACROBATICS.getSkillId())), new HashSet<Integer>(Arrays.asList(Attributes.STRENGTH.getAttributeId())));

	//@formatter:on

	private final String className;
	private final Integer hitDie;
	private final String htmlPath;
	private final Set<Integer> profSkillsChoices;
	private final Set<Integer> savingThrows;

	Classes(String className, Integer hitDie, String htmlPath, Set<Integer> profSkillsChoices, Set<Integer> savingThrows) {
		this.className = className;
		this.hitDie = hitDie;
		this.htmlPath = htmlPath;
		this.profSkillsChoices = profSkillsChoices;
		this.savingThrows = savingThrows;
	}

	public String getClassName() {
		return className;
	}

	public Integer getHitDie() {
		return hitDie;
	}

	public String getHtmlPath() {
		return htmlPath;
	}

	public Set<Integer> getProfSkillsChoices() {
		return profSkillsChoices;
	}

	public Set<Integer> getSavingThrows() {
		return savingThrows;
	}

	public static Classes[] getClasses() {
		return Classes.values();
	}

	@Override
	public String toString() {
		return this.className;
	}

}
