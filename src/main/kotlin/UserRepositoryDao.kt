import java.util.concurrent.atomic.AtomicInteger

class UserRepositoryDao: UserRepository {

    private val users = hashMapOf(
        0 to User(name = "Alice", email = "alice@alice.kt", id = 0),
        1 to User(name = "Bob", email = "bob@bob.kt", id = 1),
        2 to User(name = "Carol", email = "carol@carol.kt", id = 2),
        3 to User(name = "Dave", email = "dave@dave.kt", id = 3)
    )

    var lastId: AtomicInteger = AtomicInteger(users.size - 1)


    override fun save(name: String, email: String) {
        val id = lastId.incrementAndGet()
        users.put(id, User(name = name, email = email, id = id))
    }

    override fun findById(id: Int): User? {
        return users[id]
    }

    override fun findByEmail(email: String): User? {
        return users.values.find { it.email == email }
    }

    override fun update(id: Int, user: User) {
        users.put(id, User(name = user.name, email = user.email, id = id))
    }

    override fun delete(id: Int) {
        users.remove(id)
    }
}