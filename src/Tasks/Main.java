import java.util.*;
import java.io.*;
/**
 * This takes in user input
 * The main method for file io and user IO
 * @author Karthik Bhattaram
 * @version 5/23/2021
 * @source https://www.w3schools.com/java/java_files_create.asp
 */
public class Main {
    public static void main(String[] args) 
	{
        int taskIndex = 1;
		TreeMap<Integer, Task> treeTask = new TreeMap<Integer, Task>();
		Scanner cin = new Scanner(System.in);
		while (true) {
			String userInput = "";
			while (userInput.equals("")) {
				System.out.println("Enter nt for a new Task");
				System.out.println("Enter 'exit' if you wish to exit");
				userInput = cin.next();
			}
			if (userInput.equals("nt")) {
				String description = "";
				System.out.println("what is the description?");
				while (description.equals(""))
				{
					description = cin.nextLine();
				}
				Task newTask = new Task(description, taskIndex);
				if (treeTask.size() == 1) {
					//then we must add it to the Task that
					//has 1 as its key
					treeTask.get(1).addTask(newTask);
				}
				else if (treeTask.size() > 1) {
					//if there are multiple Tasks, we will 
					//need to ask the user which Task this new 
					//Task should be added to
					//user the next integer input
					//as a key for the treeTask
					//map, then add this Task to
					//the corresponding Task
					int index = -1;
					System.out.println("What Task should it be added to?");
					while (index == -1)
					{
						index = cin.nextInt();
					}
					Integer objIndex = index;
					treeTask.get(objIndex).addTask(newTask);
				}
				treeTask.put(taskIndex, newTask);
				taskIndex++;
				treeTask.get(1).printTasks(0);
			}
			if (userInput.equals("exit"))
			{
				break;
			}
		}
		if (treeTask.size() >= 1) {
			//write the Tasks to a file
			try {
				File outFile = new File("/home/impacable/ISE/Tasks.txt");
				outFile.createNewFile();
				FileWriter fout = new FileWriter("/home/impacable/ISE/Tasks.txt");
				treeTask.get(1).writeTasks(0, fout);
				fout.close();
			} catch (IOException e) {
				System.out.println("IO Exception");
			}
		}
		else {
			System.out.println("None");
		}
		cin.close();
    }
}
