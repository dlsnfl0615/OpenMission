package timetable.domain;

import java.util.ArrayList;
import java.util.List;

public class RegisterWizard {
    private final List<TimeTable> timeTables;
    private final List<Lecture> lectures;
    private final int pickedLecturesCount;

    public RegisterWizard(List<TimeTable> timeTables, List<Lecture> lectures) {
        this.timeTables = timeTables;
        this.lectures = lectures;
    }

    public int countLectureType() {
        int count = 0;
        List<String> lectureTypes = new ArrayList<>();

        for (Lecture lecture : lectures) {

        }
    }

    public void makeTimeTable() {
        TimeTable timeTable = new TimeTable();

        timeTables.add(timeTable);
    }

    public TimeTable pickLectures() {

    }
}
