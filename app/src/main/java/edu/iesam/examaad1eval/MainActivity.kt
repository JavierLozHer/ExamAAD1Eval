package edu.iesam.examaad1eval

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import edu.iesam.examaad1eval.features.ex1.data.Ex1DataRepository
import edu.iesam.examaad1eval.features.ex1.data.local.Ex1XmlLocalDataSource
import edu.iesam.examaad1eval.features.ex1.data.remote.MockEx1RemoteDataSource
import androidx.room.Room
import edu.iesam.examaad1eval.app.data.local.ExDataBase
import edu.iesam.examaad1eval.features.ex2.data.Ex2DataRepository
import edu.iesam.examaad1eval.features.ex2.data.local.db.Ex2DbDataSource
import edu.iesam.examaad1eval.features.ex2.data.remote.MockEx2RemoteDataSource
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        executeExercise1()
        executeExercise2()
    }

    private fun executeExercise1(){
        //Ejecutar el ejercicio 1 desde aquí llamando al Ex1DataRepository directamente
        val ex1DataRepository = Ex1DataRepository(MockEx1RemoteDataSource(), Ex1XmlLocalDataSource(this))

        val users = ex1DataRepository.getUsers()
        Log.d("@dev", users.toString())

        val products = ex1DataRepository.getItems()
        Log.d("@dev", products.toString())

        val services = ex1DataRepository.getServices()
        Log.d("@dev", services.toString())
    }

    @OptIn(DelicateCoroutinesApi::class)
    private fun executeExercise2(){
        //Ejecutar el ejercicio 2 desde aquí llamando al Ex2DataRepository directamente
        val db = Room.databaseBuilder(this, ExDataBase::class.java, "examAAD").build()
        GlobalScope.launch {
            //llamar a Room
            val ex2DataRepository = Ex2DataRepository(MockEx2RemoteDataSource(), Ex2DbDataSource(db.gameDao(), db.playerDao()))
            ex2DataRepository.getGames()
        }
    }
}