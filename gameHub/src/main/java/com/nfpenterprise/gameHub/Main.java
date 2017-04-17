package com.nfpenterprise.gameHub;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.prefs.Preferences;

import com.nfpenterprise.gameHub.character.dto.CharacterDto;
import com.nfpenterprise.gameHub.constants.Field;
import com.nfpenterprise.gameHub.constants.Paths;
import com.nfpenterprise.gameHub.util.WrapperController;
import com.nfpenterprise.gameHub.view.RootLayoutController;
import com.nfpenterprise.gameHub.view.myCharacters.MyCharactersController;
import com.nfpenterprise.gameHub.view.newCharacter.NewCharacterController;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {

	private Stage primaryStage;
	private BorderPane rootLayout;
	private RootLayoutController mainController;
	private WrapperController wrapperController;

    private ObservableList<CharacterDto> myCharacters = FXCollections.observableArrayList();

    public ObservableList<CharacterDto> getMyCharacterData() {
        return myCharacters;
    }

	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle(Field.APPLICATION_NAME.toString());
        this.primaryStage.getIcons().add(new Image(Paths.APPLICATION_ICON.getPath()));

		initRootLayout();

		showMyCharacters(null);
		wrapperController = new WrapperController();
		File file = getCharactersFile();
        if (file != null) {
        	wrapperController.loadCharacterDataFromFile(file, myCharacters);
        }
	}

	public Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void main(String[] args) {
		setupIfRunningOnMac();
		launch(args);
	}

	private static void setupIfRunningOnMac() {
		String osName = System.getProperty("os.name").toLowerCase();
		boolean isMacOs = osName.startsWith("mac os x");
		if (isMacOs) {
			//Set Mac Menubar Application Name
			System.setProperty("apple.laf.useScreenMenuBar", "true");
			System.setProperty("com.apple.mrj.application.apple.menu.about.name", Field.APPLICATION_NAME.toString());
		}
	}

    public File getCharactersFile() {
        Preferences prefs = Preferences.userNodeForPackage(Main.class);
        String filePath = prefs.get("filePath", null);
    	URL characterUrlFromResources = Main.class.getClassLoader().getResource(Paths.MY_CHARACTER_DATA.getPath());
        if (filePath != null) {
            return new File(filePath);
        } else if (characterUrlFromResources != null) {
        	return new File(characterUrlFromResources.getFile());
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

	public void showMyCharacters(CharacterDto character) {
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
            if (character != null) {
            	controller.loadCharacter(character);
            }

    		this.primaryStage.setTitle(Field.APPLICATION_NAME.toString() + " - " + Field.MY_CHARACTERS.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
	}

	public void showNewCharacterMain(boolean isEdit, CharacterDto characterToEdit) {
		try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource(Paths.NEW_CHARACTER_MAIN_FXML.getPath()));
            AnchorPane newCharacterPane = (AnchorPane) loader.load();

            // Set person overview into the center of root layout.
            rootLayout.setCenter(newCharacterPane);

            //Give the controller access to the main app.
            NewCharacterController controller = loader.getController();
            controller.setMainApp(this);
            if (isEdit) {
            	controller.loadCharacter(characterToEdit);
            }

    		this.primaryStage.setTitle(Field.APPLICATION_NAME.toString() + " - " + Field.NEW_CHARACTER.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
	}

	public void saveCharacterDataToFile(File file) {
    	wrapperController.saveCharacterDataToFile(file, myCharacters);
	}

    @Override
    public void stop(){
    	if (myCharacters.isEmpty() && getCharactersFile() != null) {
    		getCharactersFile().deleteOnExit();
    	} else {
    		mainController.handleSave();
    	}
    }

}
