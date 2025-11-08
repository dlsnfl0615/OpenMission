package timetable.dto;

import timetable.domain.Lecture;

import java.util.List;

public record LectureRequest(
        String lectureName,
        String professorName,
        String lectureCode,
        List<TimeSlotRequest> times
) {
    public static LectureRequest from(Lecture lecture) {
        return new LectureRequest(
                lecture.getLectureName(),
                lecture.getProfessorName(),
                lecture.getLectureCode(),
                lecture.getLectureTimes().stream()
                        .map(TimeSlotRequest::from)
                        .toList()
        );
    }
}