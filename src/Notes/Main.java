import java.util.*;
/**
 * This takes in user input
 * The main method for file io and user IO
 * @author Karthik Bhattaram
 * @version 5/21/2021
 * @source None
 */
public class Main
{
	public static void main(String[] args) 
	{
		/*
		Note cs = new Note("Computer Science");
		Note netwk = new Note("Networking", 
			"Various protocols and connections between computers");
		Note netsec = new Note("Security",
			"Maintaining confidentiality, integrity, and availability with computer networks");
		netwk.addNote(netsec);
		cs.addNote(netwk);
		Note hardware = new Note("Hardware", 
			"Parts of a computer, like the CPU, motherboard, GPU, peripherals, etc.");
		cs.addNote(hardware);
		cs.printNotes(0);
		*/
		//each time a new note is added, it is added to a TreeMap
		int noteIndex = 1;
		TreeMap<Integer, Note> treeNote = new TreeMap<Integer, Note>();
		Scanner cin = new Scanner(System.in);
		while (true) {
			String userInput = "";
			while (userInput.equals("")) {
				System.out.println("Enter nn for a new note");
				System.out.println("Enter 'exit' if you wish to exit");
				userInput = cin.next();
			}
			if (userInput.equals("nn")) {
				String section = "";
				System.out.println("what is the section name?");
				while (section.equals(""))
				{
					section = cin.nextLine();
				}
				System.out.println("what are the contents? enter ~ if there are none");
				String contents = "";
				while (contents.equals("")) {
					contents = cin.nextLine();
				}
				Note newNote;
				if (contents.equals("~")) {
					newNote = new Note(section, noteIndex);
				}
				else {
					newNote = new Note(section, contents, noteIndex);
				}
				if (treeNote.size() == 0) {
					treeNote.put(1, newNote);
				}
				else if (treeNote.size() == 1) {
					//then we must add it to the note that
					//has 1 as its key
					treeNote.get(1).addNote(newNote);
					treeNote.put(noteIndex, newNote);
				}
				else {
					//if there are multiple notes, we will 
					//need to ask the user which note this new 
					//note should be added to
					//user the next integer input
					//as a key for the treeNote
					//map, then add this note to
					//the corresponding note
					int index = -1;
					System.out.println("What note should it be added to?");
					while (index == -1)
					{
						index = cin.nextInt();
					}
					Integer objIndex = index;
					treeNote.get(objIndex).addNote(newNote);
					treeNote.put(noteIndex, newNote);
				}
				noteIndex++;
			}
			treeNote.get(1).printNotes(0);
			if (userInput.equals("exit"))
			{
				break;
			}
		}
		if (treeNote.size() >= 1) {
			treeNote.get(1).printNotes(0);
		}
		else {
			System.out.println("None");
		}
		cin.close();
	}
}