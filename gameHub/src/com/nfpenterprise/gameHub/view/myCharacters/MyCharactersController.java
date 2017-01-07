package com.nfpenterprise.gameHub.view.myCharacters;

import com.nfpenterprise.gameHub.Main;
import com.nfpenterprise.gameHub.character.dto.CharacterDto;

import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class MyCharactersController {

    @FXML
    private TableView<CharacterDto> myCharacterTable;
    @FXML
    private TableColumn<CharacterDto, String> characterNameColumn;

	private Main mainApp;

	public MyCharactersController() {
		
	}

	@FXML
	private void initialize() {
	    // Initialize the character table with the character name.
		characterNameColumn.setCellValueFactory(
	            cellData -> new ReadOnlyStringWrapper(cellData.getValue().getCharacterName()));

	    // Clear person details.
	    showCharacterDetails(null);

	    // Listen for selection changes and show the person details when changed.
	    myCharacterTable.getSelectionModel().selectedItemProperty().addListener(
	            (observable, oldValue, newValue) -> showCharacterDetails(newValue));
	}

	private void showCharacterDetails(Object object) {
		// TODO Auto-generated method stub
		
	}

	/**
     * Called when the user clicks the new button.
     */
    @FXML
    private void handleNewCharacter() {
        mainApp.showNewCharacterMain();
    }

	public void setMainApp(Main main) {
		this.mainApp = main;

        // Add observable list data to the table
		myCharacterTable.setItems(mainApp.getMyCharacterData());
	}

}
