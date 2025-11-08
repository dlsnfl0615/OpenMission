package timetable.dto;

import timetable.domain.TimeTable;

import java.util.List;

public record TimeTableRequest(
        List<LectureRequest> lectures
) {
    public static TimeTableRequest from(TimeTable timeTable) {
        return new TimeTableRequest(
                timeTable.getLectures().stream()
                        .map(LectureRequest::from)
                        .toList()
        );
    }
}