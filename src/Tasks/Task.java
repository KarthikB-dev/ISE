import java.util.*;
public class Task {
	//tasks should have subtasks
    //for example, a task of learning react
    //js could have a subtask of learning syntax
    //building a simple webapp, etc.
    private ArrayList<Task> subtasks;
    //tasks can have a specific due date and time 
    //when they are due, they could be due at the end of 
    //the day, etc.
    private String description;
    /* Task.java
    subtasks + description
    personalTask.java
    time should be done each day (eg.) in the morning and
    night for brushing teeth, or going for a run in the evening
    how often should be done (daily, once every two days, once every 3
    , etc.)
    academicTask.java
    has a due date, has a priority, etc.
    */
    /**
     * Makes a new Task object
     * @param description What to complete
     */
    public void Task(String description) {
        this.description = description;
    }
    /**
     * Adds a new component task
     * @param subTask A task to be a part of this one
     */
    public void addTask(Task subTask) {
        this.subtasks.add(subTask);
    }
}
