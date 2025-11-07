package timetable.domain;

import org.junit.jupiter.api.Test;

import java.time.LocalTime;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LectureSectionTest {
    @Test
    void 분반_시간_중복없음() {
        List<TimeSlot> lectureTimes1 = List.of(new TimeSlot(Day.MON, LocalTime.of(8, 0), LocalTime.of(9, 0)));
        LectureSection lectureSection1 = new LectureSection("최진우", "CSC-1234", lectureTimes1);

        List<TimeSlot> lectureTimes2 = List.of(new TimeSlot(Day.MON, LocalTime.of(9, 0), LocalTime.of(10, 0)));
        LectureSection lectureSection2 = new LectureSection("최진우", "CSC-5678", lectureTimes2);

        assertThat(lectureSection1.overlapsWith(lectureSection2)).isFalse();
    }

    @Test
    void 분반_시간_중복있음() {
        List<TimeSlot> lectureTimes1 = List.of(new TimeSlot(Day.MON, LocalTime.of(8, 0), LocalTime.of(9, 0)));
        LectureSection lectureSection1 = new LectureSection("최진우", "CSC-1234", lectureTimes1);

        List<TimeSlot> lectureTimes2 = List.of(new TimeSlot(Day.MON, LocalTime.of(8, 30), LocalTime.of(10, 0)));
        LectureSection lectureSection2 = new LectureSection("최진우", "CSC-5678", lectureTimes2);

        assertThat(lectureSection1.overlapsWith(lectureSection2)).isTrue();
    }
}