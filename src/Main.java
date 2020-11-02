import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws NoActivitiesForDayException{
        DaySchedule monday = new DaySchedule(DaysOfTheWeek.MONDAY, new ArrayList<>(List.of("work", "eat", "read")));
        DaySchedule thursday = new DaySchedule(DaysOfTheWeek.THURSDAY, new ArrayList<>(List.of("work", "eat", "swim", "drink")));
        DaySchedule friday = new DaySchedule(DaysOfTheWeek.FRIDAY, new ArrayList<>(List.of("work", "learn", "jog")));
        DaySchedule sunday = new DaySchedule(DaysOfTheWeek.SUNDAY, new ArrayList<>(List.of("eat", "read", "sleep")));

        List<DaySchedule> dayScheduleList = new ArrayList<>();
        dayScheduleList.add(monday);
        dayScheduleList.add(thursday);
        dayScheduleList.add(friday);
        dayScheduleList.add(sunday);
        DailyPlanner dailyPlanner = new DailyPlanner(dayScheduleList);

        dailyPlanner.addActivity(DaysOfTheWeek.SATURDAY, null);
        dailyPlanner.addActivity(DaysOfTheWeek.SATURDAY, "run");
        dailyPlanner.addActivity(DaysOfTheWeek.FRIDAY, "run");
        System.out.println(dailyPlanner.getDaySchedules());

        dailyPlanner.removeActivity(DaysOfTheWeek.THURSDAY, "eat");
        System.out.println(dailyPlanner.getDaySchedules());

        System.out.println("\n");
        System.out.println(dailyPlanner.getActivities(DaysOfTheWeek.FRIDAY));

        System.out.println("\n");
        System.out.println(dailyPlanner.endPlanning());
    }
}
