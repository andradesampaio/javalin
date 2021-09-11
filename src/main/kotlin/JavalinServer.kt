import io.javalin.Javalin
import io.javalin.apibuilder.EndpointGroup
import io.javalin.core.JavalinServer

interface JavalinServer {
    fun create() : JavalinServer
    fun start(port: Int) : Javalin
    fun stop() : Javalin
    fun routes(endpointGroup: EndpointGroup) : Javalin
}