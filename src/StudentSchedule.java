import java.util.ArrayList;
import java.util.List;

public class StudentSchedule {

    public static List<Course> enrolled = new ArrayList<>();
    public static List<Course> waitlisted = new ArrayList<>();

    public static boolean hasConflictWithEnrolled(Course newCourse) {
        for (Course c : enrolled) {
            if (haveConflict(c, newCourse)) {
                return true;
            }
        }
        return false;
    }

    public static boolean haveConflict(Course c1, Course c2) {
        if (!daysOverlap(c1.days, c2.days)) return false;

        boolean timeOverlap = c1.startMinutes < c2.endMinutes &&
                              c2.startMinutes < c1.endMinutes;
        return timeOverlap;
    }

    private static boolean daysOverlap(String d1, String d2) {
        for (char ch1 : d1.toCharArray()) {
            for (char ch2 : d2.toCharArray()) {
                if (ch1 == ch2) {
                    return true;
                }
            }
        }
        return false;
    }
}
