package id.yuana

import com.fasterxml.jackson.databind.SerializationFeature
import id.yuana.db.DatabaseFactory
import id.yuana.routes.root
import id.yuana.routes.v1
import io.ktor.application.Application
import io.ktor.application.install
import io.ktor.auth.Authentication
import io.ktor.features.CORS
import io.ktor.features.ContentNegotiation
import io.ktor.http.HttpHeaders
import io.ktor.http.HttpMethod
import io.ktor.jackson.jackson
import io.ktor.routing.routing

fun main(args: Array<String>): Unit {
    DatabaseFactory()
    io.ktor.server.netty.EngineMain.main(args)
}

@Suppress("unused") // Referenced in application.conf
@kotlin.jvm.JvmOverloads
fun Application.module(testing: Boolean = false) {
//    val simpleJWT = SimpleJWT("this-is-secret")

    install(CORS) {
        method(HttpMethod.Options)
        method(HttpMethod.Put)
        method(HttpMethod.Delete)
        method(HttpMethod.Patch)
        header(HttpHeaders.Authorization)
        header("MyCustomHeader")
        allowCredentials = true
        anyHost() // @TODO: Don't do this in production if possible. Try to limit it.
    }

    install(Authentication) {
//        jwt {
//            verifier(simpleJWT.verifier)
//            validate {
//                UserIdPrincipal(it.payload.getClaim("name").asString())
//            }
//        }
    }

    install(ContentNegotiation) {
        jackson {
            enable(SerializationFeature.INDENT_OUTPUT)
        }
    }

    routing {
        root()
        v1()
    }
}