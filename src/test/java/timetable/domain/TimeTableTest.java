package timetable.domain;

import org.junit.jupiter.api.Test;

import java.time.LocalTime;
import java.util.List;

import static org.assertj.core.api.Assertions.*;


class TimeTableTest {
    List<TimeSlot> lectureTimes1 = List.of(new TimeSlot(Day.MON, LocalTime.of(8, 30), LocalTime.of(10, 0)));
    Lecture lecture1 = new Lecture("자바", "최진우", "CSC-5678", lectureTimes1);

    List<TimeSlot> lectureTimes2 = List.of(new TimeSlot(Day.MON, LocalTime.of(10, 30), LocalTime.of(12, 0)));
    Lecture lecture2 = new Lecture("파이썬", "최진우", "CSC-1234", lectureTimes2);

    @Test
    void 시간표에_등록_등록여부확인() {
        TimeTable timeTable = new TimeTable();

        timeTable.registerLecture(lecture1);

        assertThat(timeTable.exists(lecture1)).isTrue();
        assertThat(timeTable.exists(lecture2)).isFalse();
    }
}