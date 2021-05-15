import java.util.*;

public class PersonalTask extends Task
{
    //could be for personal fitness, overall health,
    //personal project, etc.
    //exercise
    //diet
    //personal project
    //skill to learn(with a deadline, perhaps java.util.date)
    //the day can be broken the morning, afternoon, evening, and night,
    //and each task must be completed in one of these times
    //
    /**
     * Creates a new PersonalTask object
     * @param time The time of day when it must be done
     * @param frequency How often it must be done
     */
    int time;
    int frequency;
    int currDay;
    /**
     * Creates a new PersonalTask object
     * @param time The time when it must be done
     * @param frequency How often the task must be done
     */
    public PersonalTask(int time, int frequency) {
        this.time = time;
        this.frequency = frequency;
    }
    /**
     * Determines if the task must be done today
     * @return If today is a day where this task has to be done
     */
    public boolean mustDoToday() {
        return currDay % frequency == 0;
    }
    /**
     * Increases the day count by one
     */
    public void incrementDay() {
        this.currDay ++;
    }
    public boolean doNow
}
