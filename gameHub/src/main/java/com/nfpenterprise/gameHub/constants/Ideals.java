package com.nfpenterprise.gameHub.constants;

public enum Ideals {
	//@formatter:off

	IDEALS			(Backgrounds.ACOLYTE.getBackgroundId(), 	"test");

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

}
