import java.util.*;
/**
 * This takes in user input
 */
public class Main
{
	public static void main(String[] args) {
		Note cs = new Note("Computer Science");
		Note netwk = new Note("Networking", 
			"Various protocols and connections between computers");
		Note netsec = new Note("Security",
			"Maintaining confidentiality, integrity, and availability with computer networks");
		netwk.addNote(netsec);
		cs.addNote(netwk);
		Note hardware = new Note("Hardware", 
			"Parts of a computer, like the CPU, Mobo, GPU, Peripherals, etc.");
		cs.addNote(hardware);
		cs.printNotes(0);
		

	}
}
