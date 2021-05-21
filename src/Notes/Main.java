import java.util.*;
/**
 * This takes in user input
 */
public class Main
{
	public static void main(String[] args) {
		ArrayList<Note> notes;
		
		Note cs = new Note("Computer Science");
		Note netwk = new Note("Networking", 
			"Various protocols and connections between computers");
		Note netsec = new Note("Security",
			"Maintaining confidentiality, integrity, and availability with computer networks");
		netwk.addNote(netsec);
		cs.addNote(netwk);
		cs.printNotes();

	}
}
