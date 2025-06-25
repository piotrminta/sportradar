package model;

import lombok.Getter;

@Getter
public class TeamScore {
	private Team team;
	private Score score;

	public TeamScore(Team team, Score score) {
		setTeam(team);
		setScore(score);
	}

	public void setTeam(Team team) {
		if (team == null) {
			throw new IllegalArgumentException();
		}
		this.team = team;
	}

	public void setScore(Score score) {
		if (score == null) {
			throw new IllegalArgumentException();
		}
		this.score = score;
	}
}
