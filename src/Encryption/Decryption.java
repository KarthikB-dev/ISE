import java.util.concurrent.*;
import java.util.Scanner;
import java.io.*;
import java.net.*;
import java.awt.Desktop;
/**
 * Decryption of .gpg files
 * This preserves the availability of the CIA triad
 * This requires the installation of GNU PG
 * @author Karthik Bhattaram
 * @version 1.0
 * @source None
 */
public class Decryption {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        System.out.println("Enter 1 to decrypt notes, 2 to decrypt tasks");
        int num = cin.nextInt();
        String fname = "";
        //Make sure to change this path to the correct one on your computer!!!
        String command = "gpg /home/impacable/ISE/";
        if (num == 1) {
            fname = "notes.txt.gpg";
        }
        else if (num == 2) {
            fname = "Tasks.txt.gpg";
        }
        else {
            System.out.println("Battlship BISMARCK!!!!");
            String url = "https://www.youtube.com/watch?v=7K9BJhlt0zo";
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
        try {
            Runtime rt = Runtime.getRuntime();
            rt.exec(command + fname);
            TimeUnit clock = TimeUnit.SECONDS;
            try {
                clock.sleep(30L);
            }
            catch (InterruptedException ie) {
                ie.printStackTrace();
            }
			rt.exec("rm /home/impacable/ISE/" + fname);
        }
        catch (IOException iox) {
            System.out.println("ERROR PLATFORM NOT SUPPORTED");
        }
        cin.close();
    }
}