package timetable.domain;

import java.util.List;

public class TimeTable {
    private final List<Lecture> lectures;

    public TimeTable(List<Lecture> registeredLectures) {
        lectures = registeredLectures;
    }
}
