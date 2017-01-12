package com.nfpenterprise.gameHub.constants;

public enum Skills {
	//@formatter:off

	ACROBATICS			( 1, 	"Acrobatics"),
	ANIMAL_HANDLING		( 2, 	"Animal Handling"),
	ARCANA				( 3, 	"Arcana"),
	ATHLETICS			( 4, 	"Athletics"),
	DECEPTION			( 5, 	"Deception"),
	HISTORY				( 6, 	"History"),
	INSIGHT				( 7, 	"Insight"),
	INTIMIDATION		( 8, 	"Intimidation"),
	INVESTIGATION		( 9, 	"Investigation"),
	MEDICINE			(10, 	"Medicine"),
	NATURE				(11, 	"Nature"),
	PERCEPTION			(12, 	"Perception"),
	PERFORMANCE			(13, 	"Performance"),
	PERSUASION			(14, 	"Persuasion"),
	RELIGION			(15, 	"Religion"),
	SLEIGHT_OF_HAND		(16, 	"Sleight of Hand"),
	STEALTH				(17, 	"Stealth"),
	SURVIVAL			(18, 	"Survival");

	//@formatter:on

	private final Integer skillId;
	private final String skillName;

	Skills(Integer skillId, String skillName) {
		this.skillId = skillId;
		this.skillName = skillName;
	}

	public Integer getSkillId() {
		return skillId;
	}

	public String getSkillName() {
		return skillName;
	}

	public static Skills[] getSkills() {
		return Skills.values();
	}

}
