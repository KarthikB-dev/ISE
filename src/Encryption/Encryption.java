import java.util.concurrent.*;
import java.util.Scanner;
import java.io.*;
import java.net.*;
import java.awt.Desktop;
/**
 * A study timer class
 * This is a study timer that uses the pomodoro technique of studying
 * @author Karthik Bhattaram
 * @version 1.0
 * @sources None
 */
public class Encryption {
    /**
     * Encrypts the user's notes file
     */
    public static void encryptNotes() {
        Runtime runtime = Runtime.getRuntime();
		try {
			//make sure to replace the file path with the correct one on your computer!
			runtime.exec("gpg -c --no-symkey-cache --cipher-algo AES256 /home/impacable/ISE/notes.txt");
            //removes the file
            TimeUnit clock = TimeUnit.SECONDS;
            clock.sleep(30L);
			runtime.exec("rm /home/impacable/ISE/notes.txt");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
    }
    /**
     * Encrypts the users' tasks file
     */
    public static void encryptTasks() {
        Runtime runtime = Runtime.getRuntime();
		try {
			//make sure to replace the file path with the correct one on your computer!
			runtime.exec("gpg -c --no-symkey-cache --cipher-algo AES256 /home/impacable/ISE/Tasks.txt");
            //removes the file
			runtime.exec("rm /home/impacable/ISE/Tasks.txt");
            TimeUnit clock = TimeUnit.SECONDS;
            clock.sleep(30L);
			runtime.exec("rm /home/impacable/ISE/Tasks.txt");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
    }
    public static void main(String[] args) {
        System.out.print("Enter 1 if you wish to encrypt your notes, 2 if you wish to encrypt tasks,");
        System.out.println(" and 3 if none");
        Scanner cin = new Scanner(System.in);
        int cinput = cin.nextInt();
        if (cinput == 1) {
            encryptNotes();
        }
        else if (cinput == 2) {
            encryptTasks();
        }
        else {
            System.out.println("Have a nice day!");
        }
        cin.close();
    }
}
