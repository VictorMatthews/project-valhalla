package com.nfpenterprise.gameHub.constants;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public enum Spells {
/*Acid Splash
Blade Ward
Chill Touch
Dancing Lights
Druidcraft
Eldritch Blast
Fire Bolt
Friends
Guidance
Light
Mage Hand
Mending
Message
Minor Illusion
Poison Spray
Prestidigitation
Produce Flame
Ray of Frost
Resistance
Sacred Flame
Shillelagh
Shocking Grasp
Spare the Dying
Thaumaturgy
Thorn Whip
True Strike
Vicious Mockery
Alarm
Animal Friendship
Armor of Agathys
Arms of Hadar
Bane
Bless
Burning Hands
Charm Person
Chromatic Orb
Color Spray
Command
Compelled Duel
Comprehend Languages
Create or Destroy Water
Cure Wounds
Detect Evil and Good
Detect Magic
Detect Poison and Disease
Disguise Self
Dissonant Whispers
Divine Favor
Ensnaring Strike
Entangle
Expeditious Retreat
Faerie Fire
False Life
Feather Fall
Find Familiar
Fog Cloud
Goodberry
Grease
Guiding Bolt
Hail of Thorns
Healing Word
Hellish Rebuke
Heroism
Hex
Hunter's Mark
Identify
Illusory Script
Inflict Wounds
Jump
Longstrider
Mage Armor
Magic Missile
Protection from Evil and Good
Purify Food and Drink
Ray of Sickness
Sanctuary
Searing Smite
Shield
Shield of Faith
Silent Image
Sleep
Speak with Animals
Tasha's Hideous Laughter
Tenser's Floating Disk
Thunderous Smite
Thunderwave
Unseen Servant
Witch Bolt
Wrathful Smite*/
	

	//@formatter:off

	ACID_SPLASH(	0, "Acid Splash", Paths.ACID_SPLASH_HTML.getPath(), new HashSet<Classes>(Arrays.asList(Classes.SORCERER, Classes.WIZARD))),
;
	//@formatter:on
	
	private final Integer spellLevel;
	private final String spellName;
	private final String spellHTMLPath;
	private final Set<Classes> classThatCanUseSpell;

	Spells(Integer spellLevel, String spellName, String spellHTMLPath, Set<Classes> classThatCanUseSpell) {
		this.spellLevel = spellLevel;
		this.spellName = spellName;
		this.spellHTMLPath = spellHTMLPath;
		this.classThatCanUseSpell = classThatCanUseSpell;
	}

	public Integer getSpellLevel() {
		return spellLevel;
	}

	public String getSpellName() {
		return spellName;
	}

	public String getSpellHTMLPath() {
		return spellHTMLPath;
	}

	public Set<Classes> getClassThatCanUseSpell() {
		return classThatCanUseSpell;
	}
}
