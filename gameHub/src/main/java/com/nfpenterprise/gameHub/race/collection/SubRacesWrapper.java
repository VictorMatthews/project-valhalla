package com.nfpenterprise.gameHub.race.collection;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.nfpenterprise.gameHub.race.dto.SubRaceDto;

@XmlRootElement(name = "subraces")
public class SubRacesWrapper {

    private List<SubRaceDto> subRaces;

    @XmlElement(name = "subrace")
    public List<SubRaceDto> getSubRaces() {
        return subRaces;
    }

    public void setSubRaces(List<SubRaceDto> subRaces) {
        this.subRaces = subRaces;
    }

}
