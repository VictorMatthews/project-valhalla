package com.nfpenterprise.gameHub.constants;

public enum Message {
	MUST_COMPLETE_RACE("you must select a race."),
	MUST_COMPLETE_SUB_RACE("you must select a sub race."),
	MUST_COMPLETE_CLASS("you must select a class.");

	private final String message;

	Message(String message) {
		this.message = message;
	}

	public String toString() {
		return message;
	}

}
