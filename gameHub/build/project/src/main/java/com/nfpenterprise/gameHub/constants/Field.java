package com.nfpenterprise.gameHub.constants;

public enum Field {
	APPLICATION_NAME("Project Valhalla"),
	NEW_CHARACTER("New Character"),
	MY_CHARACTERS("My Characters");

	private final String fieldString;

	Field(String fieldString) {
		this.fieldString = fieldString;
	}

	public String toString() {
		return fieldString;
	}
}
