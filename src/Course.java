public class Course {
    String name;
    String days;          
    int startMinutes;     
    int endMinutes;
    int seatsLeft;

    public Course(String name, String days, int startMinutes, int endMinutes, int seatsLeft) {
        this.name = name;
        this.days = days;
        this.startMinutes = startMinutes;
        this.endMinutes = endMinutes;
        this.seatsLeft = seatsLeft;
    }

    public String getDisplayText() {
        return name + " | " + days + " " +
                formatTime(startMinutes) + "-" + formatTime(endMinutes) +
                " | Seats left: " + seatsLeft;
    }

    private String formatTime(int minutes) {
        int hour = minutes / 60;
        int min = minutes % 60;
        String ampm = (hour >= 12) ? "pm" : "am";
        if (hour == 0) hour = 12;
        if (hour > 12) hour -= 12;
        return String.format("%d:%02d%s", hour, min, ampm);
    }
}
