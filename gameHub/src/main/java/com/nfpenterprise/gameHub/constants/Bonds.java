package com.nfpenterprise.gameHub.constants;

public enum Bonds {
	//@formatter:off

	BONDS			(Backgrounds.ACOLYTE.getBackgroundId(), 	"test"),
	CRIMINAL_2		(Backgrounds.CRIMINAL.getBackgroundId(),	"My ill-gotten gains go to support my family.");

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

	public static Bonds[] getBonds() {
		return Bonds.values();
	}

	@Override
	public String toString() {
		return this.bondText;
	}

}
