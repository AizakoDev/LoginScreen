package main.data.userrepo

import main.domain.UserProfile
import main.domain.UserRepo

class CombineUserRepoImpl(
    private val localRepo: UserRepo,
    private val remoteRepo: UserRepo
) : UserRepo {
    override fun addUser(user: UserProfile) {
        localRepo.addUser(user)
        remoteRepo.addUser(user)
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