package com.nfpenterprise.gameHub.constants;

public enum Paths {
	APPLICATION_ICON("file:src/main/resources/images/Project_Valhalla.png"),

	MY_CHARACTER_DATA("file/Characters.xml"),
	HTML_TEST("file/HtmlTest.html"),

	ROOT_LAYOUT_FXML("view/RootLayout.fxml"),
	NEW_CHARACTER_MAIN_FXML("view/newCharacter/NewCharacterMain.fxml"),
	NEW_CHARACTER_DYNAMIC_FXML("view/newCharacter/NewCharacterDynamicSteps.fxml"),
	MY_CHARACTERS_FXML("view/myCharacters/MyCharacters.fxml");
	
	private final String path;

	Paths(String path) {
		this.path = path;
	}
	
	public String getPath() {
		return path;
	}

}
