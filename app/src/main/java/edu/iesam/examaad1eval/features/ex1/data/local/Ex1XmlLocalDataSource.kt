package edu.iesam.examaad1eval.features.ex1.data.local

import android.content.Context
import com.google.gson.Gson
import edu.iesam.examaad1eval.R
import edu.iesam.examaad1eval.features.ex1.User
import edu.iesam.examaad1eval.features.ex1.Users
import edu.iesam.examaad1eval.features.ex1.Item
import edu.iesam.examaad1eval.features.ex1.Items
import edu.iesam.examaad1eval.features.ex1.Services
import edu.iesam.examaad1eval.features.ex1.ServicesList

class Ex1XmlLocalDataSource(private val context: Context) {

    private val sharedPreferences = context.getSharedPreferences(context.getString(R.string.xml_name), Context.MODE_PRIVATE)

    private val gson = Gson()

    fun saveUsers(userList: List<User>) {
        val users = Users(userList)
        sharedPreferences.edit().putString(context.getString(R.string.xml_users_name), gson.toJson(users)).apply()
    }

    fun getUsers() : List<User>? {
        return sharedPreferences.getString(context.getString(R.string.xml_users_name), null)?.let {
            gson.fromJson(it, Users::class.java).users
        }
    }

    fun saveProducts(productList: List<Item>) {
        val products = Items(productList)
        sharedPreferences.edit().putString(context.getString(R.string.xml_products_name), gson.toJson(products)).apply()
    }

    fun getProducts() : List<Item>? {
        return sharedPreferences.getString(context.getString(R.string.xml_products_name), null)?.let {
            gson.fromJson(it, Items::class.java).items
        }
    }

    fun saveServices(productList: List<Services>) {
        val services = ServicesList(productList)
        sharedPreferences.edit().putString(context.getString(R.string.xml_services_name), gson.toJson(services)).apply()
    }

    fun getServices() : List<Services>? {
        return sharedPreferences.getString(context.getString(R.string.xml_services_name), null)?.let {
            gson.fromJson(it, ServicesList::class.java).items
        }
    }
}