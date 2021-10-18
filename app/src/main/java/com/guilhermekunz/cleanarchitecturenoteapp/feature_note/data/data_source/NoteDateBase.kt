package com.guilhermekunz.cleanarchitecturenoteapp.feature_note.data.data_source

import androidx.room.Database
import com.guilhermekunz.cleanarchitecturenoteapp.feature_note.domain.model.Note

@Database(
    entities = [Note::class],
    version = 1
)

abstract class NoteDateBase {

    abstract val noteDao: NoteDao

}