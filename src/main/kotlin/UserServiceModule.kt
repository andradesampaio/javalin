import org.koin.dsl.module

val userServiceModule = module {
    single{UserServiceImpl(get())}
    single{UserRepositoryDao() as UserRepository}
}