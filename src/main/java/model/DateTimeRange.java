package model;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class DateTimeRange {
	private LocalDateTime start;
	private LocalDateTime end;

	public void setStart(LocalDateTime start) {
		if (start != null && end != null && start.isAfter(end)) {
			throw new IllegalArgumentException();
		}
		this.start = start;
	}

	public void setEnd(LocalDateTime end) {
		if (start != null && end != null && end.isBefore(start)) {
			throw new IllegalArgumentException();
		}
		this.end = end;
	}
}