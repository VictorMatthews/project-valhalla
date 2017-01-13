package com.nfpenterprise.gameHub.constants;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import com.nfpenterprise.gameHub.character.dto.AttributeDto;

public enum Races {
	//@formatter:off
	
	DWARF		(1, 	"Dwarf",		25, Paths.DWARF_HTML.getPath(),	new HashSet<AttributeDto>(Arrays.asList(new AttributeDto(Attributes.CONSTITUTION.getAttributeId(), 2)))), 
	
	ELF			(2, 	"Elf",			30, Paths.ELF_HTML.getPath(),	new HashSet<AttributeDto>(Arrays.asList(new AttributeDto(Attributes.CONSTITUTION.getAttributeId(), 2)))), 
	
	HALFLING	(3, 	"Halfling",		25, Paths.HALFLING_HTML.getPath(),	new HashSet<AttributeDto>(Arrays.asList(new AttributeDto(Attributes.CONSTITUTION.getAttributeId(), 2)))),
	
	HUMAN		(4, 	"Human",		30, Paths.HUMAN_HTML.getPath(),	new HashSet<AttributeDto>(Arrays.asList(new AttributeDto(Attributes.CONSTITUTION.getAttributeId(), 2)))), //There are no proficient skills from the base human race. They will be on the human sub race, becuase of variant human
	
	DRAGONBORN	(5, 	"Dragonborn",   30, Paths.DRAGONBORN_HTML.getPath(),	new HashSet<AttributeDto>(Arrays.asList(new AttributeDto(Attributes.CONSTITUTION.getAttributeId(), 2)))), 
	
	GNOME		(6, 	"Gnome",		25, Paths.GNOME_HTML.getPath(),	new HashSet<AttributeDto>(Arrays.asList(new AttributeDto(Attributes.CONSTITUTION.getAttributeId(), 2)))), 
	
	HALF_ELF	(7, 	"Half-Elf",		30, Paths.HALF_ELF_HTML.getPath(),	new HashSet<AttributeDto>(Arrays.asList(new AttributeDto(Attributes.CONSTITUTION.getAttributeId(), 2)))), 
	
	HALF_ORC	(8, 	"Half-Orc",		30, Paths.HALF_ORC_HTML.getPath(),	new HashSet<AttributeDto>(Arrays.asList(new AttributeDto(Attributes.CONSTITUTION.getAttributeId(), 2)))), 
	
	TIEFLING	(9, 	"Tiefling",		30, Paths.TIEFLING_HTML.getPath(),	new HashSet<AttributeDto>(Arrays.asList(new AttributeDto(Attributes.CONSTITUTION.getAttributeId(), 2))));
	
	//@formatter:on

	private final Integer raceId;
	private final String raceName;
	private final Integer raceSpeed;
	private final String htmlPath;
	private final Set<AttributeDto> increaseAttribute;

	Races(Integer raceId, String raceName, Integer raceSpeed, String htmlPath, Set<AttributeDto> increaseAttribute) {
		this.raceId = raceId;
		this.raceName = raceName;
		this.raceSpeed = raceSpeed;
		this.htmlPath = htmlPath;
		this.increaseAttribute = increaseAttribute;
	}

	public String getRaceName() {
		return raceName;
	}

	public Integer getRaceId() {
		return raceId;
	}

	public Integer getRaceSpeed() {
		return raceSpeed;
	}

	public String getHtmlPath() {
		return htmlPath;
	}

	public Set<AttributeDto> getIncreaseAttribute() {
		return increaseAttribute;
	}

	public static Races[] getRaces() {
		return Races.values();
	}

	@Override
	public String toString() {
		return this.raceName;
	}
}
