package com.ensolvers.notesapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ensolvers.notesapp.model.Note;
import com.ensolvers.notesapp.repository.NoteRepository;

@Service
public class NoteService {

	@Autowired
	private NoteRepository noteRepository;
	
	public Note createNote(Note note) {
		note.setActive(true);
		note.setId(null);
		if(noteRepository.existsByName(note.getName())) {
			throw new IllegalStateException("Note with name " + note.getName() + " already exists");
		}
		return noteRepository.save(note);
	}
	
	public Note getNoteById(Integer id) {
		return noteRepository.findById(id).orElse(null);
	}
	
	public Note getNoteByName(String name) {
		return noteRepository.findByName(name).orElse(null);
	}
	
	public Boolean deleteNote(Integer id) {
		
		if(noteRepository.findById(id).isPresent()) {
			noteRepository.deleteById(id);
			return true;
		}
		
		return false;
	}
	
	public Boolean deleteByName(String name) {
		
		if(noteRepository.findByName(name).isPresent()) {
			noteRepository.deleteByName(name);
			return true;
		}
		
		return false;
	}
	
	public List<Note> getNotes(){
		return noteRepository.findAll();
	}
	
	public Note updateNote(Note note) {
		Note existingNote = noteRepository.findById(note.getId()).orElse(null);
		existingNote.setName(note.getName());
		existingNote.setText(note.getText());
		return noteRepository.save(existingNote);
	}
	
	public List<Note> findByActive(Boolean isActive){
		return noteRepository.findByActive(isActive);
	}
	
}
