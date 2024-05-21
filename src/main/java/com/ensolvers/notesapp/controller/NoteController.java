package com.ensolvers.notesapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ensolvers.notesapp.model.Note;
import com.ensolvers.notesapp.service.NoteService;

@CrossOrigin
@RestController
@RequestMapping("api/notes")
public class NoteController {

	@Autowired
	private NoteService service;
	
	@CrossOrigin
	@GetMapping
	public ResponseEntity<List<Note>> getNotes(){
		return new ResponseEntity<List<Note>>(service.getNotes(), HttpStatus.OK);
	}
	@GetMapping("active")
	public ResponseEntity<List<Note>> getActiveNotes(){
		return new ResponseEntity<List<Note>>(service.findByActive(true), HttpStatus.OK);
	}
	@GetMapping("archived")
	public ResponseEntity<List<Note>> getArchivedNotes(){
		return new ResponseEntity<List<Note>>(service.findByActive(false), HttpStatus.OK);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Note> findNoteById(@PathVariable Integer id) {
		return new ResponseEntity<Note>(service.getNoteById(id), HttpStatus.OK);
	}
	
	
//	@GetMapping("api/notes/{name}")
//	public Note findNoteByName(@PathVariable String name) {
//		return service.getNoteByName(name);
//	}
	@CrossOrigin
	@PutMapping("{id}")
	public ResponseEntity<Note> updateNote(@PathVariable Integer id, @RequestBody Note note) {
		Note updatedNote = service.updateNote(note);
		
		return new ResponseEntity<Note>(updatedNote, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Note> createNote(@RequestBody Note note) {
		Note createdNote = service.createNote(note);
		return new ResponseEntity<Note>(createdNote, HttpStatus.CREATED);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Void> deleteNote(@PathVariable Integer id){
		
		 if( service.deleteNote(id)) {
			 return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		 }else {
			 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		 }
	}
	
}
