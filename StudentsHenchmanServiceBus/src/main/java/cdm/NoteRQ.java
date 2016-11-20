package cdm;

import model.Note;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author Mateusz Wieczorek on 20.11.2016.
 */
public class NoteRQ {

    private Set<Note> notes = new HashSet<>();

    public Set<Note> getNotes() {
        return notes;
    }

    public void setNotes(Set<Note> notes) {
        this.notes = notes;
    }
}
