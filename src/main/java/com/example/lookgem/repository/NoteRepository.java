package com.example.lookgem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.lookgem.model.Note;

public interface NoteRepository extends JpaRepository<Note, Long> {

}
