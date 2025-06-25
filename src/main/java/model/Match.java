package model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
public class Match {
	private static final Set<Match> liveMatches = new HashSet<>();

	private TeamScore homeTeamScore;
	private TeamScore awayTeamScore;
	private DateTimeRange dateTimeRange;

	public static Match start(Team homeTeam, Team awayTeam) {
		DateTimeRange dateTimeRange = new DateTimeRange();
		dateTimeRange.setStart(LocalDateTime.now());
		TeamScore homeTeamScore = new TeamScore(homeTeam, new Score(0));
		TeamScore awayTeamScore = new TeamScore(awayTeam, new Score(0));
		Match match = new Match();
		match.setHomeTeamScore(homeTeamScore);
		match.setAwayTeamScore(awayTeamScore);
		match.setDateTimeRange(dateTimeRange);
		liveMatches.add(match);
		return match;
	}

	public void finish(LocalDateTime end) {
		this.dateTimeRange.setEnd(end);
		liveMatches.remove(this);
	}

	public void update(Score homeScore, Score awayScore) {
		this.getHomeTeamScore().setScore(homeScore);
		this.getAwayTeamScore().setScore(awayScore);
	}

	public static Set<Match> findByTotalScore() {
		return liveMatches.stream()
			.sorted(Comparator
				.comparing(Match::total).reversed()
				.thenComparing(match -> match.getDateTimeRange().getStart()))
			.collect(Collectors.toCollection(LinkedHashSet::new));
	}

	private int total() {
		return this.getHomeTeamScore().getScore().getValue() + this.getAwayTeamScore().getScore().getValue();
	}
}
