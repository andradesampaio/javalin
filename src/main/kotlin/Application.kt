import org.koin.core.context.startKoin

object Application {
    @JvmStatic
    fun main(args: Array<String>){
        startKoin {
            modules(listOf(userServiceModule))
        }
        UserEntryPoint.init()

    }
}