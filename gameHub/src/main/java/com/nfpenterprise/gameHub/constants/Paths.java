package com.nfpenterprise.gameHub.constants;

public enum Paths {
	APPLICATION_ICON("file:src/main/resources/images/Project_Valhalla.png"),

	MY_CHARACTER_DATA("save/Characters.xml"),

	DWARF_HTML("file/Dwarf.html"),
	ELF_HTML("file/Elf.html"),
	HALFLING_HTML("file/Halfling.html"),
	HUMAN_HTML("file/Human.html"),
	DRAGONBORN_HTML("file/Dragonborn.html"),
	GNOME_HTML("file/Gnome.html"),
	HALF_ELF_HTML("file/HalfElf.html"),
	HALF_ORC_HTML("file/HalfOrc.html"),
	TIEFLING_HTML("file/Tiefling.html"),
	HILL_DWARF_HTML("file/HillDwarf.html"),
	MOUNTAIN_DWARF_HTML("file/MountainDwarf.html"),
	HIGH_ELF_HTML("file/HighElf.html"),
	WOOD_ELF_HTML("file/WoodElf.html"),
	DARK_ELF_HTML("file/DarkElf.html"),
	LIGHT_FOOT_HALFLING_HTML("file/LightfootHalfling.html"),
	STOUT_HALFLING_HTML("file/StoutHalfling.html"),
	ROCK_GNOME_HTML("file/RockGnome.html"),
	FOREST_GNOME_HTML("file/ForestGnome.html"),
	BARBARIAN_HTML("file/Barbarian.html"),
	BARD_HTML("file/Bard.html"),
	CLERIC_HTML("file/Cleric.html"),
	DRUID_HTML("file/Druid.html"),
	FIGHTER_HTML("file/Fighter.html"),
	MONK_HTML("file/Monk.html"),
	PALADIN_HTML("file/Paladin.html"),
	RANGER_HTML("file/Ranger.html"),
	ROGUE_HTML("file/Rogue.html"),
	SORCERER_HTML("file/Sorcerer.html"),
	WARLOCK_HTML("file/Warlock.html"),
	WIZARD_HTML("file/Wizard.html"),

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
