package com.example.testroom2.db.repository

import androidx.lifecycle.LiveData
import com.example.testroom2.db.dao.NoteDao
import com.example.testroom2.model.NoteModel

class NoteRealization(private val noteDao: NoteDao) : NoteRepository {

    override val allNotes: LiveData<List<NoteModel>>
        get() = noteDao.getALlNotes()

    override suspend fun insertNote(noteModel: NoteModel, onSuccess: () -> Unit) {
        noteDao.insert(noteModel)
        onSuccess()
    }

    override suspend fun deleteNote(noteModel: NoteModel, onSuccess: () -> Unit) {
        noteDao.delete(noteModel)
        onSuccess()
    }
}