package com.nfpenterprise.gameHub.race.collection;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.nfpenterprise.gameHub.race.dto.RaceDto;

@XmlRootElement(name = "races")
public class RacesWrapper {

    private List<RaceDto> races;

    @XmlElement(name = "race")
    public List<RaceDto> getRaces() {
        return races;
    }

    public void setRaces(List<RaceDto> races) {
        this.races = races;
    }

}
