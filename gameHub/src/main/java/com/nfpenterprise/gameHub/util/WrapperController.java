package com.nfpenterprise.gameHub.util;

import java.io.File;
import java.util.prefs.Preferences;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.nfpenterprise.gameHub.Main;
import com.nfpenterprise.gameHub.character.collection.CharactersWrapper;
import com.nfpenterprise.gameHub.character.dto.CharacterDto;
import com.nfpenterprise.gameHub.characterClass.collection.ClassesWrapper;
import com.nfpenterprise.gameHub.characterClass.dto.ClassDto;
import com.nfpenterprise.gameHub.constants.Paths;
import com.nfpenterprise.gameHub.race.collection.RacesWrapper;
import com.nfpenterprise.gameHub.race.collection.SubRacesWrapper;
import com.nfpenterprise.gameHub.race.dto.RaceDto;
import com.nfpenterprise.gameHub.race.dto.SubRaceDto;

import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class WrapperController {

	
	public WrapperController() {
	}

    public void loadCharacterDataFromFile(File file, ObservableList<CharacterDto> characterData) {
        try {
            JAXBContext context = JAXBContext.newInstance(CharactersWrapper.class);
            Unmarshaller um = context.createUnmarshaller();

            // Reading XML from the file and unmarshalling.
            CharactersWrapper wrapper = (CharactersWrapper) um.unmarshal(file);

            characterData.clear();
            characterData.addAll(wrapper.getCharacters());

            // Save the file path to the registry.
            setCharacterFilePath(file);

        } catch (Exception e) { // catches ANY exception
        	Alert alert = couldNotLoadData(file);
        	alert.showAndWait();
        }
    }

	public void saveCharacterDataToFile(File file, ObservableList<CharacterDto> characterData) {
        try {
        	if (!characterData.isEmpty()) {
	            JAXBContext context = JAXBContext.newInstance(CharactersWrapper.class);
	            Marshaller m = context.createMarshaller();
	            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
	
	            // Wrapping our person data.
	            CharactersWrapper wrapper = new CharactersWrapper();
	            wrapper.setCharacters(characterData);
	
	            // Marshalling and saving XML to the file.
	            m.marshal(wrapper, file);
	
	            // Save the file path to the registry.
	            setCharacterFilePath(file);
        	}
        } catch (Exception e) { // catches ANY exception
        	Alert alert = couldNotSaveData(file);
            alert.showAndWait();
        }
    }

    public void loadRaceDataFromFile(ObservableList<RaceDto> raceData) {
        File file = new File(Main.class.getClassLoader().getResource(Paths.RACE_DATA.getPath()).getFile());
        try {
            JAXBContext context = JAXBContext.newInstance(RacesWrapper.class);
            Unmarshaller um = context.createUnmarshaller();

            // Reading XML from the file and unmarshalling.
            RacesWrapper wrapper = (RacesWrapper) um.unmarshal(file);

            raceData.clear();
            raceData.addAll(wrapper.getRaces());
        } catch (Exception e) { // catches ANY exception
        	Alert alert = couldNotLoadData(file);
        	alert.showAndWait();
        }
    }

    public void loadSubRaceDataFromFile(ObservableList<SubRaceDto> subRaceData) {
        File file = new File(Main.class.getClassLoader().getResource(Paths.SUB_RACE_DATA.getPath()).getFile());
        try {
            JAXBContext context = JAXBContext.newInstance(SubRacesWrapper.class);
            Unmarshaller um = context.createUnmarshaller();

            // Reading XML from the file and unmarshalling.
            SubRacesWrapper wrapper = (SubRacesWrapper) um.unmarshal(file);

            subRaceData.clear();
            subRaceData.addAll(wrapper.getSubRaces());
        } catch (Exception e) { // catches ANY exception
        	Alert alert = couldNotLoadData(file);
        	alert.showAndWait();
        }
    }

    public void loadClassDataFromFile(ObservableList<ClassDto> classData) {
        File file = new File(Main.class.getClassLoader().getResource(Paths.CLASS_DATA.getPath()).getFile());
        try {
            JAXBContext context = JAXBContext.newInstance(ClassesWrapper.class);
            Unmarshaller um = context.createUnmarshaller();

            // Reading XML from the file and unmarshalling.
            ClassesWrapper wrapper = (ClassesWrapper) um.unmarshal(file);

            classData.clear();
            classData.addAll(wrapper.getClasses());
        } catch (Exception e) { // catches ANY exception
        	Alert alert = couldNotLoadData(file);
        	alert.showAndWait();
        }
    }

    public void setCharacterFilePath(File file) {
        Preferences prefs = Preferences.userNodeForPackage(Main.class);
        if (file != null) {
            prefs.put("filePath", file.getPath());
        } else {
            prefs.remove("filePath");
        }
    }

    private Alert couldNotLoadData(File file) {
    	Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Could not load data");
        alert.setContentText("Could not load data to file:\n" + file.getPath());
        return alert;
    }

    private Alert couldNotSaveData(File file) {
    	Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Could not save data");
        alert.setContentText("Could not save data to file:\n" + file.getPath());
        return alert;
    }
}
