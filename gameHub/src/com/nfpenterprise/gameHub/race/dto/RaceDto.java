package com.nfpenterprise.gameHub.race.dto;

public class RaceDto {
	private Integer raceId;
	private String raceName;
	private Integer speed;
	
	public RaceDto(Integer raceId) {
		this.raceId = raceId;
	}

	public Integer getRaceId() {
		return raceId;
	}

	public String getRaceName() {
		return raceName;
	}

	public void setRaceName(String raceName) {
		this.raceName = raceName;
	}

	public Integer getSpeed() {
		return speed;
	}

	public void setSpeed(Integer speed) {
		this.speed = speed;
	}
}
