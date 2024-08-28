package com.racedriverlife.racedriverlife_app.entities;

import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_race_central")
public class RaceCentral {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long centralId;
	private Integer racesWon;
	private Integer racesDisputed;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "race_id", nullable = false)
	private Race race;

	public RaceCentral() {

	}

	public RaceCentral(Race race) {
		super();
		this.racesWon = 0;
		this.racesDisputed = 0;
		this.race = race;
	}

	public Long getCentralId() {
		return centralId;
	}

	public Integer getRacesWon() {
		return racesWon;
	}

	public void setRacesWon(Integer racesWon) {
		this.racesWon = racesWon;
	}

	public Integer getRacesDisputed() {
		return racesDisputed;
	}

	public void setRacesDisputed(Integer racesDisputed) {
		this.racesDisputed = racesDisputed;
	}

	public Race getRace() {
		return race;
	}

	public void setRace(Race race) {
		this.race = race;
	}

	@Override
	public int hashCode() {
		return Objects.hash(centralId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RaceCentral other = (RaceCentral) obj;
		return Objects.equals(centralId, other.centralId);
	}
}
