package com.nfpenterprise.gameHub.constants;

public enum PersonalityTraits {
	//@formatter:off

	PERSONALITY			(Backgrounds.ACOLYTE.getBackgroundId(), 	"test");

	//@formatter:on

	private final Integer backgroundId;
	private final String personalityTraitText;

	PersonalityTraits(Integer backgroundId, String personalityTraitText) {
		this.backgroundId = backgroundId;
		this.personalityTraitText = personalityTraitText;
	}

	public Integer getBackgroundId() {
		return backgroundId;
	}

	public String getPersonalityTraitText() {
		return personalityTraitText;
	}

	public static PersonalityTraits[] getPersonalityTraits() {
		return PersonalityTraits.values();
	}

	@Override
	public String toString() {
		return this.personalityTraitText;
	}

}
