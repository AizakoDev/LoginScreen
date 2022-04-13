package main.data.userrepo

import main.domain.UserProfile
import main.domain.UserRepo

class RetrofitUserRepoImpl : UserRepo {
    override fun addUser(user: UserProfile) {
        TODO("Not yet implemented")
    }

    override fun getAllUsers(): List<UserProfile> {
        TODO("Not yet implemented")
    }

    override fun changeUser(id: String, user: UserProfile) {
        TODO("Not yet implemented")
    }

    override fun deleteUser(id: String) {
        TODO("Not yet implemented")
    }

    override fun deleteAll() {
        TODO("Not yet implemented")
    }
}