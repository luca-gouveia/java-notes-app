package com.gouveia.javanotesapp.controller;

import com.gouveia.javanotesapp.model.Note;
import com.gouveia.javanotesapp.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.faces.application.Application;
import javax.faces.application.ViewHandler;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.util.Collections;
import java.util.List;

@Named
@ViewScoped
public class NoteController {
    @Autowired
    private NoteRepository noteRepository;
    private List<Note> notes;
    private List<Note> notesDone;
    private Note note = new Note();
    private boolean edit = false;
    private boolean showNotesDone = false;


    public boolean isEdit() {
        return edit;
    }

    public void setEdit(boolean edit) {
        this.edit = edit;
    }

    @PostConstruct // Serve para ser executado logo apos as injecoes de dependencias
    public void init(){
        notes = noteRepository.findAllByState(true);
        notesDone = noteRepository.findAllByState(false);
    }

    public List<Note> getNotes() {
        return notes;
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }

    public Note getNote() {
        return note;
    }

    public void setNote(Note note) {
        this.note = note;
    }

    public List<Note> getNotesDone() {
        return notesDone;
    }

    public void setNotesDone(List<Note> notesDone) {
        this.notesDone = notesDone;
    }

    public boolean isShowNotesDone() {
        return showNotesDone;
    }

    public void setShowNotesDone(boolean showNotesDone) {
        this.showNotesDone = showNotesDone;
    }
//Methods

    public void save(){

        if(edit) {
            noteRepository.save(note);
            note = new Note();
            setEdit(false);
            this.refresh();
        }else{
            noteRepository.save(note);
            note = new Note();
            notes.add(note);
            this.refresh();
        }

    }

    public void delete(Note n){
        noteRepository.delete(n);
        notes.remove(n);
        notesDone.remove(n);

    }

    public void edit(Note n){
        setNote(n);
        setEdit(true);
    }

    public void cancelEdit(){
        setEdit(false);
        note = new Note();
        setNote(note);

    }

    public void changeState(Note n){
        if(n.isState()){
            n.setState(false);
            notes.remove(n);
            notesDone.add(n);

        }else {
            n.setState(true);
            notes.add(n);
            notesDone.remove(n);
        }
        noteRepository.save(n);
    }

    public void showActives(){
        setShowNotesDone(false);
    }

    public void showDone(){
        setShowNotesDone(true);
    }

    public void refresh() {
        FacesContext context = FacesContext.getCurrentInstance();
        Application application = context.getApplication();
        ViewHandler viewHandler = application.getViewHandler();
        UIViewRoot viewRoot = viewHandler.createView(context, context.getViewRoot().getViewId());
        context.setViewRoot(viewRoot);
        context.renderResponse();
    }
}
