package id.yuana.routes

import id.yuana.controller.TodoController
import id.yuana.model.Todo
import io.ktor.application.call
import io.ktor.request.receive
import io.ktor.response.respond
import io.ktor.routing.*

fun Routing.v1() {
    route("/v1") {
        route("/todos") {
            val controller = TodoController()
            get("/") {
                call.respond(controller.index())
            }
            get("/{id}") {
                call.parameters["id"]?.toInt()?.let {
                    call.respond(controller.show(it))
                }
            }
            post("/") {
                val todo = call.receive<Todo>()
                call.respond(controller.create(todo))
            }
            put("/{id}") {

            }
            delete("/{id}") {

            }
        }
    }
}