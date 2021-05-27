import java.util.*;
/**
 * @author Karthik Bhattaram
 * @version 5/14/2021
 * @sources None
 */
public class AcademicTask extends Task{
    private Date dueDate;
    /**
     * Makes a new AcademicTask object
     * @param index The tasks' number
     * @param description What the task is
     * @param dueDate When the task is due
     */
    public AcademicTask(int index, String description, Date dueDate) {
        super(description, index);
        this.dueDate = dueDate;
    }
    /**
     * Gets the task's due date
     * @return The date by which this task must be completed.
     */
    public Date getDate() {
        return this.dueDate;
    }
}
