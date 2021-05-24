import java.util.*;
import java.text.*;
/**
 * @author Karthik Bhattaram
 * @version 5/14/2021
 * @sources None
 */
public class AcademicTask extends Task{
    private Date dueDate;
    /**
     * Makes a new AcademicTask object
     * @param description What the task is
     * @param dueDate When the task is due
     */
    public AcademicTask(String description, Date dueDate) {
        this.description = description;
        this.dueDate = dueDate;
    }
}
