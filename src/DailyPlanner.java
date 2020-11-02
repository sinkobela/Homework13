import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DailyPlanner {
    private List<DaySchedule> daySchedules;

    public DailyPlanner(List<DaySchedule> daySchedules) {
        this.daySchedules = daySchedules;
    }

    public List<DaySchedule> getDaySchedules() {
        return daySchedules;
    }

    public void addActivity(DaysOfTheWeek day, String activity) {
        if (activity == null) {
            throw new NoActivityException("The activity is null!");
        }

        boolean dayFlag = false;
        for (DaySchedule schedule : daySchedules) {
            if (schedule.getDay() == day) {
                dayFlag = true;
            }
        }
        if (dayFlag) {
            for (DaySchedule schedule : daySchedules) {
                if (schedule.getDay() == day) {
                    schedule.addActivity(activity);
                }
            }
        } else {
            List<String> activities = new ArrayList<>();
            activities.add(activity);
            daySchedules.add(new DaySchedule(day, activities));
        }
    }

    public void removeActivity(DaysOfTheWeek day, String activity) {
        for (DaySchedule daySchedule : daySchedules) {
            if (daySchedule.getDay() == day) {
                if (daySchedule.getActivities().contains(activity)) {
                    daySchedule.removeActivity(activity);
                } else {
                    throw new NoActivityException("The activity doesn't exists.");
                }
            }
        }
    }

    public List<String> getActivities(DaysOfTheWeek day) {
        for (DaySchedule daySchedule : daySchedules) {
            if (daySchedule.getDay() == day) {
                return daySchedule.getActivities();
            }
        }
        return null;
    }

    public Map<DaysOfTheWeek, List<String>> endPlanning() throws NoActivitiesForDayException {
        Map<DaysOfTheWeek, List<String>> result = new HashMap<>();
        for (DaySchedule daySchedule : daySchedules) {
            result.put(daySchedule.getDay(), daySchedule.getActivities());
        }

        if (result.size() < DaysOfTheWeek.values().length) {
            throw new NoActivitiesForDayException("There are days without activities!");
        } else {
            for (DaySchedule daySchedule : daySchedules) {
                if (daySchedule.getActivities().isEmpty()) {
                    throw new NoActivitiesForDayException("Exception");
                }
            }
        }

        return result;
    }
}

