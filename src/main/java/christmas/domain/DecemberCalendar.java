package christmas.domain;

public enum DecemberCalendar {
    CHRISTMAS_EVENT_PERIOD(1, 25),
    OTHER_EVENT_PERIOD(1, 31),
    WEEKEND_DAY(1,2),
    STAR_DAY(3, 25);

    private final int firstDay;
    private final int secondDay;

    DecemberCalendar(int firstDay, int secondDay) {
        this.firstDay = firstDay;
        this.secondDay = secondDay;
    }

    public int getFirstDay() {
        return firstDay;
    }

    public int getSecondDay() {
        return secondDay;
    }
}
