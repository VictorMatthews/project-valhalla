package com.nfpenterprise.gameHub.race.dto;

import com.nfpenterprise.gameHub.constants.Races;

public class RaceDto {
	private Integer raceId;
	private String raceName;
	private Integer speed;
	
	public RaceDto() {
	}

	public RaceDto(Races race) {
		setRaceId(race.getRaceId());
		setRaceName(race.getRaceName());
		setSpeed(race.getRaceSpeed());
		
	}

	public Integer getRaceId() {
		return raceId;
	}

	public void setRaceId(Integer raceId) {
		this.raceId = raceId;
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
