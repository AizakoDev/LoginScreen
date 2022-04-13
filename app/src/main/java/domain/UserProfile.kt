package main.domain

data class UserProfile(
    val id: String,
    val login: String,
    val email: String,
    val avatarUrl: String,
    val pin: Int
)
