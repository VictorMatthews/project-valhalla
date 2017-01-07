package com.nfpenterprise.gameHub.constants;

public enum Paths {
	APPLICATION_ICON("file:resources/images/Project_Valhalla.png"),
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
