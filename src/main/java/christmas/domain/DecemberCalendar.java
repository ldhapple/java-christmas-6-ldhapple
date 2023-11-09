package christmas.domain;

public enum DecemberCalendar {
    FIRST_DAY(1, -1),
    LAST_DAY(31, -1),
    WEEKEND_DAY(1,2),
    STAR_DAY(3, 25);

    private final int firstDay;
    private final int secondDay;

    DecemberCalendar(int firstDay, int secondDay) {
        this.firstDay = firstDay;
        this.secondDay = secondDay;
    }

    public int getDay() {
        return firstDay;
    }

    public int getSecondDay() {
        return secondDay;
    }
}
