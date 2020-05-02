package id.yuana.routes

import io.ktor.application.call
import io.ktor.response.respond
import io.ktor.routing.Routing
import io.ktor.routing.get

fun Routing.root() {
    get("/") {
        call.respond(
            mapOf(
                "name" to "TodoApi",
                "version" to "1.0.0"
            )
        )
    }
}