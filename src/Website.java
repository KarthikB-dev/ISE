import java.io.*;
import java.net.*;
import java.awt.Desktop;
public class Website {
    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();
        String study_url = "https://www.youtube.com/watch?v=sjkrrmBnpGE";
        try {
            Desktop desktop = java.awt.Desktop.getDesktop();
            desktop.browse(new URI(study_url));
        } 
        catch (Exception e) {
            try {
                System.out.println("Loading");
                runtime.exec("xdg-open " + study_url);
            }
            catch (IOException iox) {
                System.out.println("Error");
                System.out.println(e.getMessage());
            }
        }
    }
}