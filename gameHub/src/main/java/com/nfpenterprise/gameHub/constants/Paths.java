package com.nfpenterprise.gameHub.constants;

public enum Paths {
	APPLICATION_ICON("file:src/main/resources/images/Project_Valhalla.png"),
	MY_CHARACTER_DATA("file/Characters.xml"),
	NEW_CHARACTER_STEPS_DATA("file/NewCharacterSteps.xml"),
	ROOT_LAYOUT_FXML("view/RootLayout.fxml"),
	NEW_CHARACTER_MAIN_FXML("view/newCharacter/NewCharacterMain.fxml"),
	MY_CHARACTERS_FXML("view/myCharacters/MyCharacters.fxml");
	
	private final String path;

	Paths(String path) {
		this.path = path;
	}
	
	public String getPath() {
		return path;
	}

}
