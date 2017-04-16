package com.nfpenterprise.gameHub.character.collection;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.nfpenterprise.gameHub.character.dto.CharacterDto;

@XmlRootElement(name = "characters")
public class CharactersWrapper {

    private List<CharacterDto> characters;

    @XmlElement(name = "character")
    public List<CharacterDto> getCharacters() {
        return characters;
    }

    public void setCharacters(List<CharacterDto> characters) {
        this.characters = characters;
    }
}
