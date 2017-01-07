package com.nfpenterprise.gameHub.view.newCharacter;

import com.nfpenterprise.gameHub.Main;

import javafx.fxml.FXML;

public class NewCharacterController {

	private Main mainApp;

	public NewCharacterController() {
		
	}

    @FXML
    private void handleCancel() {
        mainApp.showMyCharacters();
    }

    @FXML
    private void handleNext() {
    }

    @FXML
    private void handleBack() {
    }

    @FXML
    private void handleFinish() {
    }

	public void setMainApp(Main main) {
		this.mainApp = main;
	}
}
