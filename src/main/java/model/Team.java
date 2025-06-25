package model;

import lombok.Getter;

@Getter
public class Team {
	private String name;

	public Team(String name) {
		setName(name);
	}

	public void setName(String name) {
		if (name == null || name.isBlank()) {
			throw new IllegalArgumentException();
		}
		this.name = name;
	}
}
