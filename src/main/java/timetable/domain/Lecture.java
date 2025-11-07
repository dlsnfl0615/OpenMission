package timetable.domain;

import java.util.List;

public class Lecture {
    private final String lectureName;
    private final List<LectureSection> lectureSections;

    public Lecture(String lectureName, List<LectureSection> lectureSections) {
        this.lectureName = lectureName;
        this.lectureSections = lectureSections;
    }
}
