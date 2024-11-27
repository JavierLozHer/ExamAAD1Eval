package edu.iesam.examaad1eval.features.ex1.data

import edu.iesam.examaad1eval.features.ex1.Ex1Repository
import edu.iesam.examaad1eval.features.ex1.Item
import edu.iesam.examaad1eval.features.ex1.Services
import edu.iesam.examaad1eval.features.ex1.User
import edu.iesam.examaad1eval.features.ex1.data.local.Ex1XmlLocalDataSource
import edu.iesam.examaad1eval.features.ex1.data.remote.MockEx1RemoteDataSource

class Ex1DataRepository(
    private val mockEx1RemoteDataSource: MockEx1RemoteDataSource,
    private val ex1XmlLocalDataSource: Ex1XmlLocalDataSource
) : Ex1Repository {

    override fun getUsers(): List<User> {
        val usersLocal = ex1XmlLocalDataSource.getUsers()
        if (usersLocal == null) {
            val usersRemote = mockEx1RemoteDataSource.getUsers()
            ex1XmlLocalDataSource.saveUsers(usersRemote)
            return usersRemote
        } else {
            return usersLocal
        }
    }

    override fun getItems(): List<Item> {
        val productsLocal = ex1XmlLocalDataSource.getProducts()
        if (productsLocal == null) {
            val productsRemote = mockEx1RemoteDataSource.getItems()
            ex1XmlLocalDataSource.saveProducts(productsRemote)
            return productsRemote
        } else {
            return productsLocal
        }
    }

    override fun getServices(): List<Services> {
        val servicesLocal = ex1XmlLocalDataSource.getServices()
        if (servicesLocal == null) {
            val servicesRemote = mockEx1RemoteDataSource.getServices()
            ex1XmlLocalDataSource.saveServices(servicesRemote)
            return servicesRemote
        } else {
            return servicesLocal
        }
    }
}