package christmas.domain.calendar;

public enum DecemberCalendar {
    CHRISTMAS_EVENT_PERIOD(1, 25),
    OTHER_EVENT_PERIOD(1, 31),
    WEEKEND_DAY(1, (30 % 7)),
    STAR_DAY(3, 25);

    private final int startDay;
    private final int endDay;

    DecemberCalendar(int startDay, int endDay) {
        this.startDay = startDay;
        this.endDay = endDay;
    }

    public int getStartDay() {
        return startDay;
    }

    public int getEndDay() {
        return endDay;
    }
}
