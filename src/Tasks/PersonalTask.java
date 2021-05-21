import java.util.*;
import java.text.SimpleDateFormat;
/**
 * Class for personal tasks
 * These tasks are different in nature
 * because instead of being done by a certain
 * date, we consider personal tasks to be done
 * in a certain time of day (such as the morning),
 * or a certain number of times, such as every other 
 * week
 * @author Karthik Bhattaram
 * @version 5/14/2021
 * @source tutorialspoint
 * https://www.tutorialspoint.com/
 * java-program-to-display-time-in-24-hour-format
 */
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
     * Note that time is 1, 2, 3, or 4
     * Morning, afternoon, evening, night
     * @param time The time of day when it must be done
     * @param frequency How often it must be done
     */
    private int time;
    private int frequency;
    private int currDay;
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
    /**
     * Checks if this task must be done now
     * @return If at this time, the task should be done
     */
    public boolean doNow() {
        Date currDate = new Date();
        SimpleDateFormat df 
            = new SimpleDateFormat("kk:mm:ss");
        String tm = df.format(currDate);
        int hour = Integer.parseInt(tm.substring(0, tm.indexOf(':')));
        //time is 1, 2, 3, or 4
        //1 is morning, 2 is afternoon, 3 is evening, 4 is night
        //hours 0 to 12 are morning
        //hours 12 to 16 are afternoon
        //hours 16 to 18 are evening
        //hours 18 to 23 are night
        int currTime;
        if (hour < 12) {
            currTime = 1;
        }
        else if (hour < 16) {
            currTime = 2;
        }
        else if (hour < 18) {
            currTime = 3;
        }
        else {
            currTime = 4;
        }
        return time == currTime;
    }
}
