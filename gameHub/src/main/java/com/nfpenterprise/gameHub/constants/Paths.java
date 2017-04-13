package com.nfpenterprise.gameHub.constants;

public enum Paths {
	APPLICATION_ICON("file:src/main/resources/images/Project_Valhalla.png"),

	MY_CHARACTER_DATA("save/Characters.xml"),

	DWARF_HTML("file/races/Dwarf.html"),
	ELF_HTML("file/races/Elf.html"),
	HALFLING_HTML("file/races/Halfling.html"),
	HUMAN_HTML("file/races/Human.html"),
	DRAGONBORN_HTML("file/races/Dragonborn.html"),
	GNOME_HTML("file/races/Gnome.html"),
	HALF_ELF_HTML("file/races/HalfElf.html"),
	HALF_ORC_HTML("file/races/HalfOrc.html"),
	TIEFLING_HTML("file/races/Tiefling.html"),
	HILL_DWARF_HTML("file/races/HillDwarf.html"),
	MOUNTAIN_DWARF_HTML("file/races/MountainDwarf.html"),
	HIGH_ELF_HTML("file/races/HighElf.html"),
	WOOD_ELF_HTML("file/races/WoodElf.html"),
	DARK_ELF_HTML("file/races/DarkElf.html"),
	LIGHT_FOOT_HALFLING_HTML("file/races/LightfootHalfling.html"),
	STOUT_HALFLING_HTML("file/races/StoutHalfling.html"),
	ROCK_GNOME_HTML("file/races/RockGnome.html"),
	FOREST_GNOME_HTML("file/races/ForestGnome.html"),
	BARBARIAN_HTML("file/classes/Barbarian.html"),
	BARD_HTML("file/classes/Bard.html"),
	CLERIC_HTML("file/classes/Cleric.html"),
	DRUID_HTML("file/classes/Druid.html"),
	FIGHTER_HTML("file/classes/Fighter.html"),
	MONK_HTML("file/classes/Monk.html"),
	PALADIN_HTML("file/classes/Paladin.html"),
	RANGER_HTML("file/classes/Ranger.html"),
	ROGUE_HTML("file/classes/Rogue.html"),
	SORCERER_HTML("file/classes/Sorcerer.html"),
	WARLOCK_HTML("file/classes/Warlock.html"),
	WIZARD_HTML("file/classes/Wizard.html"),

	ROOT_LAYOUT_FXML("view/RootLayout.fxml"),
	NEW_CHARACTER_MAIN_FXML("view/newCharacter/NewCharacterMain.fxml"),
	NEW_CHARACTER_DYNAMIC_FXML("view/newCharacter/NewCharacterDynamicSteps.fxml"),
	MY_CHARACTERS_FXML("view/myCharacters/MyCharacters.fxml"),

	CLIENT_SECRET("/client_secret.json"),
	OAUTH_TOKEN(".projectValhallaOauthToken/drive-export.json"),
	USER_HOME_DIR("user.home");
	
	
	private final String path;

	Paths(String path) {
		this.path = path;
	}
	
	public String getPath() {
		return path;
	}

}
