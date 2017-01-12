package com.nfpenterprise.gameHub.util;

import com.nfpenterprise.gameHub.constants.Backgrounds;
import com.nfpenterprise.gameHub.constants.Bonds;
import com.nfpenterprise.gameHub.constants.Classes;
import com.nfpenterprise.gameHub.constants.Flaws;
import com.nfpenterprise.gameHub.constants.Ideals;
import com.nfpenterprise.gameHub.constants.PersonalityTraits;
import com.nfpenterprise.gameHub.constants.Races;
import com.nfpenterprise.gameHub.constants.SubRaces;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DataController {
	public DataController() {
		
	}

	public ObservableList<Races> populateRaceData() {
		ObservableList<Races> races = FXCollections.observableArrayList();
		for (Races race : Races.getRaces()) {
			races.add(race);
		}
		return races;		
	}

	public ObservableList<SubRaces> populateSubRaceData(Races selectedRace) {
		ObservableList<SubRaces> subRaces = FXCollections.observableArrayList();
		for(SubRaces subRace : SubRaces.getSubRaces()) {
			if (subRace.getRaceId().equals(selectedRace.getRaceId())) {
				subRaces.add(subRace);
			}
		}
		return subRaces;
	}

	public ObservableList<Classes> populateClassData() {
		ObservableList<Classes> classes = FXCollections.observableArrayList();
		for (Classes classData : Classes.getClasses()) {
			classes.add(classData);
		}
		return classes;		
	}

	public ObservableList<Backgrounds> populateBackgroundData() {
		ObservableList<Backgrounds> backgrounds = FXCollections.observableArrayList();
		for (Backgrounds background : Backgrounds.getBackgrounds()) {
			backgrounds.add(background);
		}
		return backgrounds;		
	}

	public ObservableList<PersonalityTraits> populatePersonalityTraitData(Backgrounds background) {
		ObservableList<PersonalityTraits> personalityTraits = FXCollections.observableArrayList();
		for (PersonalityTraits personalityTrait : PersonalityTraits.getPersonalityTraits()) {
			if (personalityTrait.getBackgroundId().equals(background.getBackgroundId())) {
				personalityTraits.add(personalityTrait);
			}
		}
		return personalityTraits;		
	}

	public ObservableList<Ideals> populateIdealData(Backgrounds background) {
		ObservableList<Ideals> ideals = FXCollections.observableArrayList();
		for (Ideals ideal : Ideals.getIdeals()) {
			if (ideal.getBackgroundId().equals(background.getBackgroundId())) {
				ideals.add(ideal);
			}
		}
		return ideals;		
	}

	public ObservableList<Bonds> populateBondData(Backgrounds background) {
		ObservableList<Bonds> bonds = FXCollections.observableArrayList();
		for (Bonds bond : Bonds.getBonds()) {
			if (bond.getBackgroundId().equals(background.getBackgroundId())) {
				bonds.add(bond);
			}
		}
		return bonds;		
	}

	public ObservableList<Flaws> populateFlawData(Backgrounds background) {
		ObservableList<Flaws> flaws = FXCollections.observableArrayList();
		for (Flaws flaw : Flaws.getFlaws()) {
			if (flaw.getBackgroundId().equals(background.getBackgroundId())) {
				flaws.add(flaw);
			}
		}
		return flaws;		
	}
}
