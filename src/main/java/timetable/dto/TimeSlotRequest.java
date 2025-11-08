package timetable.dto;

import timetable.domain.TimeSlot;

public record TimeSlotRequest(
        String day,
        String start,
        String end
) {
    public static TimeSlotRequest from(TimeSlot slot) {
        return new TimeSlotRequest(
                slot.getDay().name(),
                slot.getStart().toString(),
                slot.getEnd().toString()
        );
    }
}