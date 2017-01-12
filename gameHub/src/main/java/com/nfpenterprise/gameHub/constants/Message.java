package com.nfpenterprise.gameHub.constants;

public enum Message {
	MUST_COMPLETE_RACE("You must select a race."),
	MUST_COMPLETE_SUB_RACE("You must select a sub race."),
	MUST_COMPLETE_CLASS("You must select a class.");

	private final String message;

	Message(String message) {
		this.message = message;
	}

	public String toString() {
		return message;
	}

}
