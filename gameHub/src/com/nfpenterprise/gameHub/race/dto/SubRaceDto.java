package com.nfpenterprise.gameHub.race.dto;

public class SubRaceDto {
	private Integer subRaceId;
	private Integer	raceId;
	private String subRaceName;
	
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

	public String getSubRaceName() {
		return subRaceName;
	}

	public void setSubRaceName(String subRaceName) {
		this.subRaceName = subRaceName;
	}
}
