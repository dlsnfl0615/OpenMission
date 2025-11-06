package timetable.domain;

import java.util.List;

public class Lecture {
    private final String lectureName;
    private final String professorName;
    private final String lectureCode;
    private final List<TimeSlot> lectureTimes;

    public Lecture(String lectureName, String professorName, String lectureCode, List<TimeSlot> lectureTimes) {
        this.lectureName = lectureName;
        this.professorName = professorName;
        this.lectureCode = lectureCode;
        this.lectureTimes = lectureTimes;
    }
}
