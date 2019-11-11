package com.gouveia.javanotesapp.repository;

import com.gouveia.javanotesapp.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {
    Note findById(long id);

    @Query("select n from Note n where n.state=:state")
    public List<Note> findAllByState(@Param("state") boolean state);

}
