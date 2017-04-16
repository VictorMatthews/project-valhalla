package com.nfpenterprise.gameHub.constants;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public enum Backgrounds {
	//@formatter:off

	ACOLYTE			( 1, 	"Acolyte", 			new HashSet<Integer>(Arrays.asList(Skills.INSIGHT.getSkillId(),Skills.RELIGION.getSkillId()))),
	CHARLATAN		( 2, 	"Charlatan", 		new HashSet<Integer>(Arrays.asList(Skills.DECEPTION.getSkillId(),Skills.SLEIGHT_OF_HAND.getSkillId()))),
	CRIMINAL		( 3, 	"Criminal", 		new HashSet<Integer>(Arrays.asList(Skills.DECEPTION.getSkillId(),Skills.STEALTH.getSkillId()))),
	ENTERTAINER		( 4, 	"Entertainer", 		new HashSet<Integer>(Arrays.asList(Skills.ACROBATICS.getSkillId(),Skills.PERFORMANCE.getSkillId()))),
	FOLK_HERO		( 5, 	"Folk Hero", 		new HashSet<Integer>(Arrays.asList(Skills.ANIMAL_HANDLING.getSkillId(),Skills.SURVIVAL.getSkillId()))),
	GUILD_ARTISAN	( 6, 	"Guild Artisan", 	new HashSet<Integer>(Arrays.asList(Skills.INSIGHT.getSkillId(),Skills.PERSUASION.getSkillId()))),
	HERMIT			( 7, 	"Hermit", 			new HashSet<Integer>(Arrays.asList(Skills.MEDICINE.getSkillId(),Skills.RELIGION.getSkillId()))),
	NOBLE			( 8, 	"Noble", 			new HashSet<Integer>(Arrays.asList(Skills.HISTORY.getSkillId(),Skills.PERSUASION.getSkillId()))),
	OUTLANDER		( 9, 	"Outlander", 		new HashSet<Integer>(Arrays.asList(Skills.ATHLETICS.getSkillId(),Skills.SURVIVAL.getSkillId()))),
	SAGE			(10, 	"Sage", 			new HashSet<Integer>(Arrays.asList(Skills.ARCANA.getSkillId(),Skills.HISTORY.getSkillId()))),
	SAILOR			(11, 	"Sailor", 			new HashSet<Integer>(Arrays.asList(Skills.ATHLETICS.getSkillId(),Skills.PERCEPTION.getSkillId()))),
	SOLDIER			(12, 	"Soldier", 			new HashSet<Integer>(Arrays.asList(Skills.ATHLETICS.getSkillId(),Skills.INTIMIDATION.getSkillId()))),
	URCHIN			(13, 	"Urchin", 			new HashSet<Integer>(Arrays.asList(Skills.SLEIGHT_OF_HAND.getSkillId(),Skills.STEALTH.getSkillId())));

	//@formatter:on

	private final Integer backgroundId;
	private final String backgroundName;
	private final Set<Integer> profSkills;

	Backgrounds(Integer backgroundId, String backgroundName, Set<Integer> profSkills) {
		this.backgroundId = backgroundId;
		this.backgroundName = backgroundName;
		this.profSkills = profSkills;
	}

	public Integer getBackgroundId() {
		return backgroundId;
	}

	public String getBackgroundName() {
		return backgroundName;
	}

	public Set<Integer> getProfSkills() {
		return profSkills;
	}

	public static Backgrounds[] getBackgrounds() {
		return Backgrounds.values();
	}

	@Override
	public String toString() {
		return this.backgroundName;
	}

}
