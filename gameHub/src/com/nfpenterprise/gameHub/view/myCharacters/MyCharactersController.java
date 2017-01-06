package com.nfpenterprise.gameHub.view.myCharacters;

import com.nfpenterprise.gameHub.Main;

import javafx.fxml.FXML;

public class MyCharactersController {

	private Main mainApp;

	/**
     * Called when the user clicks the new button.
     */
    @FXML
    private void handleNewCharacter() {
        mainApp.showNewCharacterMain();
    }

	public void setMainApp(Main main) {
		this.mainApp = main;
	}

}
