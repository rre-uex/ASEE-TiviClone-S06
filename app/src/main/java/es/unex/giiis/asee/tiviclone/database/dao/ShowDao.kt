package es.unex.giiis.asee.tiviclone.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import es.unex.giiis.asee.tiviclone.data.model.Show

@Dao
interface ShowDao {
    @Query("SELECT * FROM show")
    suspend fun getAll(): List<Show>

    @Query("SELECT * FROM show WHERE id = :id")
    suspend fun findById(id: Int): Show

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(show: Show)

    @Delete
    suspend fun delete(show: Show)

}