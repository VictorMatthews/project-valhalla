package com.nfpenterprise.gameHub.view.newCharacter;

import com.nfpenterprise.gameHub.Main;
import com.nfpenterprise.gameHub.character.dto.CharacterDto;
import com.nfpenterprise.gameHub.constants.Backgrounds;
import com.nfpenterprise.gameHub.constants.Bonds;
import com.nfpenterprise.gameHub.constants.Classes;
import com.nfpenterprise.gameHub.constants.Flaws;
import com.nfpenterprise.gameHub.constants.Ideals;
import com.nfpenterprise.gameHub.constants.Message;
import com.nfpenterprise.gameHub.constants.PersonalityTraits;
import com.nfpenterprise.gameHub.constants.Races;
import com.nfpenterprise.gameHub.constants.SubRaces;
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
	ObservableList<Races> raceData;
	ObservableList<SubRaces> subRaceData;
	ObservableList<Classes> classData;

	@FXML private TabPane tabs;
	@FXML private Tab raceTab;
	@FXML private Tab subRaceTab;
	@FXML private Tab classTab;
	@FXML private Tab backgorundTab;
	@FXML private Tab attributesTab;
	@FXML private Tab skillsTab;
	@FXML private Tab spellsTab;
	@FXML private TableView<Races> racesTable;
    @FXML private TableColumn<Races, String> racesColumn;
	@FXML private TableView<SubRaces> subRacesTable;
    @FXML private TableColumn<SubRaces, String> subRacesColumn;
	@FXML private TableView<Classes> classesTable;
    @FXML private TableColumn<Classes, String> classesColumn;
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
		dataController = new DataController();

		racesColumn.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getRaceName()));
		racesTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> showRaceDetails(oldValue, newValue));
		subRacesColumn.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getSubRaceName()));
		subRacesTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> showSubRaceDetails(newValue));
		classesColumn.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getClassName()));
		classesTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> showClassDetails(newValue));

		racesTable.setItems(dataController.populateRaceData());
		racesTable.getSelectionModel().selectFirst();

		classesTable.setItems(dataController.populateClassData());
		classesTable.getSelectionModel().selectFirst();

		cmbBackground.setItems(dataController.populateBackgroundData());
		cmbBackground.getSelectionModel().selectFirst();
		refreshBackground(); 
	}

	private void showRaceDetails(Races oldRace, Races newRace) {
		// TODO Incomplete
		if (oldRace != null && !oldRace.equals(newRace) && !subRaceTab.isDisabled()) {
			disableTabs();
		}
	}

	private void showSubRaceDetails(SubRaces newSubRace) {
		// TODO Auto-generated method stub
	}

	private void showClassDetails(Classes newClass) {
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
			Races selectedRace = racesTable.getSelectionModel().selectedItemProperty().getValue();
			SubRaces selectedSubRace = subRacesTable.getSelectionModel().selectedItemProperty().getValue();
			Classes selectedClass = classesTable.getSelectionModel().selectedItemProperty().getValue();

			if (tabSelectionModel.getSelectedItem().equals(subRaceTab)) {
				subRacesTable.setItems(dataController.populateSubRaceData(selectedRace));
				subRacesTable.getSelectionModel().selectFirst();
			}

			if (selectedRace != null) {
				newCharacter.setRace(selectedRace.getRaceName());
			}
			newCharacter.setSpeed(selectedRace != null ? selectedRace.getRaceSpeed() : null);
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
    	Backgrounds background = cmbBackground.getSelectionModel().getSelectedItem();
    	if (background != null) {
    		cmbPersonalityTraits.setItems(dataController.populatePersonalityTraitData(background));
    		cmbPersonalityTraits.getSelectionModel().selectFirst();
    		cmbPersonalityTraits.setDisable(false);

    		cmbIdeals.setItems(dataController.populateIdealData(background));
    		cmbIdeals.getSelectionModel().selectFirst();
    		cmbIdeals.setDisable(false);

    		cmbBonds.setItems(dataController.populateBondData(background));
    		cmbBonds.getSelectionModel().selectFirst();
    		cmbBonds.setDisable(false);

    		cmbFlaws.setItems(dataController.populateFlawData(background));
    		cmbFlaws.getSelectionModel().selectFirst();
    		cmbFlaws.setDisable(false);
    	}
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
