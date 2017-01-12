package com.nfpenterprise.gameHub.constants;

public enum PersonalityTraits {
	//@formatter:off

	PERSONALITY			(Backgrounds.ACOLYTE.getBackgroundId(), 	"test"),
	CRIMINAL_3			(Backgrounds.CRIMINAL.getBackgroundId(), 	"The first thing I do in a new place is note the locations of everything valuable - or where such things could be hidden.");

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
