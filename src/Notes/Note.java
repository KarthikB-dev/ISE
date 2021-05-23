import java.util.*;
import java.io.*;
/**
 * A class for managing notes
 */
public class Note {
    //section stores the section of the note
    //for example, it could contain the following
    //"Lynbrook High School", "Computer Science", "Data Structures", "Maps"
    private String section;
    private String contents;
    private ArrayList<Note> subNotes;
    int index;
    /**
     * Creates a new Note object 
     * @param section The section of the note
     */
    public Note(String section) {
        this.section = section;
        this.subNotes = new ArrayList<Note>();
    }
    /**
     * Creates a new Note object 
     * @param section The section of the note
     */
    public Note(String section, int index) {
        this.section = section;
        this.subNotes = new ArrayList<Note>();
        this.index = index;
    }
    /**
     * Creates a new Note object 
     * @param section The section of the note
     * @param contents the contents of the note
     */
    public Note(String section, String contents) {
        this.section = section;
        this.contents = contents;
        this.subNotes = new ArrayList<Note>();
    }
    /**
     * Creates a new Note object 
     * @param section The section of the note
     * @param contents the contents of the note
     * @param index The index of the note
     */
    public Note(String section, String contents, int index) {
        this.section = section;
        this.contents = contents;
        this.subNotes = new ArrayList<Note>();
        this.index = index;
    }
    /**
     * Modifies the current Note
     */
    public void setSection(String section) {
        this.section = section;
    }
    /**
     * Changes the note's contents
     */
    public void setContents(String contents) {
        this.contents = contents;
    }
    /**
     * Returns the Note's section
     */
    public String getSection() {
        return this.section;
    }
    /**
     * Returns the note's contents
     */
    public String getContents() {
        return this.contents;
    }
    /**
     * Adds a new note to this one
     * @param newNote The new note to be added
     */
    public void addNote(Note newNote) {
        this.subNotes.add(newNote);
    }
    /**
     * Checks if the note is a note and not just a section header
     * @return If contents are not null
     */
    public boolean hasContents() {
        return this.contents != null;
    }
    /**
     * Checks if this note contains notes
     * @return If subNotes is not empty
     */
    public boolean hasSubNotes() {
        return this.subNotes.size() != 0;
    }
    /**
     * Prints all the notes and sub notes
     */
    public void printNotes(int numTabs) {
        StringBuffer tabString = new StringBuffer("");
        for (int i = 0; i < numTabs; i++) {
            tabString.append('\t');
        }
        System.out.print(tabString + this.section);
        System.out.println(" (" + this.index + ")");
        if (this.hasContents()) {
            System.out.println(tabString + "    * = " + this.contents);
        }
        if (this.hasSubNotes()) {
            for (Note subNote: subNotes) {
                subNote.printNotes(numTabs + 1);
            }
        }
    }
    /**
     * Writes the notes to a file
     */
    public void writeNotes(int numTabs) {
        try {
            //change this to the correct file path on your computer!
            //note that Microsoft Windows paths have back slashes
            File outFile = new File("~/ISE/notes.txt");
            if (outFile.createNewFile()) {
                FileWriter fout = new FileWriter("~/ISE/notes.txt");
                StringBuffer tabString = new StringBuffer("");
                for (int i = 0; i < numTabs; i++) {
                    tabString.append('\t');
                }
                fout.write(tabString + this.section);
                fout.write(" (" + this.index + ")");
                fout.write('\n');
                if (this.hasContents()) {
                    fout.write(tabString + "    * = " + this.contents);
                    fout.write('\n');
                }
                if (this.hasSubNotes()) {
                    for (Note subNote: subNotes) {
                        subNote.printNotes(numTabs + 1);
                    }
                }
                fout.close();
            }
            else {
                System.out.println("File already exists");
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        
    }
}