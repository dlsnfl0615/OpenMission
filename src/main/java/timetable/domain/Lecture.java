package timetable.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

    public boolean overlapsTimeWith(Lecture otherLecture) {
        // 동일 교과목은 수강할 수 없음
        if (this.lectureName.equals(otherLecture.lectureName)
                || this.lectureCode.equals(otherLecture.lectureCode)) {
            return true;
        }

        for (TimeSlot timeSlot : this.lectureTimes) {
            if (hasConflictWith(timeSlot, otherLecture.lectureTimes)) {
                return true;
            }
        }

        return false;
    }

    public boolean overlapsNameWith(Lecture otherLecture) {
        return this.lectureName.equals(otherLecture.lectureName);
    }

    public boolean hasConflictWith(TimeSlot thisTimeSlot, List<TimeSlot> otherLectureTimes) {
        for (TimeSlot otherTimeSlot : otherLectureTimes) {
            if (thisTimeSlot.overlapsWith(otherTimeSlot)) {
                return true;
            }
        }

        return false;
    }

    public void divide(Map<String, List<Lecture>> map) {
        if (!map.containsKey(lectureName)) {
            map.put(lectureName, new ArrayList<>(List.of(this)));
            return;
        }

        map.get(lectureName).add(this);
    }
}
