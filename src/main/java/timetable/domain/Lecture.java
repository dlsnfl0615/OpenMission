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

    public boolean overlapsWith(Lecture otherLecture) {
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

    public boolean hasConflictWith(TimeSlot thisTimeSlot, List<TimeSlot> otherLectureTimes) {
        for (TimeSlot otherTimeSlot : otherLectureTimes) {
            if (thisTimeSlot.overlapsWith(otherTimeSlot)) {
                return true;
            }
        }

        return false;
    }
}
