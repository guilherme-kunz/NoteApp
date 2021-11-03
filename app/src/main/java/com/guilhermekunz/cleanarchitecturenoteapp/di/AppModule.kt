package com.guilhermekunz.cleanarchitecturenoteapp.di

import android.app.Application
import androidx.room.Room
import com.guilhermekunz.cleanarchitecturenoteapp.feature_note.data.data_source.NoteDateBase
import com.guilhermekunz.cleanarchitecturenoteapp.feature_note.data.repository.NoteRepositoryImpl
import com.guilhermekunz.cleanarchitecturenoteapp.feature_note.domain.repository.NoteRepository
import com.guilhermekunz.cleanarchitecturenoteapp.feature_note.domain.use_case.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideNoteDatabase(app: Application): NoteDateBase {
        return Room.databaseBuilder(
            app,
            NoteDateBase::class.java,
            NoteDateBase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideNoteRepository(db: NoteDateBase): NoteRepository {
        return NoteRepositoryImpl(db.noteDao)
    }

    @Provides
    @Singleton
    fun provideNoteUseCases(repository: NoteRepository): NoteUseCases {
        return NoteUseCases(
            getNotes = GetNotes(repository),
            deleteNote = DeleteNote(repository),
            addNote = AddNote(repository),
            getNote = GetNote(repository)
        )
    }
}