package edu.iesam.examaad1eval.features.ex2.data.local.db

import edu.iesam.examaad1eval.features.ex2.Player

data class Players (private val player: List<Player>) {
    fun getPlayer() : List<Player> {
        return this.player
    }
}