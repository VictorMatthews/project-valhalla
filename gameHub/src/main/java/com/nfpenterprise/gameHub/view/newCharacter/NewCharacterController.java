package com.nfpenterprise.gameHub.view.newCharacter;

import com.nfpenterprise.gameHub.Main;
import com.nfpenterprise.gameHub.character.steps.dto.StepsDto;

import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class NewCharacterController {

    @FXML
    private TableView<StepsDto> stepsTable;
    @FXML
    private TableColumn<StepsDto, String> stepsColumn;

    @FXML
    private TableView<Object> stepsDynamicTable;
    @FXML
    private TableColumn<Object, String> stepsDynamicColumn;

	private Main mainApp;

	public NewCharacterController() {
		
	}

    @FXML
    private void handleCancel() {
        mainApp.showMyCharacters();
    }

	@FXML
	private void initialize() {
	    // Initialize the character table with the character name.
		stepsColumn.setCellValueFactory(
	            cellData -> new ReadOnlyStringWrapper(cellData.getValue().getStepText()));

	    // Clear steps details.
	    populateDynamicTable(null);

	    // Listen for selection changes and show the person details when changed.
	    stepsTable.getSelectionModel().selectedItemProperty().addListener(
	            (observable, oldValue, newValue) -> populateDynamicTable(newValue));
	}

    private void populateDynamicTable(Object object) {
		// TODO Auto-generated method stub
		
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
		stepsTable.setItems(mainApp.getNewCharacterStepsData());
	}
}
