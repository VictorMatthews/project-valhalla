package com.nfpenterprise.gameHub.constants;

public enum Flaws {
	//@formatter:off

	FLAW			(Backgrounds.ACOLYTE.getBackgroundId(), 	"test"),
	CRIMINAL_1 		(Backgrounds.CRIMINAL.getBackgroundId(), 	"When I see something valuable, I can't think about anything but how to steal it.");

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

	public static Flaws[] getFlaws() {
		return Flaws.values();
	}

	@Override
	public String toString() {
		return this.flawText;
	}

}
