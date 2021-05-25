import java.util.Scanner;
import java.util.concurrent.*;
import java.io.*;
import java.net.*;
import java.awt.Desktop;
/**
 * A study timer class
 * This is a study timer that uses the pomodoro technique of studying
 * @author Karthik Bhattaram
 * @version 1.0
 * @sources https://www.youtube.com/watch?v=LqRrCQbPcQI
 */
public class Timer 
{
    /** 
     * @param args
     * Creates the study timer
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        TimeUnit clock = TimeUnit.MINUTES;
        long timeStudy = 50L;
        long timeBreak = 10L;
        int numBreaks = 3;
        //determine if breaks should last 10 minutes
        //study sessions last 50 minutes, and we have
        //3 breaks/study combos
        //in essence, you have a 50 minute study session
        //followed by a 10 minute break. You repeat this
        //for a total of 3 hours
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
            System.out.println("How long do you want to study for?");
            try {
                timeStudy = input.nextLong();
            }
            catch (Exception e) {
                System.out.println("error: exiting program");
                input.close();
                return;
            }
            System.out.println("How long should breaks be?");
            try {
                timeBreak = input.nextLong();
            }
            catch (Exception e) {
                System.out.println("error: exiting program");
            }
            System.out.println("How many total sessions do you want to have?");
            try {
                numBreaks = input.nextInt();
            }
            catch (Exception e) {
                System.out.println("Invalid input. Please try to enter an integer.");
            }
        
            	    
        }
        input.close();
        for (int i = 0; i < numBreaks; i++) { 
            try {
                System.out.println("It is time to study!");
                music(true);
                //System.out.println("timeStudy is " + timeStudy);
                clock.sleep(timeStudy);
                music(false);
                System.out.println("It is time to take a break :)");
                //System.out.println("timeBreak is " + timeBreak);
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
     * Plays appropriate music
     */
    public static void music(boolean study) {
        String url;
        if (study) {
            url = "https://www.youtube.com/watch?v=lTRiuFIWV54";
        }
        else {
            url = "https://www.youtube.com/watch?v=iwG36P3_sYo";
        }
        Runtime runtime = Runtime.getRuntime();
        try {
            Desktop desktop = java.awt.Desktop.getDesktop();
            desktop.browse(new URI(url));
        } 
        catch (Exception e) {
            try {
                runtime.exec("xdg-open " + url);
            }
            catch (IOException iox) {
                System.out.println("Error");
                System.out.println(e.getMessage());
            }
        }
    }
}
