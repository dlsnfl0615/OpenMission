package timetable.service;

import timetable.domain.Lecture;
import timetable.domain.LectureMatcher;
import timetable.domain.RegisterWizard;
import timetable.domain.TimeTable;
import timetable.domain.Day;

import java.util.List;

public class TimeTableMaker {
    private final RegisterWizard registerWizard;
    private final LectureMatcher lectureMatcher;

    public TimeTableMaker(RegisterWizard registerWizard, LectureMatcher lectureMatcher) {
        this.registerWizard = registerWizard;
        this.lectureMatcher = lectureMatcher;
    }

    public List<TimeTable> makeTimeTable(List<String> lectureCodes, List<Lecture> availableLectures, List<Day> noLectureDays) {
        List<Lecture> lecturesToRegister = lectureMatcher.findLecturesWithCode(lectureCodes, availableLectures);
        return registerWizard.makeTimeTable(lecturesToRegister, noLectureDays);
    }
}
