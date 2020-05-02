package id.yuana.controller

import id.yuana.db.table.Todos
import id.yuana.db.table.toModel
import id.yuana.model.Todo
import org.jetbrains.exposed.sql.SortOrder
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction

class TodoController {

    fun index(): ArrayList<Todo> {
        val todos: ArrayList<Todo> = arrayListOf()
        transaction {
            Todos.selectAll()
                .orderBy(Todos.id, SortOrder.DESC)
                .map { todos.add(it.toModel()) }
        }
        return todos
    }

    fun show(id: Int): Todo {
        return transaction {
            Todos.select { Todos.id eq id }.map { it.toModel() }.first()
        }
    }

    fun create(todo: Todo): Todo {
        return transaction {
            val result = Todos.insert {
                it[text] = todo.text
            }
            return@transaction result.toModel()
        }
    }

    fun update(id: Int, todo: Todo): Todo {
        return todo
    }

    fun delete(id: Int): Boolean {
        return true
    }
}