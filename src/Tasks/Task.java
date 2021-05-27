import java.util.*;
import java.io.*;
public class Task {
	//tasks should have subtasks
    //for example, a task of learning react
    //js could have a subtask of learning syntax
    //building a simple webapp, etc.
    private ArrayList<Task> subtasks;
    private String description;
    private int index;
    /**
     * Makes a new Task object
     * @param description What to complete
     * @param index The task's number
     */
    public Task(String description, int index) {
        this.description = description;
        this.index = index;
        this.subtasks = new ArrayList<Task>();
    }
    /**
     * Adds a new component task
     * @param subTask A task to be a part of this one
     */
    public void addTask(Task subTask) {
        this.subtasks.add(subTask);
    }
    /**
     * Getter method for the Task description
     * @return The method's description
     */
    public String getDescription() {
        return this.description;
    }
    /**
     * Determines if this task contains other tasks
     * @return True if this task has other tasks within it
     */
    public boolean hasSubTasks() {
        return this.subtasks.size() > 0;
    }
    /**
     * Prints all the Tasks and sub Tasks
     */
    public void printTasks(int numTabs) {
        StringBuffer tabString = new StringBuffer("");
        for (int i = 0; i < numTabs; i++) {
            tabString.append('\t');
        }
        System.out.print(tabString + this.description);
        System.out.println(" (" + this.index + ")");
        if (this.hasSubTasks()) {
            for (Task subTask: subtasks) {
                subTask.printTasks(numTabs + 1);
            }
        }
    }
    /**
     * Writes the Tasks to a file
     */
    public void writeTasks(int numTabs, FileWriter fout) {
        try {
            StringBuffer tabString = new StringBuffer("");
            for (int i = 0; i < numTabs; i++) {
                tabString.append('\t');
            } 
            fout.write(tabString + this.description);
            fout.write(" (" + this.index + ")");
            fout.write('\n');
            if (this.hasSubTasks()) {
                for (Task subTask: subtasks) {
                    subTask.writeTasks(numTabs + 1, fout);
                }
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        
    }
}
