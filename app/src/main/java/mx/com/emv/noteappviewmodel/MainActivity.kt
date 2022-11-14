package mx.com.emv.noteappviewmodel

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import mx.com.emv.noteappviewmodel.data.NoteDataSource
import mx.com.emv.noteappviewmodel.model.Note
import mx.com.emv.noteappviewmodel.screen.NoteScreen
import mx.com.emv.noteappviewmodel.screen.NoteViewModel
import mx.com.emv.noteappviewmodel.ui.theme.NoteAppViewModelTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NoteAppViewModelTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val notesViewModel: NoteViewModel by viewModels()
                    NotesApp(notesViewModel = notesViewModel)
                    /*val notes =  remember {
                        mutableStateListOf<Note>()
                    }
                    NoteScreen(
                        notes = notes,
                        onAddNote = {
                            notes.add(it)
                        },
                        onRemoveNote = {
                            notes.remove(it)
                        }
                    )*/
                }
            }
        }
    }
}

@Composable
fun NotesApp(notesViewModel: NoteViewModel = viewModel()){
    val notesList = notesViewModel.getAllNotes()
    NoteScreen(
        notes = notesList,
        onAddNote = {
            notesViewModel.addNote(it)
        },
        onRemoveNote = {
            notesViewModel.removeNote(it)
        }
    )
}