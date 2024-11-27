package edu.iesam.examaad1eval.features.ex2.data.local.db

import androidx.room.ColumnInfo
import androidx.room.Entity

const val PLAYER_TABLE_NAME = "player"
const val PLAYER_ID = "id"
const val GAME_FK = "game_id"

@Entity(tableName = PLAYER_TABLE_NAME, primaryKeys = [PLAYER_ID, GAME_FK])
class PlayerEntity (
    @ColumnInfo(name = PLAYER_ID) val id : String,
    @ColumnInfo(name = "name") val name : String,
    @ColumnInfo(name = GAME_FK) val gameId : String
)