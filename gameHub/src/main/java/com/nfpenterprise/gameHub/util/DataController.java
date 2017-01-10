package com.nfpenterprise.gameHub.util;

import java.util.HashSet;
import java.util.Set;

import com.nfpenterprise.gameHub.characterClass.dto.ClassDto;
import com.nfpenterprise.gameHub.constants.Classes;
import com.nfpenterprise.gameHub.constants.Races;
import com.nfpenterprise.gameHub.constants.SubRaces;
import com.nfpenterprise.gameHub.race.dto.RaceDto;
import com.nfpenterprise.gameHub.race.dto.SubRaceDto;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DataController {
	public DataController() {
		
	}

	public ObservableList<RaceDto> populateRaceData() {
		ObservableList<RaceDto> races = FXCollections.observableArrayList();
		races.add(new RaceDto(Races.DWARF));
		races.add(new RaceDto(Races.ELF));
		races.add(new RaceDto(Races.HALFLING));
		races.add(new RaceDto(Races.HUMAN));
		races.add(new RaceDto(Races.DRAGONBORN));
		races.add(new RaceDto(Races.GNOME));
		races.add(new RaceDto(Races.HALF_ELF));
		races.add(new RaceDto(Races.HALF_ORC));
		races.add(new RaceDto(Races.TIEFLING));
		return races;		
	}

	public ObservableList<SubRaceDto> populateSubRaceData(RaceDto selectedRace) {
		Set<SubRaceDto> subRaceSet = populateSubRaceData();
		ObservableList<SubRaceDto> subRaces = FXCollections.observableArrayList();
		for(SubRaceDto subRace : subRaceSet) {
			if (subRace.getRaceId().equals(selectedRace.getRaceId())) {
				subRaces.add(subRace);
			}
		}
		return subRaces;
	}

	public Set<SubRaceDto> populateSubRaceData() {
		Set<SubRaceDto> subRaceSet = new HashSet<SubRaceDto>();
		subRaceSet.add(new SubRaceDto(SubRaces.FOREST_GNOME));
		subRaceSet.add(new SubRaceDto(SubRaces.ROCK_GNOME));
		subRaceSet.add(new SubRaceDto(SubRaces.HIGH_ELF));
		subRaceSet.add(new SubRaceDto(SubRaces.WOOD_ELF));
		subRaceSet.add(new SubRaceDto(SubRaces.DARK_ELF));
		subRaceSet.add(new SubRaceDto(SubRaces.LIGHT_FOOT_HALFLING));
		subRaceSet.add(new SubRaceDto(SubRaces.STOUT_HALFLING));
		subRaceSet.add(new SubRaceDto(SubRaces.HILL_DWARF));
		subRaceSet.add(new SubRaceDto(SubRaces.MOUNTAIN_DWARF));
		return subRaceSet;
	}

	public ObservableList<ClassDto> populateClassData() {
		ObservableList<ClassDto> classes = FXCollections.observableArrayList();
		classes.add(new ClassDto(Classes.BARBARIAN));
		classes.add(new ClassDto(Classes.BARD));
		classes.add(new ClassDto(Classes.CLERIC));
		classes.add(new ClassDto(Classes.DRUID));
		classes.add(new ClassDto(Classes.FIGHTER));
		classes.add(new ClassDto(Classes.MONK));
		classes.add(new ClassDto(Classes.PALADIN));
		classes.add(new ClassDto(Classes.RANGER));
		classes.add(new ClassDto(Classes.ROGUE));
		classes.add(new ClassDto(Classes.SORCERER));
		classes.add(new ClassDto(Classes.WIZARD));
		return classes;		
	}
}
