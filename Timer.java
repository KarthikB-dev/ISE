import java.util.concurrent.*;

public class Timer 
{
    public static void main(String[] args) {
        
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
}
