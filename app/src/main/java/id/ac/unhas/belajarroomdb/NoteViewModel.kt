package id.ac.unhas.belajarroomdb

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import kotlinx.coroutines.InternalCoroutinesApi

class NoteViewModel(application: Application) : AndroidViewModel(application) {


    @InternalCoroutinesApi
    private var noteRepository = NoteRepository(application)

    @InternalCoroutinesApi
    private var notes: LiveData<List<Note>>? = noteRepository.getNotes()


    @InternalCoroutinesApi
    fun insertNote(note: Note) {
        noteRepository.insert(note)
    }


    @InternalCoroutinesApi
    fun getNotes(): LiveData<List<Note>>? {
        return notes
    }


    @InternalCoroutinesApi
    fun deleteNote(note: Note) {
        noteRepository.delete(note)
    }


    @InternalCoroutinesApi
    fun updateNote(note: Note) {
        noteRepository.update(note)
    }
}