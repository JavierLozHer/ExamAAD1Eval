package edu.iesam.examaad1eval.features.ex2.data.local.db

import android.util.Log
import edu.iesam.examaad1eval.features.ex2.Game

class Ex2DbDataSource(
    private val gameDao: GameDao,
    private val playerDao: PlayerDao
) {

    fun saveGames(games: List<Game>) {
        val gameEntityList = games.map { it.toEntity() }
        gameDao.saveGames(*gameEntityList.toTypedArray())

        games.forEach { game ->
            val players = game.player
            val playerEntityList = players.map { it.toEntity(game.id) }
            playerDao.savePlayers(*playerEntityList.toTypedArray())
        }
    }

}