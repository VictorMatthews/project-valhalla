package com.nfpenterprise.gameHub.race.dto;

import com.nfpenterprise.gameHub.constants.SubRaces;

public class SubRaceDto {
	private Integer	raceId;
	private String subRaceName;
	
	public SubRaceDto() {
	}

	public SubRaceDto(SubRaces subRace) {
		setRaceId(subRace.getRaceId());
		setSubRaceName(subRace.getSubRaceName());
	}

	public Integer getRaceId() {
		return raceId;
	}

	public void setRaceId(Integer raceId) {
		this.raceId = raceId;
	}

	public String getSubRaceName() {
		return subRaceName;
	}

	public void setSubRaceName(String subRaceName) {
		this.subRaceName = subRaceName;
	}
}
