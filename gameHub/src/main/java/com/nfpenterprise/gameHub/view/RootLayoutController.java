package com.nfpenterprise.gameHub.view;

import java.io.File;

import com.nfpenterprise.gameHub.Main;

import javafx.fxml.FXML;
import javafx.stage.FileChooser;

public class RootLayoutController {

	private Main mainApp;

    @FXML
    public void handleSave() {
        File charactersFile = mainApp.getCharactersFilePath();
        if (charactersFile != null) {
            mainApp.saveCharacterDataToFile(charactersFile);
        } else {
            handleSaveAs();
        }
    }

    @FXML
    private void handleSaveAs() {
        FileChooser fileChooser = new FileChooser();

        // Set extension filter
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter(
                "XML files (*.xml)", "*.xml");
        fileChooser.getExtensionFilters().add(extFilter);

        // Show save file dialog
        File file = fileChooser.showSaveDialog(mainApp.getPrimaryStage());

        if (file != null) {
            // Make sure it has the correct extension
            if (!file.getPath().endsWith(".xml")) {
                file = new File(file.getPath() + ".xml");
            }
            mainApp.saveCharacterDataToFile(file);
        }
    }

	public void setMainApp(Main main) {
		this.mainApp = main;
	}
}
