package com.nfpenterprise.gameHub.constants;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public enum Classes {
	//@formatter:off
	
	BARBARIAN	("Barbarian", 	12,	Paths.BARBARIAN_HTML.getPath(),		2 /*# of skills to choose*/,
				new HashSet<Integer>(Arrays.asList(	Skills.ANIMAL_HANDLING.getSkillId(), Skills.ATHLETICS.getSkillId(), Skills.INTIMIDATION.getSkillId(),
													Skills.NATURE.getSkillId(), Skills.PERCEPTION.getSkillId(), Skills.SURVIVAL.getSkillId())),
				new HashSet<Integer>(Arrays.asList(Attributes.STRENGTH.getAttributeId(), Attributes.CONSTITUTION.getAttributeId()))),

	BARD		("Bard", 		12,	Paths.BARD_HTML.getPath(),			3 /*# of skills to choose*/, getAllSkills(), 
				new HashSet<Integer>(Arrays.asList(Attributes.DEXTERITY.getAttributeId(), Attributes.CHARISMA.getAttributeId()))),

	CLERIC		("Cleric", 		12,	Paths.CLERIC_HTML.getPath(),		2 /*# of skills to choose*/,
				new HashSet<Integer>(Arrays.asList( Skills.HISTORY.getSkillId(), Skills.INSIGHT.getSkillId(), Skills.MEDICINE.getSkillId(),
													Skills.PERSUASION.getSkillId(), Skills.RELIGION.getSkillId())), 
				new HashSet<Integer>(Arrays.asList(Attributes.WISDOM.getAttributeId(), Attributes.CHARISMA.getAttributeId()))),

	DRUID		("Druid", 		12,	Paths.DRUID_HTML.getPath(),			2 /*# of skills to choose*/,
				new HashSet<Integer>(Arrays.asList( Skills.ARCANA.getSkillId(), Skills.INSIGHT.getSkillId(), Skills.ANIMAL_HANDLING.getSkillId(),
													Skills.MEDICINE.getSkillId(), Skills.NATURE.getSkillId(), Skills.PERCEPTION.getSkillId(),
													Skills.RELIGION.getSkillId(), Skills.SURVIVAL.getSkillId())), 
				new HashSet<Integer>(Arrays.asList(Attributes.INTELLIGENCE.getAttributeId(), Attributes.WISDOM.getAttributeId()))),

	FIGHTER		("Fighter",		12,	Paths.FIGHTER_HTML.getPath(),		2 /*# of skills to choose*/,
				new HashSet<Integer>(Arrays.asList( Skills.ACROBATICS.getSkillId(), Skills.ANIMAL_HANDLING.getSkillId(), Skills.ATHLETICS.getSkillId(),
													Skills.HISTORY.getSkillId(), Skills.INSIGHT.getSkillId(), Skills.INTIMIDATION.getSkillId(),
													Skills.PERCEPTION.getSkillId(), Skills.SURVIVAL.getSkillId())), 
				new HashSet<Integer>(Arrays.asList(Attributes.STRENGTH.getAttributeId(), Attributes.CONSTITUTION.getAttributeId()))),

	MONK		("Monk", 		12,	Paths.MONK_HTML.getPath(),			2 /*# of skills to choose*/,
				new HashSet<Integer>(Arrays.asList( Skills.ACROBATICS.getSkillId(), Skills.ATHLETICS.getSkillId(), Skills.HISTORY.getSkillId(),
													Skills.INSIGHT.getSkillId(), Skills.RELIGION.getSkillId(), Skills.STEALTH.getSkillId())), 
				new HashSet<Integer>(Arrays.asList(Attributes.STRENGTH.getAttributeId(), Attributes.DEXTERITY.getAttributeId()))),

	PALADIN		("Paladin", 	12,	Paths.PALADIN_HTML.getPath(),		1 /*# of skills to choose*/,
				new HashSet<Integer>(Arrays.asList( Skills.ATHLETICS.getSkillId(), Skills.INSIGHT.getSkillId(), Skills.INTIMIDATION.getSkillId(),
													Skills.MEDICINE.getSkillId(), Skills.PERSUASION.getSkillId(), Skills.RELIGION.getSkillId())), 
				new HashSet<Integer>(Arrays.asList(Attributes.WISDOM.getAttributeId(), Attributes.CHARISMA.getAttributeId()))),

	RANGER		("Ranger", 		12,	Paths.RANGER_HTML.getPath(),		1 /*# of skills to choose*/,
				new HashSet<Integer>(Arrays.asList(	Skills.ANIMAL_HANDLING.getSkillId(), Skills.ATHLETICS.getSkillId(), Skills.INSIGHT.getSkillId(),
													Skills.INVESTIGATION.getSkillId(), Skills.NATURE.getSkillId(), Skills.PERCEPTION.getSkillId(),
													Skills.STEALTH.getSkillId(), Skills.SURVIVAL.getSkillId())), 
				new HashSet<Integer>(Arrays.asList(Attributes.STRENGTH.getAttributeId(), Attributes.DEXTERITY.getAttributeId()))),

	ROGUE		("Rogue", 		12,	Paths.ROGUE_HTML.getPath(),			1 /*# of skills to choose*/,
				new HashSet<Integer>(Arrays.asList( Skills.ACROBATICS.getSkillId(), Skills.ATHLETICS.getSkillId(), Skills.DECEPTION.getSkillId(),
													Skills.INSIGHT.getSkillId(), Skills.INTIMIDATION.getSkillId(), Skills.INVESTIGATION.getSkillId(),
													Skills.PERCEPTION.getSkillId(), Skills.PERFORMANCE.getSkillId(), Skills.PERSUASION.getSkillId(),
													Skills.SLEIGHT_OF_HAND.getSkillId(), Skills.STEALTH.getSkillId())), 
				new HashSet<Integer>(Arrays.asList(Attributes.DEXTERITY.getAttributeId(), Attributes.INTELLIGENCE.getAttributeId()))),

	SORCERER	("Sorcerer", 	12,	Paths.SORCERER_HTML.getPath(),		1 /*# of skills to choose*/,
				new HashSet<Integer>(Arrays.asList( Skills.ARCANA.getSkillId(), Skills.DECEPTION.getSkillId(), Skills.INSIGHT.getSkillId(),
													Skills.INTIMIDATION.getSkillId(), Skills.PERSUASION.getSkillId(), Skills.RELIGION.getSkillId())), 
				new HashSet<Integer>(Arrays.asList(Attributes.CONSTITUTION.getAttributeId(), Attributes.CHARISMA.getAttributeId()))),

	WARLOCK		("Warlock", 	12,	Paths.WARLOCK_HTML.getPath(),		1 /*# of skills to choose*/,
				new HashSet<Integer>(Arrays.asList( Skills.ARCANA.getSkillId(), Skills.DECEPTION.getSkillId(), Skills.HISTORY.getSkillId(),
													Skills.INTIMIDATION.getSkillId(), Skills.INVESTIGATION.getSkillId(), Skills.NATURE.getSkillId(),
													Skills.RELIGION.getSkillId())), 
				new HashSet<Integer>(Arrays.asList(Attributes.WISDOM.getAttributeId(), Attributes.CHARISMA.getAttributeId()))),

	WIZARD		("Wizard", 		12,	Paths.WIZARD_HTML.getPath(),		1 /*# of skills to choose*/,
				new HashSet<Integer>(Arrays.asList( Skills.ARCANA.getSkillId(), Skills.HISTORY.getSkillId(), Skills.INSIGHT.getSkillId(),
													Skills.INVESTIGATION.getSkillId(), Skills.MEDICINE.getSkillId(), Skills.RELIGION.getSkillId())), 
				new HashSet<Integer>(Arrays.asList(Attributes.INTELLIGENCE.getAttributeId(), Attributes.WISDOM.getAttributeId())));

	//@formatter:on

	private final String className;
	private final Integer hitDie;
	private final String htmlPath;
	private final Integer profSkillsToChoose;
	private final Set<Integer> profSkillsChoices;
	private final Set<Integer> savingThrows;

	Classes(String className, Integer hitDie, String htmlPath, Integer profSkillsToChoose, Set<Integer> profSkillsChoices, Set<Integer> savingThrows) {
		this.className = className;
		this.hitDie = hitDie;
		this.htmlPath = htmlPath;
		this.profSkillsToChoose = profSkillsToChoose;
		this.profSkillsChoices = profSkillsChoices;
		this.savingThrows = savingThrows;
	}

	private static Set<Integer> getAllSkills() {
		Set<Integer> allSkillIds = new HashSet<Integer>();
		for (Skills skill : Skills.getSkills()) {
			allSkillIds.add(skill.getSkillId());
		}
		return allSkillIds;
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

	public Integer getProfSkillsToChoose() {
		return profSkillsToChoose;
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
