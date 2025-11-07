package timetable.domain;

import java.util.ArrayList;
import java.util.List;

public class TimeTable {
    private final List<Lecture> lectures = new ArrayList<>();

    public void registerLecture(Lecture addLecture) {
        lectures.add(addLecture);
    }

    public boolean exists(Lecture addLecture) {
        for (Lecture lecture : lectures) {
            if (lecture.overlapsWith(addLecture)) {
                return true;
            }
        }

        return false;
    }
}
