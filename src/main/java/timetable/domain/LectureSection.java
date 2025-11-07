package timetable.domain;

import java.util.List;

public class LectureSection {
    private final String professorName;
    private final String lectureCode;
    private final List<TimeSlot> lectureTimes;

    public LectureSection(String professorName, String lectureCode, List<TimeSlot> lectureTimes) {
        this.professorName = professorName;
        this.lectureCode = lectureCode;
        this.lectureTimes = lectureTimes;
    }

    // 다른 강의의 분반을 받아서 강의 시간이 겹치는지 확인
    public boolean overlapsWith(LectureSection lectureSection) {
        for (TimeSlot thisTimeSlot : this.lectureTimes) {
            if (hasConflictWith(thisTimeSlot, lectureSection)) {
                return true;
            }
        }
        return false;
    }

    public boolean hasConflictWith(TimeSlot thisTimeSlot, LectureSection lectureSection) {
        for (TimeSlot otherTimeSlot : lectureSection.lectureTimes) {
            if (thisTimeSlot.doesOverlap(otherTimeSlot)) {
                return true;
            }
        }
        return false;
    }
}
