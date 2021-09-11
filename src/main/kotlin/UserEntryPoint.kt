import io.javalin.Javalin
import io.javalin.apibuilder.ApiBuilder.*
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

object UserEntryPoint: KoinComponent {
   private val userService: UserServiceImpl by inject()
    fun init(){

        val app = Javalin.create().apply {
            exception(Exception::class.java) { e, ctx -> e.printStackTrace() }
            error(404) { ctx -> ctx.json("not found")}
        }.start(8080)

        app.routes {
            get("/users/:user-id") { ctx ->
                ctx.json(userService.findById(ctx.pathParam("user-id").toInt())!!)
            }

            get("/users/email/:email") { ctx ->
            //    ctx.json(userDao.findByEmail(ctx.pathParam("email"))!!)
            }

            post("/users") { ctx ->
                val user = ctx.body<User>()
              //  userDao.save(name = user.name, email = user.email)
                ctx.status(201)
            }

            patch("/users/:user-id") { ctx ->
                val user = ctx.body<User>()

//                userDao.update(
//                    id = ctx.pathParam("user-id").toInt(),
//                    user = user
//                )
                ctx.status(204)
            }

            delete("/users/:user-id") { ctx ->
                // userDao.delete(ctx.pathParam("user-id").toInt())
                ctx.status(204)
            }
        }
    }
}