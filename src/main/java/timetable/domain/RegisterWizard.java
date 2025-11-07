package timetable.domain;

import java.util.*;

public class RegisterWizard {
    private final List<TimeTable> timeTables;
    private final List<Lecture> lectures; // 수강 신청하고자 하는 강의 목록
    private final int uniqueLectures; // 강의 종류 수

    public RegisterWizard(List<Lecture> lectures) {
        this.timeTables = new ArrayList<>();
        this.lectures = lectures;
        uniqueLectures = divideLectureByType().size();
    }

    public void makeTimeTable() {
        List<Lecture> usedLectures = new ArrayList<>();

        dfsPickingLecture(usedLectures);
    }

    public void dfsPickingLecture(List<Lecture> usedLectures) {
        // 사용자가 원하는 강의 종류 수를 모두 신청하면 종료
        if (usedLectures.size() == uniqueLectures) {
            timeTables.add(new TimeTable(new ArrayList<>(usedLectures)));
            return;
        }

        for (Lecture lecture : lectures) {
            if (canAddLecture(usedLectures, lecture)) {
                usedLectures.add(lecture);
                dfsPickingLecture(usedLectures);
                usedLectures.remove(usedLectures.size() - 1);
            }
        }

    }

    public boolean canAddLecture(List<Lecture> usedLectures, Lecture lecture) {
        if (usedLectures.isEmpty()) {
            return true;
        }

        for (Lecture usedLecture : usedLectures) {
            if (usedLecture.overlapsTimeWith(lecture)
                    || usedLecture.overlapsNameWith(lecture)) {
                return false;
            }
        }

        return true;
    }

    public Map<String, List<Lecture>> divideLectureByType() {
        Map<String, List<Lecture>> map = new HashMap<>();

        for (Lecture lecture : lectures) {
            lecture.divide(map);
        }

        return map;
    }
}
