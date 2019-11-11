package com.gouveia.javanotesapp.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "tb_note")
public class Note {
    @Id
    @GeneratedValue
    private long id;
    @NotEmpty
    private String title;
    @NotEmpty
    private String body;
    private boolean state = true; // Ativa ou Concluida
    @NotEmpty
    private String color;

    public Note() {

    }

    public Note(@NotEmpty String title, @NotEmpty String body, boolean state, @NotEmpty String color) {
        this.title = title;
        this.body = body;
        this.state = state;
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }
}
