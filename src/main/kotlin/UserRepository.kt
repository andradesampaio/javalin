interface UserRepository {
    fun save(name: String, email: String)
    fun findById(id: Int): User?
    fun findByEmail(email: String): User?
    fun update(id: Int, user: User)
    fun delete(id: Int)
}