public class Note {
    //section stores the section of the note
    //for example, it could contain the following
    //"Lynbrook High School", "Computer Science", "Data Structures", "Maps"
    private LinkedList<String> section;
    private String contents;

    public Note(LinkedList<String> section) {
        this.section = section;
    }
    public Note(String section, String contents) {
        this.section = section;
        this.contents = contents;
    }
    public void setSection(LinkedList<String> section) {
        this.section = section;
    }
    public void setContents(String contents) {
        this.contents = contents;
    }
}
