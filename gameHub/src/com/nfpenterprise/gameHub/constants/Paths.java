package com.nfpenterprise.gameHub.constants;

public enum Paths {
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
