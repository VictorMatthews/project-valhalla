package com.nfpenterprise.gameHub.constants;

public enum Flaws {
	//@formatter:off

	Flaw			(Backgrounds.ACOLYTE.getBackgroundId(), 	"test");

	//@formatter:on

	private final Integer backgroundId;
	private final String flawText;

	Flaws(Integer backgroundId, String flawText) {
		this.backgroundId = backgroundId;
		this.flawText = flawText;
	}

	public Integer getBackgroundId() {
		return backgroundId;
	}

	public String getFlawText() {
		return flawText;
	}

}
