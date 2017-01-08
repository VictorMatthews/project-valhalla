package com.nfpenterprise.gameHub.util;

import java.io.File;
import java.util.prefs.Preferences;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.nfpenterprise.gameHub.Main;
import com.nfpenterprise.gameHub.character.collection.CharactersWrapper;
import com.nfpenterprise.gameHub.character.steps.collection.StepsWrapper;
import com.nfpenterprise.gameHub.constants.Paths;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class WrapperController {

	private Main mainApp;
	
	public WrapperController(Main mainApp) {
		this.mainApp = mainApp;
	}

    public void loadCharacterDataFromFile(File file) {
        try {
            JAXBContext context = JAXBContext.newInstance(CharactersWrapper.class);
            Unmarshaller um = context.createUnmarshaller();

            // Reading XML from the file and unmarshalling.
            CharactersWrapper wrapper = (CharactersWrapper) um.unmarshal(file);

            mainApp.getMyCharacterData().clear();
            mainApp.getMyCharacterData().addAll(wrapper.getCharacters());

            // Save the file path to the registry.
            setCharacterFilePath(file);

        } catch (Exception e) { // catches ANY exception
        	Alert alert = couldNotLoadData(file);
        	alert.showAndWait();
        }
    }

	public void saveCharacterDataToFile(File file) {
        try {
        	if (!mainApp.getMyCharacterData().isEmpty()) {
	            JAXBContext context = JAXBContext.newInstance(CharactersWrapper.class);
	            Marshaller m = context.createMarshaller();
	            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
	
	            // Wrapping our person data.
	            CharactersWrapper wrapper = new CharactersWrapper();
	            wrapper.setCharacters(mainApp.getMyCharacterData());
	
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

    public void loadNewCharacterStepsDataFromFile() {
        File file = new File(Main.class.getClassLoader().getResource(Paths.NEW_CHARACTER_STEPS_DATA.getPath()).getFile());
        try {
            JAXBContext context = JAXBContext.newInstance(StepsWrapper.class);
            Unmarshaller um = context.createUnmarshaller();

            // Reading XML from the file and unmarshalling.
            StepsWrapper wrapper = (StepsWrapper) um.unmarshal(file);

            mainApp.getNewCharacterStepsData().clear();
            mainApp.getNewCharacterStepsData().addAll(wrapper.getSteps());
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
