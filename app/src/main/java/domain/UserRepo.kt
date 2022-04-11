package main.domain

interface UserRepo {
    fun addUser(user: UserProfile)
    fun getAllUsers(): List<UserProfile>
    fun changeUser(id: String, user: UserProfile)
    fun deleteUser(id: String)
    fun deleteAll()
}