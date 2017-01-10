package com.nfpenterprise.gameHub.characterClass.dto;

import com.nfpenterprise.gameHub.constants.Classes;

public class ClassDto {
	private String className;

	public ClassDto() {
	}

	public ClassDto(Classes classEnum) {
		setClassName(classEnum.getClassName());
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}
}
