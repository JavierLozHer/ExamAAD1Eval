package edu.iesam.examaad1eval.features.ex2.data.local.db

import com.google.gson.Gson
import edu.iesam.examaad1eval.features.ex2.Game

fun Game.toEntity(gson: Gson) : GameEntity {
    return GameEntity(this.id, this.title, gson.toJson(this.player))
}
