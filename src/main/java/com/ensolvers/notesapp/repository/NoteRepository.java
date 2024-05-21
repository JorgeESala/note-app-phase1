package com.ensolvers.notesapp.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ensolvers.notesapp.model.Note;

public interface NoteRepository extends JpaRepository<Note, Integer> {
	
	Optional<Note> findById(Integer id);
	Optional<Note> findByName(String name);
	List<Note> findByActive(Boolean isActive);
	Note deleteByName(String name);
	Boolean existsByName(String name);
}
