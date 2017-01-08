package com.nfpenterprise.gameHub.race.collection;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.nfpenterprise.gameHub.race.dto.SubRaceDto;

@XmlRootElement(name = "subraces")
public class SubRacesWrapper {

    private List<SubRaceDto> races;

    @XmlElement(name = "subrace")
    public List<SubRaceDto> getCharacters() {
        return races;
    }

    public void setCharacters(List<SubRaceDto> characters) {
        this.races = characters;
    }

}
