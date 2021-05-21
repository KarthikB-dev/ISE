import java.util.*;
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
    /**
     * Creates a new Note object 
     * @param section The section of the note
     */
    public Note(String section) {
        this.section = section;
    }
    /**
     * Creates a new Note object 
     * @param section The section of the note
     * @param contents the contents of the note
     */
    public Note(String section, String contents) {
        this.section = section;
        this.contents = contents;
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
    public void printNotes() {
        System.out.println(this.section);
        if (this.hasContents()) {
            System.out.println("    * = " + this.contents);
        }
        if (this.hasSubNotes()) {
            for (Note subNote: subNotes) {
                subNote.printNotes();
            }
        }
    }
}