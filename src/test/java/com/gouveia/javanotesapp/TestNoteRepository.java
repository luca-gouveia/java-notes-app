package com.gouveia.javanotesapp;


import com.gouveia.javanotesapp.model.Note;
import com.gouveia.javanotesapp.repository.NoteRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) //testa no proprio postgres
public class TestNoteRepository {
    @Autowired
    private NoteRepository noteRepository;

    @Test
    public void testFindById() {
        Note note = new Note("Title", "...", false, "white");
        noteRepository.save(note);
        Note noteFinded = noteRepository.findById(note.getId());
        Assert.assertEquals(note, noteFinded);
    }

    @Test
    public void testSave() {
        Note note = new Note("Title", "...", false, "white");
        Note noteSaved = noteRepository.save(note);

        Assert.assertNotNull(noteSaved.getId());
    }

    @Test
    public void testFindAllByStateActives() {
        List<Note> notes = noteRepository.findAllByState(true);
        Note noteE = new Note("Title", "...", true, "white");

        for(Note note : notes)
            Assert.assertEquals(noteE.isState(), note.isState());
    }

    @Test
    public void testFindAllByStateDone() {
        List<Note> notes = noteRepository.findAllByState(false);
        Note noteE = new Note("Title", "...", false, "white");

        for(Note note : notes)
            Assert.assertEquals(noteE.isState(), note.isState());
    }
}

