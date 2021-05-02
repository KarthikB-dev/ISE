import java.io.*;
import java.net.*;
import java.awt.Desktop;
public class Website {
    public static void main(String[] args) {
        music(false);
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