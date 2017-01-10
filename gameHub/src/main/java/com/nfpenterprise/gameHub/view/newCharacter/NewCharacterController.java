package com.nfpenterprise.gameHub.view.newCharacter;

import com.nfpenterprise.gameHub.Main;
import com.nfpenterprise.gameHub.character.dto.CharacterDto;
import com.nfpenterprise.gameHub.characterClass.dto.ClassDto;
import com.nfpenterprise.gameHub.race.dto.RaceDto;
import com.nfpenterprise.gameHub.race.dto.SubRaceDto;

import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.fxml.FXML;
import javafx.scene.control.SingleSelectionModel;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class NewCharacterController {

	private Main mainApp;
	private CharacterDto newCharacter;
	private SingleSelectionModel<Tab> tabSelectionModel;

	@FXML private TabPane tabs;
	@FXML private Tab raceTab;
	@FXML private Tab subRaceTab;
	@FXML private Tab classTab;
	@FXML private Tab backgorundTab;
	@FXML private Tab attributesTab;
	@FXML private Tab skillsTab;
	@FXML private TableView<RaceDto> racesTable;
    @FXML private TableColumn<RaceDto, String> racesColumn;
	@FXML private TableView<SubRaceDto> subRacesTable;
    @FXML private TableColumn<SubRaceDto, String> subRacesColumn;
	@FXML private TableView<ClassDto> classesTable;
    @FXML private TableColumn<ClassDto, String> classesColumn;

	public NewCharacterController() {
		
	}

	@FXML
	private void initialize() {
		newCharacter = new CharacterDto();
		newCharacter.setCharacterId(getUniqueId());
		tabSelectionModel = tabs.getSelectionModel();

		racesColumn.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getRaceName()));
		racesTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> showRaceDetails(newValue));
		subRacesColumn.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getSubRaceName()));
		subRacesTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> showSubRaceDetails(newValue));
		classesColumn.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getClassName()));
		classesTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> showClassDetails(newValue));
	}

	private Object showRaceDetails(RaceDto newValue) {
		// TODO Auto-generated method stub
		return null;
	}

	private Object showSubRaceDetails(SubRaceDto newValue) {
		// TODO Auto-generated method stub
		return null;
	}

	private Object showClassDetails(ClassDto newValue) {
		// TODO Auto-generated method stub
		return null;
	}

	private Integer getUniqueId() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setMainApp(Main main) {
		this.mainApp = main;
	}

    @FXML
    private void handleBack() {
    	tabSelectionModel.selectPrevious();
    }

	@FXML
    private void handleNext() {
		tabSelectionModel.selectNext();
		tabSelectionModel.getSelectedItem().setDisable(false);
    }

    @FXML
    private void handleFinish() {
//    	mainApp.getMyCharacterData().add(newCharacter);
        mainApp.showMyCharacters();
    }

    @FXML
    private void handleCancel() {
        mainApp.showMyCharacters();
    }
}
