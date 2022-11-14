package mx.com.emv.noteappviewmodel.screen

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import mx.com.emv.noteappviewmodel.data.NoteDataSource
import mx.com.emv.noteappviewmodel.model.Note

class NoteViewModel: ViewModel() {
    var noteList = mutableStateListOf<Note>()

    init {
        noteList.addAll(NoteDataSource().loadNotes())
    }

    fun addNote(note: Note){
        noteList.add(note)
    }

    fun removeNote(note: Note){
        noteList.remove(note)
    }

    fun getAllNotes() = noteList
}