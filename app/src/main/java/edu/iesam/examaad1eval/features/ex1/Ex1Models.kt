package edu.iesam.examaad1eval.features.ex1

data class User(val id: String, val name: String, val surname: String)
data class Users(val users: List<User>)
data class Item(val id: String, val name: String, val price: Double)
data class Items(val items: List<Item>)
data class Services(val id: String, val name: String)
data class ServicesList(val items: List<Services>)
