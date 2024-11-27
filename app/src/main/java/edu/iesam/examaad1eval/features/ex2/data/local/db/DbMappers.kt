package edu.iesam.examaad1eval.features.ex2.data.local.db

import edu.iesam.examaad1eval.features.ex2.Game
import edu.iesam.examaad1eval.features.ex2.Player

fun Game.toEntity() : GameEntity {
    return GameEntity(this.id, this.title)
}

fun Player.toEntity(gameId: String) : PlayerEntity {
    return PlayerEntity(this.id, this.name, gameId)
}

