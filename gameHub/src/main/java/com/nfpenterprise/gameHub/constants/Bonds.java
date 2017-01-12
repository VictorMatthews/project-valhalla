package com.nfpenterprise.gameHub.constants;

public enum Bonds {
	//@formatter:off

	BONDS			(Backgrounds.ACOLYTE.getBackgroundId(), 	"test");

	//@formatter:on

	private final Integer backgroundId;
	private final String bondText;

	Bonds(Integer backgroundId, String bondText) {
		this.backgroundId = backgroundId;
		this.bondText = bondText;
	}

	public Integer getBackgroundId() {
		return backgroundId;
	}

	public String getBondText() {
		return bondText;
	}

}
