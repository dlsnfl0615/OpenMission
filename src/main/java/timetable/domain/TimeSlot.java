package timetable.domain;

import java.time.LocalTime;

public class TimeSlot {
    private final Day day;
    private final LocalTime start;
    private final LocalTime end;

    public TimeSlot(Day day, LocalTime start, LocalTime end) {
        this.day = day;
        this.start = start;
        this.end = end;
    }

    public boolean doesOverlap(TimeSlot timeSlot) {
        if (this.day != timeSlot.day) {
            return false;
        }

        return (timeSlot.start.isAfter(this.start) && timeSlot.start.isBefore(this.end))
                || (timeSlot.end.isAfter(this.start) && timeSlot.end.isBefore(this.end));
    }
}
