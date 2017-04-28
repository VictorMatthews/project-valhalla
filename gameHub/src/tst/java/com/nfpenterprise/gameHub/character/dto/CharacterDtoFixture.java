package com.nfpenterprise.gameHub.character.dto;

import com.nfpenterprise.gameHub.constants.Backgrounds;
import com.nfpenterprise.gameHub.constants.Bonds;
import com.nfpenterprise.gameHub.constants.Classes;
import com.nfpenterprise.gameHub.constants.Flaws;
import com.nfpenterprise.gameHub.constants.Ideals;
import com.nfpenterprise.gameHub.constants.PersonalityTraits;
import com.nfpenterprise.gameHub.constants.Races;
import com.nfpenterprise.gameHub.constants.SubRaces;

public class CharacterDtoFixture {
	public static CharacterDto createCharacterDto() {
		CharacterDto character = new CharacterDto();
		character.setBackground(Backgrounds.CRIMINAL);
		character.setRace(Races.GNOME);
		character.setSubRace(SubRaces.FOREST_GNOME);
		character.setClassName(Classes.BARD);
		character.setStrength(8);
		character.setDexterity(8);
		character.setConstitution(8);
		character.setIntelligence(8);
		character.setWisdom(8);
		character.setCharisma(8);
		character.setPersonalityTrait(PersonalityTraits.CRIMINAL_1);
		character.setBonds(Bonds.CRIMINAL_1);
		character.setFlaws(Flaws.CRIMINAL_1);
		character.setIdeals(Ideals.CRIMINAL_1);
		return character;
	}
}
