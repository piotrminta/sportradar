package model;

import lombok.Getter;

@Getter
public class Score {
	private int value;

	public Score(int value) {
		setValue(value);
	}

	public void setValue(int value) {
		if (value < 0) {
			throw new AssertionError();
		}
		this.value = value;
	}
}
