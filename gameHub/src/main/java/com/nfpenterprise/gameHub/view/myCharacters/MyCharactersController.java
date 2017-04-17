package com.nfpenterprise.gameHub.view.myCharacters;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import com.google.api.services.drive.Drive;
import com.nfpenterprise.gameHub.Main;
import com.nfpenterprise.gameHub.character.dto.CharacterDto;
import com.nfpenterprise.gameHub.constants.Attributes;
import com.nfpenterprise.gameHub.util.AttributesSkillsUtil;
import com.nfpenterprise.gameHub.util.GoogleDriveExporter;

import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class MyCharactersController {
	protected AttributesSkillsUtil attributesSkillsUtil;

	@FXML
	protected TableView<CharacterDto> myCharacterTable;
	@FXML
	protected TableColumn<CharacterDto, String> characterNameColumn;

	@FXML
	protected TextField strengthTxt;
	@FXML
	protected TextField dexterityTxt;
	@FXML
	protected TextField constitutionTxt;
	@FXML
	protected TextField intelligenceTxt;
	@FXML
	protected TextField wisdomTxt;
	@FXML
	protected TextField charismaTxt;

	@FXML
	protected TextField raceTxt;
	@FXML
	protected TextField classTxt;

	@FXML
	protected Label personalityTraitLabel;
	@FXML
	protected Label idealLabel;
	@FXML
	protected Label bondLabel;
	@FXML
	protected Label flawLabel;

	@FXML
	protected Label acrobaticsIncrease;
	@FXML
	protected Label animalHandlingIncrease;
	@FXML
	protected Label arcanaIncrease;
	@FXML
	protected Label athleticsIncrease;
	@FXML
	protected Label deceptionIncrease;
	@FXML
	protected Label historyIncrease;
	@FXML
	protected Label insightIncrease;
	@FXML
	protected Label intimidationIncrease;
	@FXML
	protected Label investigationIncrease;
	@FXML
	protected Label medicineIncrease;
	@FXML
	protected Label natureIncrease;
	@FXML
	protected Label perceptionIncrease;
	@FXML
	protected Label performanceIncrease;
	@FXML
	protected Label persuasionIncrease;
	@FXML
	protected Label religionIncrease;
	@FXML
	protected Label sleightOfHandIncrease;
	@FXML
	protected Label stealthIncrease;
	@FXML
	protected Label survivalIncrease;

	@FXML
	protected RadioButton acrobaticsRadioButton;
	@FXML
	protected RadioButton animalHandlingRadioButton;
	@FXML
	protected RadioButton arcanaRadioButton;
	@FXML
	protected RadioButton athleticsRadioButton;
	@FXML
	protected RadioButton deceptionRadioButton;
	@FXML
	protected RadioButton historyRadioButton;
	@FXML
	protected RadioButton insightRadioButton;
	@FXML
	protected RadioButton intimidationRadioButton;
	@FXML
	protected RadioButton investigationRadioButton;
	@FXML
	protected RadioButton medicineRadioButton;
	@FXML
	protected RadioButton natureRadioButton;
	@FXML
	protected RadioButton perceptionRadioButton;
	@FXML
	protected RadioButton performanceRadioButton;
	@FXML
	protected RadioButton persuasionRadioButton;
	@FXML
	protected RadioButton religionRadioButton;
	@FXML
	protected RadioButton sleightOfHandRadioButton;
	@FXML
	protected RadioButton stealthRadioButton;
	@FXML
	protected RadioButton survivalRadioButton;

	protected Main mainApp;

	public MyCharactersController() {
	}

	@FXML
	protected void initialize() {
		// Initialize the character table with the character name.
		characterNameColumn
				.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getCharacterName()));

		// Listen for selection changes and show the person details when
		// changed.
		myCharacterTable.getSelectionModel().selectedItemProperty()
				.addListener((observable, oldValue, newValue) -> showCharacterDetails(newValue));

		attributesSkillsUtil = new AttributesSkillsUtil(acrobaticsIncrease, animalHandlingIncrease, arcanaIncrease,
				athleticsIncrease, deceptionIncrease, historyIncrease, insightIncrease, intimidationIncrease,
				investigationIncrease, medicineIncrease, natureIncrease, perceptionIncrease, performanceIncrease,
				persuasionIncrease, religionIncrease, sleightOfHandIncrease, stealthIncrease, survivalIncrease,
				acrobaticsRadioButton, animalHandlingRadioButton, arcanaRadioButton, athleticsRadioButton,
				deceptionRadioButton, historyRadioButton, insightRadioButton, intimidationRadioButton,
				investigationRadioButton, medicineRadioButton, natureRadioButton, perceptionRadioButton,
				performanceRadioButton, persuasionRadioButton, religionRadioButton, sleightOfHandRadioButton,
				stealthRadioButton, survivalRadioButton, strengthTxt, dexterityTxt, intelligenceTxt, wisdomTxt,
				charismaTxt, null /*remainingSkillChoices*/);
	}

	protected void showCharacterDetails(CharacterDto character) {
		if (character != null) {
			raceTxt.setText(character.getSubRace() == null ? character.getRace() == null ? "" : character.getRace() : character.getSubRace());
			classTxt.setText(character.getClassName() == null ? "" : character.getClassName());
			strengthTxt.setText(character.getStrength().toString());
			dexterityTxt.setText(character.getDexterity().toString());
			constitutionTxt.setText(character.getConstitution().toString());
			intelligenceTxt.setText(character.getIntelligence().toString());
			wisdomTxt.setText(character.getWisdom().toString());
			charismaTxt.setText(character.getCharisma().toString());
			personalityTraitLabel.setText(character.getPersonalityTrait());
			idealLabel.setText(character.getIdeals());
			bondLabel.setText(character.getBonds());
			flawLabel.setText(character.getFlaws());

			attributesSkillsUtil.updateSkills(Attributes.STRENGTH);
			attributesSkillsUtil.updateSkills(Attributes.DEXTERITY);
			attributesSkillsUtil.updateSkills(Attributes.INTELLIGENCE);
			attributesSkillsUtil.updateSkills(Attributes.WISDOM);
			attributesSkillsUtil.updateSkills(Attributes.CHARISMA);

			attributesSkillsUtil.handleSkills(0, character);
		}
	}

	@FXML
	protected void handleNewCharacter() {
		mainApp.showNewCharacterMain(false, null);
	}

	@FXML
	protected void handleEditCharacter() {
		CharacterDto selectedCharacter = null;
		if (myCharacterTable != null && myCharacterTable.getSelectionModel() != null) {
			selectedCharacter = myCharacterTable.getSelectionModel().getSelectedItem();
		}
		if (selectedCharacter != null) {
			mainApp.showNewCharacterMain(true, selectedCharacter);
		}
	}

	@FXML
	protected void handleDeleteCharacter() {
		if (myCharacterTable != null && myCharacterTable.getSelectionModel() != null) {
			int selectedIndex = myCharacterTable.getSelectionModel().getSelectedIndex();
			myCharacterTable.getItems().remove(selectedIndex);
		}
	}

	@FXML
	protected void handleExportCharacter() {
		if (mainApp != null && mainApp.getCharactersFile() != null) {
			File characterXml = mainApp.getCharactersFile();

			final ExecutorService executor = Executors.newFixedThreadPool(2);

			Task<Integer> task = new Task<Integer>() {
				@Override
				protected Integer call() throws Exception {
					Future<?> googleDriveService = executor.submit(new Callable<Drive>() {
						@Override
						public Drive call() throws IOException {
							return GoogleDriveExporter.getDriveService();
						}
					});

					try {
						final Drive drive = (Drive) googleDriveService.get(20, TimeUnit.SECONDS);

						Future<?> upload = executor.submit(new Callable<String>() {
							@Override
							public String call() throws IOException, URISyntaxException {
								String webViewURL = GoogleDriveExporter.exportXmlFileToGoogleDrive(drive, characterXml);
								Desktop.getDesktop().browse(new URI(webViewURL));
								return null;
							}
						});
						upload.get();

					} catch (TimeoutException e) {
						e.printStackTrace();
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						googleDriveService.cancel(true);
						executor.shutdown();
					}
					return null;
				}
			};
			executor.execute(task);
		}
	}

	public void setMainApp(Main main) {
		this.mainApp = main;

		// Add observable list data to the table
		if (myCharacterTable != null && mainApp != null) {
			myCharacterTable.setItems(mainApp.getMyCharacterData());
		}
	}

	public void loadCharacter(CharacterDto character) {
		myCharacterTable.getSelectionModel().select(character);		
	}

}
