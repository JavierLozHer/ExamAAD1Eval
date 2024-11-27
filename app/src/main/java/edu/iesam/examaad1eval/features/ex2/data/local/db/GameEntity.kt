package edu.iesam.examaad1eval.features.ex2.data.local.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

const val GAME_TABLE_NAME = "games"
const val GAME_ID = "id"

@Entity(tableName = GAME_TABLE_NAME)
class GameEntity (
    @PrimaryKey @ColumnInfo(name = GAME_ID) val id : String,
    @ColumnInfo(name = "title") val title : String
)