import java.util.concurrent.*;
import java.util.*;
import java.io.*;
import java.net.*;
import java.awt.Desktop;
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
            timeStudy = -1L;
            timeBreak = -1L;
            while (timeStudy == -1L)    
            {
                System.out.println("How long do you want to study for?");
                System.out.print("A) 10 minutes B) 20 C) 30 D) 40 E) 50 F) 60 ");
                System.out.print("G) 90");
                String study_input = input.next();
                timeStudy = mins(study_input, mins);
            }
            while (timeBreak == -1L) {
                System.out.println("How long should your breaks be?");
                System.out.print("A) 10 minutes B) 20 C) 30 D) 40 E) 50 F) 60 ");
                System.out.print("G) 90");
                String break_input = input.next();
                timeBreak = mins(break_input, mins);
            }
            
            System.out.println("How many subsessions do you want to have?");
            System.out.println("Please don't enter a number or the program will crash");
            numBreaks = input.nextInt();
        }
        input.close();
        for (int i = 0; i < numBreaks; i++) { 
            try {
                System.out.println("It is time to study!");
                music(true);
                clock.sleep(timeStudy);
                music(false);
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
    public static void music(boolean study) {
        String url;
        if (study) {
            url = "https://www.youtube.com/watch?v=sjkrrmBnpGE";
        }
        else {
            url = "https://www.youtube.com/watch?v=6riDJMI-Y8U";
        }
        Runtime runtime = Runtime.getRuntime();
        try {
            Desktop desktop = java.awt.Desktop.getDesktop();
            desktop.browse(new URI(url));
        } 
        catch (Exception e) {
            try {
                System.out.println("Loading");
                runtime.exec("xdg-open " + url);
            }
            catch (IOException iox) {
                System.out.println("Error");
                System.out.println(e.getMessage());
            }
        }
    }
}
