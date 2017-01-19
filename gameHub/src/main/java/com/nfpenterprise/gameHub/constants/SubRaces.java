package com.nfpenterprise.gameHub.constants;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import com.nfpenterprise.gameHub.character.dto.AttributeDto;

public enum SubRaces {
	//@formatter:off

	NO_SUBRACE				(0, 							"", 					null,	new HashSet<AttributeDto>()),

	HILL_DWARF				(Races.DWARF.getRaceId(), 		"Hill Dwarf", 			Paths.HILL_DWARF_HTML.getPath(),			new HashSet<AttributeDto>(Arrays.asList(new AttributeDto(Attributes.WISDOM.getAttributeId(), 1)))),

	MOUNTAIN_DWARF			(Races.DWARF.getRaceId(), 		"Mountain Dwarf",		Paths.MOUNTAIN_DWARF_HTML.getPath(),		new HashSet<AttributeDto>(Arrays.asList(new AttributeDto(Attributes.STRENGTH.getAttributeId(), 2)))),

	HIGH_ELF				(Races.ELF.getRaceId(), 		"High Elf",				Paths.HIGH_ELF_HTML.getPath(),				new HashSet<AttributeDto>(Arrays.asList(new AttributeDto(Attributes.INTELLIGENCE.getAttributeId(), 1)))),

	WOOD_ELF				(Races.ELF.getRaceId(), 		"Wood Elf",				Paths.WOOD_ELF_HTML.getPath(),				new HashSet<AttributeDto>(Arrays.asList(new AttributeDto(Attributes.WISDOM.getAttributeId(), 1)))),

	DARK_ELF				(Races.ELF.getRaceId(), 		"Dark Elf (Drow)",		Paths.DARK_ELF_HTML.getPath(),				new HashSet<AttributeDto>(Arrays.asList(new AttributeDto(Attributes.CHARISMA.getAttributeId(), 1)))),

	LIGHT_FOOT_HALFLING		(Races.HALFLING.getRaceId(), 	"Lightfoot Halfling",	Paths.LIGHT_FOOT_HALFLING_HTML.getPath(),	new HashSet<AttributeDto>(Arrays.asList(new AttributeDto(Attributes.CHARISMA.getAttributeId(), 1)))),

	STOUT_HALFLING			(Races.HALFLING.getRaceId(), 	"Stout Halfling",		Paths.STOUT_HALFLING_HTML.getPath(),		new HashSet<AttributeDto>(Arrays.asList(new AttributeDto(Attributes.CONSTITUTION.getAttributeId(), 1)))),

	ROCK_GNOME				(Races.GNOME.getRaceId(),		"Rock Gnome",			Paths.ROCK_GNOME_HTML.getPath(),			new HashSet<AttributeDto>(Arrays.asList(new AttributeDto(Attributes.CONSTITUTION.getAttributeId(), 1)))),

	FOREST_GNOME			(Races.GNOME.getRaceId(),		"Forest Gnome",			Paths.FOREST_GNOME_HTML.getPath(),			new HashSet<AttributeDto>(Arrays.asList(new AttributeDto(Attributes.DEXTERITY.getAttributeId(), 1))));
	
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
