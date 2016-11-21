package controller;

import cdm.NoteRQ;
import model.Note;
import model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import repository.NoteRepository;
import repository.UserRepository;

/**
 * @Author Mateusz Wieczorek on 20.11.2016.
 */
@RestController
@RequestMapping("/mobile/")
public class NoteController {

    private static final Logger log = LoggerFactory.getLogger(NoteController.class);

    @Autowired
    private NoteRepository noteRepository;

    @Autowired
    private UserRepository userRepository;

    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = "/setNote", method = RequestMethod.POST, consumes = "application/json")
    public void setNote(@RequestHeader("email") String email,
                     @RequestBody NoteRQ note) {
        log.info("setNote invoked.");
        User user = userRepository.findByEmail(email);
        for (Note n : note.getNotes()) {
            n.setUser(user);
            noteRepository.save(n);
        }
        log.info("setNote finished. Send response.");
    }

    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = "/deleteNote", method = RequestMethod.DELETE, consumes = "application/json")
    public void deleteNote(@RequestHeader("email") String email,
                           @PathVariable("id") long id) {
        log.info("deleteNote invoked.");
        Note note = noteRepository.findOne(id);
        noteRepository.delete(note);
        log.info("deleteNote finished. Send response.");
    }
}
