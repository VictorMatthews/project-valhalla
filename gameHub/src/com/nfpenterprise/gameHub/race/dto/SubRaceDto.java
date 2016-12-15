package com.nfpenterprise.gameHub.race.dto;

public class SubRaceDto {
	private Integer subRaceId;
	private Integer	raceId;
	
	public SubRaceDto(Integer raceId) {
		this.subRaceId = raceId;
	}

	public Integer getSubRaceId() {
		return subRaceId;
	}

	public Integer getRaceId() {
		return raceId;
	}

	public void setRaceId(Integer raceId) {
		this.raceId = raceId;
	}
}
