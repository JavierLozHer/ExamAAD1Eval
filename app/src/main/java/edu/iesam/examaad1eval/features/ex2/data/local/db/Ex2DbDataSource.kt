package edu.iesam.examaad1eval.features.ex2.data.local.db

import android.util.Log
import com.google.gson.Gson
import edu.iesam.examaad1eval.features.ex2.Game

class Ex2DbDataSource(
    private val gameDao: GameDao
) {

    private val gson = Gson()

    fun saveGames(games: List<Game>) {
        val gameEntityList = games.map { it.toEntity(gson) }
        gameDao.saveGames(*gameEntityList.toTypedArray())
    }

}