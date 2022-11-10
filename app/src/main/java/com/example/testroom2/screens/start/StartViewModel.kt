package com.example.testroom2.screens.start

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.testroom2.REPOSITORY
import com.example.testroom2.db.NoteDatabase
import com.example.testroom2.db.repository.NoteRealization
import com.example.testroom2.model.NoteModel

class StartViewModel(application: Application) : AndroidViewModel(application) {

    val context = application

    fun initDatabase() {
        val daoNote = NoteDatabase.getInstance(context).getNoteDao()
        REPOSITORY = NoteRealization(daoNote)
    }

    fun getAllNotes(): LiveData<List<NoteModel>> {
        return REPOSITORY.allNotes

    }
}