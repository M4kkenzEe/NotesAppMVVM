package com.example.testroom2.db.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.testroom2.model.NoteModel

@Dao
interface NoteDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(noteModel: NoteModel)

    @Delete
    suspend fun delete(noteModel: NoteModel)

    @Query("SELECT * from note_table")
    fun getALlNotes(): LiveData<List<NoteModel>>

}