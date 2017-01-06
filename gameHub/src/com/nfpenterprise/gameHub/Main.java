package com.nfpenterprise.gameHub;

import java.io.File;
import java.io.IOException;
import java.util.prefs.Preferences;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.nfpenterprise.gameHub.character.collection.CharacterWrapper;
import com.nfpenterprise.gameHub.character.dto.CharacterDto;
import com.nfpenterprise.gameHub.constants.Field;
import com.nfpenterprise.gameHub.constants.Paths;
import com.nfpenterprise.gameHub.view.RootLayoutController;
import com.nfpenterprise.gameHub.view.myCharacters.MyCharactersController;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {

	private Stage primaryStage;
	private BorderPane rootLayout;
	private RootLayoutController mainController;

    private ObservableList<CharacterDto> myCharacters = FXCollections.observableArrayList();

    public ObservableList<CharacterDto> getMyCharacterData() {
        return myCharacters;
    }

	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle(Field.APPLICATION_NAME.toString());

		initRootLayout();

		myCharacters.add(mainController.createTestCharacterData());

		showMyCharacters();
	}

    public Stage getPrimaryStage() {
        return primaryStage;
    }

	public static void main(String[] args) {
		launch(args);
	}

    public File getCharactersFilePath() {
        Preferences prefs = Preferences.userNodeForPackage(Main.class);
        String filePath = prefs.get("filePath", null);
        if (filePath != null) {
            return new File(filePath);
        } else {
            return null;
        }
    }

	public void initRootLayout() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource(Paths.ROOT_LAYOUT_FXML.getPath()));
			rootLayout = (BorderPane) loader.load();
			mainController = loader.getController();
			mainController.setMainApp(this);

			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void showMyCharacters() {
		try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource(Paths.MY_CHARACTERS_FXML.getPath()));
            AnchorPane myCharactersPane = (AnchorPane) loader.load();

            // Set person overview into the center of root layout.
            rootLayout.setCenter(myCharactersPane);

            //Give the controller access to the main app.
            MyCharactersController controller = loader.getController();
            controller.setMainApp(this);

        } catch (IOException e) {
            e.printStackTrace();
        }
	}

	public void showNewCharacterMain() {
		try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource(Paths.NEW_CHARACTER_MAIN_FXML.getPath()));
            AnchorPane newCharacterPane = (AnchorPane) loader.load();

            // Set person overview into the center of root layout.
            rootLayout.setCenter(newCharacterPane);

//            Give the controller access to the main app.
//            NewCharacterController controller = loader.getController();
//            controller.setMainApp(this);

        } catch (IOException e) {
            e.printStackTrace();
        }
	}
    
    public void loadCharacterDataFromFile(File file) {
        try {
            JAXBContext context = JAXBContext
                    .newInstance(CharacterWrapper.class);
            Unmarshaller um = context.createUnmarshaller();

            // Reading XML from the file and unmarshalling.
            CharacterWrapper wrapper = (CharacterWrapper) um.unmarshal(file);

            myCharacters.clear();
            myCharacters.addAll(wrapper.getCharacters());

            // Save the file path to the registry.
            setCharacterFilePath(file);

        } catch (Exception e) { // catches ANY exception
        	Alert alert = couldNotLoadDataError(file);
        	alert.showAndWait();
        }
    }

	public void saveCharacterDataToFile(File file) {
        try {
        	if (!myCharacters.isEmpty()) {
	            JAXBContext context = JAXBContext
	                    .newInstance(CharacterWrapper.class);
	            Marshaller m = context.createMarshaller();
	            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
	
	            // Wrapping our person data.
	            CharacterWrapper wrapper = new CharacterWrapper();
	            wrapper.setCharacters(myCharacters);
	
	            // Marshalling and saving XML to the file.
	            m.marshal(wrapper, file);
	
	            // Save the file path to the registry.
	            setCharacterFilePath(file);
        	}
        } catch (Exception e) { // catches ANY exception
            Alert alert = couldNotLoadDataError(file);
            alert.showAndWait();
        }
    }

    public void setCharacterFilePath(File file) {
        Preferences prefs = Preferences.userNodeForPackage(Main.class);
        if (file != null) {
            prefs.put("filePath", file.getPath());

            // Update the stage title.
            primaryStage.setTitle(Field.APPLICATION_NAME.toString() + file.getName());
        } else {
            prefs.remove("filePath");

            // Update the stage title.
            primaryStage.setTitle(Field.APPLICATION_NAME.toString());
        }
    }
    
    private Alert couldNotLoadDataError(File file) {
    	Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Could not save data");
        alert.setContentText("Could not save data to file:\n" + file.getPath());
        return alert;
    }

    @Override
    public void stop(){
    	mainController.handleSave();
    }

}
