package com.guilhermekunz.cleanarchitecturenoteapp.feature_note.presentation.notes

import com.guilhermekunz.cleanarchitecturenoteapp.feature_note.domain.model.Note
import com.guilhermekunz.cleanarchitecturenoteapp.feature_note.domain.util.NoteOrder

sealed class NotesEvent {
    data class Order(val noteOrder: NoteOrder): NotesEvent()
    data class DeleNote(val note: Note): NotesEvent()
    object RestoreNote: NotesEvent()
    object ToggleOrderSection: NotesEvent()
}
