package com.nfpenterprise.gameHub.constants;

public enum Ideals {
	//@formatter:off

	IDEALS			(Backgrounds.ACOLYTE.getBackgroundId(), 	"test"),
	CRIMINAL_5		(Backgrounds.CRIMINAL.getBackgroundId(),	"People. I’m loyal to my friends, not to any ideals, and everyone else can take a trip down the Styx for all I care. (Neutral)");

	//@formatter:on

	private final Integer backgroundId;
	private final String idealText;

	Ideals(Integer backgroundId, String idealText) {
		this.backgroundId = backgroundId;
		this.idealText = idealText;
	}

	public Integer getBackgroundId() {
		return backgroundId;
	}

	public String getIdealText() {
		return idealText;
	}

	public static Ideals[] getIdeals() {
		return Ideals.values();
	}

	@Override
	public String toString() {
		return this.idealText;
	}

}
