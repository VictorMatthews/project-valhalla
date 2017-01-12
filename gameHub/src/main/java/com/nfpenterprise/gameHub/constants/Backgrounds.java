package com.nfpenterprise.gameHub.constants;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public enum Backgrounds {
	//@formatter:off

	ACOLYTE			( 1, 	"Acolyte", 			new HashSet<Integer>(Arrays.asList(Skills.ACROBATICS.getSkillId()))),
	CHARLATAN		( 2, 	"Charlatan", 		new HashSet<Integer>(Arrays.asList(Skills.ACROBATICS.getSkillId()))),
	CRIMINAL		( 3, 	"Criminal", 		new HashSet<Integer>(Arrays.asList(Skills.ACROBATICS.getSkillId()))),
	ENTERTAINER		( 4, 	"Entertainer", 		new HashSet<Integer>(Arrays.asList(Skills.ACROBATICS.getSkillId()))),
	FOLK_HERO		( 5, 	"Folk Hero", 		new HashSet<Integer>(Arrays.asList(Skills.ACROBATICS.getSkillId()))),
	GUILD_ARTISAN	( 6, 	"Guild Artisan", 	new HashSet<Integer>(Arrays.asList(Skills.ACROBATICS.getSkillId()))),
	HERMIT			( 7, 	"Hermit", 			new HashSet<Integer>(Arrays.asList(Skills.ACROBATICS.getSkillId()))),
	NOBLE			( 8, 	"Noble", 			new HashSet<Integer>(Arrays.asList(Skills.ACROBATICS.getSkillId()))),
	OUTLANDER		( 9, 	"Outlander", 		new HashSet<Integer>(Arrays.asList(Skills.ACROBATICS.getSkillId()))),
	SAILOR			(10, 	"Sailor", 			new HashSet<Integer>(Arrays.asList(Skills.ACROBATICS.getSkillId()))),
	SOLDIER			(11, 	"Soldier", 			new HashSet<Integer>(Arrays.asList(Skills.ACROBATICS.getSkillId()))),
	URCHIN			(12, 	"Urchin", 			new HashSet<Integer>(Arrays.asList(Skills.ACROBATICS.getSkillId())));

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
