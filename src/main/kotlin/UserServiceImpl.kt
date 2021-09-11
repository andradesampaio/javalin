class UserServiceImpl(
    private val repository: UserRepository
): UserService {

    override fun save(name: String, email: String) {
        TODO("Not yet implemented")
    }

    override fun findById(id: Int): User? {
       return repository.findById(id)
    }

    override fun findByEmail(email: String): User? {
        TODO("Not yet implemented")
    }

    override fun update(id: Int, user: User) {
        TODO("Not yet implemented")
    }

    override fun delete(id: Int) {
        TODO("Not yet implemented")
    }
}