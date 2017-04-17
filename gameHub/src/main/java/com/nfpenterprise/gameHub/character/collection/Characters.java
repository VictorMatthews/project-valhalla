package com.nfpenterprise.gameHub.character.collection;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.nfpenterprise.gameHub.character.dto.CharacterDto;

@XmlRootElement
public class Characters {

    private List<CharacterDto> characters;

	public Characters() {}

	public Characters(List<CharacterDto> characters) {
        this.characters = characters;
	}

    @XmlElement
    public List<CharacterDto> getCharacters() {
        return characters;
    }

    public void setCharacters(List<CharacterDto> characters) {
        this.characters = characters;
    }
}
