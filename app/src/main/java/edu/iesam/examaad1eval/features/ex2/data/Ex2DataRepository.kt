package edu.iesam.examaad1eval.features.ex2.data

import edu.iesam.examaad1eval.features.ex2.Ex2Repository
import edu.iesam.examaad1eval.features.ex2.Game
import edu.iesam.examaad1eval.features.ex2.data.local.db.Ex2DbDataSource
import edu.iesam.examaad1eval.features.ex2.data.remote.MockEx2RemoteDataSource

class Ex2DataRepository(
    private val mockEx2RemoteDataSource: MockEx2RemoteDataSource,
    private val ex2DbDataSource: Ex2DbDataSource
) : Ex2Repository {
    override fun getGames(): List<Game> {
        val gamesLocal = ex2DbDataSource.getGames()
        if (gamesLocal.isEmpty()) {
            val gamesRemote = mockEx2RemoteDataSource.getGames()
            ex2DbDataSource.saveGames(gamesRemote)
            return gamesRemote
        } else {
            return gamesLocal
        }

    }
}