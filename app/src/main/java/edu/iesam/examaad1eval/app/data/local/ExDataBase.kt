package edu.iesam.examaad1eval.app.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import edu.iesam.examaad1eval.features.ex2.data.local.db.GameDao
import edu.iesam.examaad1eval.features.ex2.data.local.db.GameEntity

@Database(entities = [GameEntity::class], version = 1, exportSchema = false)
abstract class ExDataBase : RoomDatabase() {
    abstract fun gameDao() : GameDao
}