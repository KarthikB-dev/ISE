import java.util.*;
/**
 * A class for managing notes
 */
public class Note {
    //section stores the section of the note
    //for example, it could contain the following
    //"Lynbrook High School", "Computer Science", "Data Structures", "Maps"
    private LinkedList<String> section;
    private String contents;
    /**
     * Creates a new Note object 
     * @param section The section of the note
     */
    public Note(LinkedList<String> section) {
        this.section = section;
    }
    /**
     * Creates a new Note object 
     * @param section The section of the note
     * @param contents the contents of the note
     */
    public Note(LinkedList<String> section, String contents) {
        this.section = section;
        this.contents = contents;
    }
    /**
     * Modifies the current Note
     */
    public void setSection(LinkedList<String> section) {
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
    public LinkedList<String> getSection() {
        return this.section;
    }
    /**
     * Returns the note's contents
     */
    public String getContents() {
        return this.contents;
    }
}
