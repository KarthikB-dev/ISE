import java.util.concurrent.*;
import java.util.*;
public class Timer 
{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        TimeUnit clock = TimeUnit.MINUTES;
        long timeStudy = 50L;
        long timeBreak = 10L;
        int numBreaks = 3;
        //determine if breaks should last 10 minutes
        //study sessions last 50 minutes, and we have
        //3 breaks/study combos
        boolean default_time = true;
        String want_default = "";
        while (!want_default.equals("y") && !want_default.equals("n")) {
            System.out.println("Enter y if you want default timings");
            System.out.println("Enter n if you do not");
            want_default = input.next();
            if (want_default.equals("n")) {
                default_time = false;
            }
        }
        if (!default_time)
        {
            HashMap<String, Long> mins = new HashMap<String, Long>();
            mins.put("A", 10L);
            mins.put("B", 20L);
            mins.put("C", 30L);
            mins.put("D", 40L);
            mins.put("E", 50L);
            mins.put("F", 60L);
            mins.put("G", 90L);
    
            System.out.println("How long do you want to study for?");
            System.out.print("A) 10 minutes B) 20 C) 30 D) 40 E) 50 F) 60 ");
            System.out.print("G) 90");
            String study_input = input.next();
            timeStudy = mins(study_input, mins);
            if (timeStudy == -1L) {
                input.close();
                return;
            }
            System.out.println("How long should your breaks be?");
            System.out.print("A) 10 minutes B) 20 C) 30 D) 40 E) 50 F) 60 ");
            System.out.print("G) 90");
            String break_input = input.next();
            timeBreak = mins(break_input, mins);
            if (timeBreak == -1L) {
                input.close();
                return;
            }
            System.out.println("How many subsessions do you want to have?");
            numBreaks = input.nextInt();
        }
        input.close();
        for (int i = 0; i < numBreaks; i++) { 
            try {
                System.out.println("It is time to study!");
                clock.sleep(timeStudy);
                System.out.println("It is time to take a break :)");
                clock.sleep(timeBreak);
            }
            catch (InterruptedException e) {
                System.out.println("ERROR INTERRUPTED EXCEPTION");
            }
        }
    }
    /**
     * Sleeps for 10 seconds
     */
    public static void testDelay() {
        long studyTime = 10L;
        TimeUnit clock = TimeUnit.SECONDS;
        System.out.println("Begin!");
        try {
            clock.sleep(studyTime);
        }
        catch (InterruptedException e) {
            System.out.println("ERROR INTERRUPTED EXCEPTION");    
        }
        System.out.println("Over!");
    }
    /**
     * Returns the appropriate long to 
     */
    public static long mins (String letter, Map<String, Long> mins) {
        if (mins.get(letter) == null) {
            return -1L;
        }
        return mins.get(letter);
    }
}
