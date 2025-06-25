import model.Match;
import model.Score;
import model.Team;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

class MatchTest {
	Match matchA;
	Match matchB;

	@BeforeEach
	void setUp() {
		Team homeTeamA = new Team("Uruguay");
		Team awayTeamA = new Team("Italy");
		matchA = Match.start(homeTeamA, awayTeamA);
		matchA.update(new Score(6), new Score(6));
		Team homeTeamB = new Team("Spain");
		Team awayTeamB = new Team("Brazil");
		matchB = Match.start(homeTeamB, awayTeamB);
		matchB.update(new Score(10), new Score(2));
	}

	@Test
	void finish() {
		matchA.finish(LocalDateTime.now());
		Assertions.assertFalse(Match.findByTotalScore().contains(matchA));
	}

	@Test
	void update() {
		Score scoreA = new Score(0);
		Score scoreB = new Score(1);
		matchA.update(scoreA, scoreB);
		Assertions.assertEquals(scoreA, matchA.getHomeTeamScore().getScore());
		Assertions.assertEquals(scoreB, matchA.getAwayTeamScore().getScore());
	}

	@Test
	void findByTotalScore() {
		List<Match> expected = new ArrayList<>(Match.findByTotalScore());
		Assertions.assertTrue(expected.contains(matchA));
		Assertions.assertTrue(expected.contains(matchB));
		List<Match> actual = List.of(matchA, matchB);
		Assertions.assertEquals(expected, actual);
	}
}
