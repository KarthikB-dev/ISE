import java.util.concurrent.*;
import java.util.Scanner;
/**
 * Encrypts all your notes and tasks!
 * Uses AES 256 encryption, so the weak point is most likely your password.
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
			String currDir = System.getProperty("user.dir");
            String path = currDir.substring(0, currDir.indexOf("src")) + "notes.txt";
			runtime.exec("gpg -c --no-symkey-cache --cipher-algo AES256 " + path);
            //removes the file
            TimeUnit clock = TimeUnit.SECONDS;
            clock.sleep(30L);
			runtime.exec("rm " + path);
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
            String currDir = System.getProperty("user.dir");
            String path = currDir.substring(0, currDir.indexOf("src")) + "Tasks.txt";
			runtime.exec("gpg -c --no-symkey-cache --cipher-algo AES256 " + path);
            //removes the file
            TimeUnit clock = TimeUnit.SECONDS;
            clock.sleep(30L);
			runtime.exec("rm " + path);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
    }
    /**
     * User input for whether notes or tasks should be encrypted
     * @param args
     */
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
