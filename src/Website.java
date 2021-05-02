import java.io.*;
import java.net.*;
import java.util.Scanner;
import java.awt.desktop.*;
public class Website {
    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();
        String study_url = "https://www.youtube.com/watch?v=sjkrrmBnpGE";

        try {
            System.out.println("Loading");
            runtime.exec("xdg-open " + study_url);
        }
        catch (IOException e) {
            System.out.println("Error");
            System.out.println(e.getMessage());
        }
    }
}