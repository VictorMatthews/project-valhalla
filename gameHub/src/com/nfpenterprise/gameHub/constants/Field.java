package com.nfpenterprise.gameHub.constants;

public enum Field {
	APPLICATION_NAME("Project Valhalla");

	private final String fieldString;

	Field(String fieldString) {
		this.fieldString = fieldString;
	}

	public String toString() {
		return fieldString;
	}
}
