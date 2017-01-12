package com.nfpenterprise.gameHub.view.newCharacter;

import com.nfpenterprise.gameHub.Main;
import com.nfpenterprise.gameHub.character.dto.CharacterDto;
import com.nfpenterprise.gameHub.characterClass.dto.ClassDto;
import com.nfpenterprise.gameHub.constants.Backgrounds;
import com.nfpenterprise.gameHub.constants.Bonds;
import com.nfpenterprise.gameHub.constants.Flaws;
import com.nfpenterprise.gameHub.constants.Ideals;
import com.nfpenterprise.gameHub.constants.Message;
import com.nfpenterprise.gameHub.constants.PersonalityTraits;
import com.nfpenterprise.gameHub.race.dto.RaceDto;
import com.nfpenterprise.gameHub.race.dto.SubRaceDto;
import com.nfpenterprise.gameHub.util.DataController;

import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.SingleSelectionModel;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class NewCharacterController {

	private Main mainApp;
	private CharacterDto newCharacter;
	private SingleSelectionModel<Tab> tabSelectionModel;
	private DataController dataController;
	ObservableList<RaceDto> raceData;
	ObservableList<SubRaceDto> subRaceData;
	ObservableList<ClassDto> classData;

	@FXML private TabPane tabs;
	@FXML private Tab raceTab;
	@FXML private Tab subRaceTab;
	@FXML private Tab classTab;
	@FXML private Tab backgorundTab;
	@FXML private Tab attributesTab;
	@FXML private Tab skillsTab;
	@FXML private Tab spellsTab;
	@FXML private TableView<RaceDto> racesTable;
    @FXML private TableColumn<RaceDto, String> racesColumn;
	@FXML private TableView<SubRaceDto> subRacesTable;
    @FXML private TableColumn<SubRaceDto, String> subRacesColumn;
	@FXML private TableView<ClassDto> classesTable;
    @FXML private TableColumn<ClassDto, String> classesColumn;
	@FXML private ComboBox<Backgrounds> cmbBackground;
	@FXML private ComboBox<PersonalityTraits> cmbPersonalityTraits;
	@FXML private ComboBox<Ideals> cmbIdeals;
	@FXML private ComboBox<Bonds> cmbBonds;
	@FXML private ComboBox<Flaws> cmbFlaws;

	public NewCharacterController() {
		
	}

	@FXML
	private void initialize() {
		newCharacter = new CharacterDto();
		newCharacter.setCharacterId(getUniqueId());
		tabSelectionModel = tabs.getSelectionModel();

		racesColumn.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getRaceName()));
		racesTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> showRaceDetails(oldValue, newValue));
		subRacesColumn.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getSubRaceName()));
		subRacesTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> showSubRaceDetails(newValue));
		classesColumn.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getClassName()));
		classesTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> showClassDetails(newValue));

		dataController = new DataController();
		racesTable.setItems(dataController.populateRaceData());
		classesTable.setItems(dataController.populateClassData());
	}

	private void showRaceDetails(RaceDto oldRace, RaceDto newRace) {
		// TODO Incomplete
		if (oldRace != null && !oldRace.equals(newRace) && !subRaceTab.isDisabled()) {
			disableTabs();
		}
	}

	private void showSubRaceDetails(SubRaceDto newValue) {
		// TODO Auto-generated method stub
	}

	private void showClassDetails(ClassDto newValue) {
		// TODO Auto-generated method stub
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
		if (verifyNext()) {
			tabSelectionModel.selectNext();
			tabSelectionModel.getSelectedItem().setDisable(false);
		}
    }

	private boolean verifyNext() {
		// TODO Not Finished
		if (tabSelectionModel.getSelectedItem().equals(raceTab) && racesTable.getSelectionModel().selectedItemProperty().getValue() == null) {
			screenNotCompleteError(Message.MUST_COMPLETE_RACE);
			return false;
		}
		if (tabSelectionModel.getSelectedItem().equals(subRaceTab) && subRacesTable.getSelectionModel().selectedItemProperty().getValue() == null) {
			screenNotCompleteError(Message.MUST_COMPLETE_SUB_RACE);
			return false;
		}
		if (tabSelectionModel.getSelectedItem().equals(classTab) && classesTable.getSelectionModel().selectedItemProperty().getValue() == null) {
			screenNotCompleteError(Message.MUST_COMPLETE_CLASS);
			return false;
		}
		return true;
	}

	@FXML
    private void handleTabSelection() {
		// TODO Not Finished
		if (tabSelectionModel != null) {
			RaceDto selectedRace = racesTable.getSelectionModel().selectedItemProperty().getValue();
			SubRaceDto selectedSubRace = subRacesTable.getSelectionModel().selectedItemProperty().getValue();
			ClassDto selectedClass = classesTable.getSelectionModel().selectedItemProperty().getValue();

			if (tabSelectionModel.getSelectedItem().equals(subRaceTab)) {
				subRacesTable.setItems(dataController.populateSubRaceData(selectedRace));
			}

			newCharacter.setRace(selectedRace != null ? selectedRace.getRaceName() : null);
			newCharacter.setSpeed(selectedRace != null ? selectedRace.getSpeed() : null);
			newCharacter.setSubRace(selectedSubRace != null ? selectedSubRace.getSubRaceName() : null);
			newCharacter.setClassName(selectedClass != null ? selectedClass.getClassName() : null);
		}
	}

    @FXML
    private void handleFinish() {
		// TODO Not Finished
//    	mainApp.getMyCharacterData().add(newCharacter);
        mainApp.showMyCharacters();
    }

    @FXML
    private void handleCancel() {
        mainApp.showMyCharacters();
    }

    @FXML
    private void refreshBackground() {
		// TODO Auto-generated method stub
    }

    private void screenNotCompleteError(Message message) {
    	//TODO this should go in a util class!
    	Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("ERROR");
        alert.setHeaderText("Can not continue, screen is not complete");
        alert.setContentText(message.toString());
        alert.showAndWait();
    }

	private void disableTabs() {
		subRaceTab.setDisable(true);
		classTab.setDisable(true);
		backgorundTab.setDisable(true);
		attributesTab.setDisable(true);
		skillsTab.setDisable(true);
		spellsTab.setDisable(true);
	}
}
