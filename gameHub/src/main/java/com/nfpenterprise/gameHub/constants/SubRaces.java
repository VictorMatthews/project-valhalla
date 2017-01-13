package com.nfpenterprise.gameHub.constants;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import com.nfpenterprise.gameHub.character.dto.AttributeDto;

public enum SubRaces {
	//@formatter:off

	NO_SUBRACE				(0, 							"", 					Paths.HTML_TEST.getPath(),	new HashSet<AttributeDto>()),

	HILL_DWARF				(Races.DWARF.getRaceId(), 		"Hill Dwarf", 			Paths.HTML_TEST.getPath(),	new HashSet<AttributeDto>(Arrays.asList(new AttributeDto(Attributes.CONSTITUTION.getAttributeId(), 2)))),
	
	MOUNTAIN_DWARF			(Races.DWARF.getRaceId(), 		"Mountain Dwarf",		Paths.HTML_TEST.getPath(),	new HashSet<AttributeDto>(Arrays.asList(new AttributeDto(Attributes.CONSTITUTION.getAttributeId(), 2)))),
	
	HIGH_ELF				(Races.ELF.getRaceId(), 		"High Elf",				Paths.HTML_TEST.getPath(),	new HashSet<AttributeDto>(Arrays.asList(new AttributeDto(Attributes.CONSTITUTION.getAttributeId(), 2)))),
	
	WOOD_ELF				(Races.ELF.getRaceId(), 		"Wood Elf",				Paths.HTML_TEST.getPath(),	new HashSet<AttributeDto>(Arrays.asList(new AttributeDto(Attributes.CONSTITUTION.getAttributeId(), 2)))),
	
	DARK_ELF				(Races.ELF.getRaceId(), 		"Dark Elf (Drow)",		Paths.HTML_TEST.getPath(),	new HashSet<AttributeDto>(Arrays.asList(new AttributeDto(Attributes.CONSTITUTION.getAttributeId(), 2)))),
	
	LIGHT_FOOT_HALFLING		(Races.HALFLING.getRaceId(), 	"Lightfoot Halfling",	Paths.HTML_TEST.getPath(),	new HashSet<AttributeDto>(Arrays.asList(new AttributeDto(Attributes.CONSTITUTION.getAttributeId(), 2)))),
	
	STOUT_HALFLING			(Races.HALFLING.getRaceId(), 	"Stout Halfling",		Paths.HTML_TEST.getPath(),	new HashSet<AttributeDto>(Arrays.asList(new AttributeDto(Attributes.CONSTITUTION.getAttributeId(), 2)))),
	
	ROCK_GNOME				(Races.GNOME.getRaceId(),		"Rock Gnome",			Paths.HTML_TEST.getPath(),	new HashSet<AttributeDto>(Arrays.asList(new AttributeDto(Attributes.CONSTITUTION.getAttributeId(), 2)))),
	
	FOREST_GNOME			(Races.GNOME.getRaceId(),		"Forest Gnome",			Paths.HTML_TEST.getPath(),	new HashSet<AttributeDto>(Arrays.asList(new AttributeDto(Attributes.CONSTITUTION.getAttributeId(), 2))));
	
	//@formatter:on

	private final Integer raceId;
	private final String subRaceName;
	private final String htmlPath;
	private final Set<AttributeDto> increaseAttribute;

	SubRaces(Integer raceId, String raceName, String htmlPath, Set<AttributeDto> increaseAttribute) {
		this.raceId = raceId;
		this.subRaceName = raceName;
		this.htmlPath = htmlPath;
		this.increaseAttribute = increaseAttribute;
	}

	public String getSubRaceName() {
		return subRaceName;
	}

	public Integer getRaceId() {
		return raceId;
	}

	public String getHtmlPath() {
		return htmlPath;
	}

	public Set<AttributeDto> getIncreaseAttribute() {
		return increaseAttribute;
	}

	public static SubRaces[] getSubRaces() {
		return SubRaces.values();
	}

	@Override
	public String toString() {
		return this.subRaceName;
	}

}
