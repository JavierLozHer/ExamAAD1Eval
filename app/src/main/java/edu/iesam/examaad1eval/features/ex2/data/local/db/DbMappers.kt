package edu.iesam.examaad1eval.features.ex2.data.local.db

import com.google.gson.Gson
import edu.iesam.examaad1eval.features.ex2.Game

fun Game.toEntity(gson: Gson) : GameEntity {
    val players = Players(this.player)
    return GameEntity(this.id, this.title, gson.toJson(players))
}

fun GameEntity.toModel(gson: Gson) : Game {
    val players = gson.fromJson(this.player, Players::class.java)
    return Game(this.id, this.title, players.getPlayer())
}
