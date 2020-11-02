import java.util.ArrayList;
import java.util.List;

public class DaySchedule {
    private DaysOfTheWeek day;
    private List<String> activities;

    public DaySchedule(DaysOfTheWeek day, List<String> activities) {
        this.day = day;
        this.activities = activities;
    }

    public DaysOfTheWeek getDay() {
        return day;
    }

    public List<String> getActivities() {
        return new ArrayList<>(activities);
    }

    public void addActivity(String activity) {
        activities.add(activity);
    }

    public void removeActivity(String activity) {
        activities.remove(activity);
    }

    @Override
    public String toString() {
        return "DaySchedule{" +
                "day=" + day +
                ", activities=" + activities +
                '}';
    }
}
