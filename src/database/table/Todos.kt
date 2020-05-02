package id.yuana.db.table

import id.yuana.model.Todo
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.statements.InsertStatement

object Todos : Table() {
    val id = integer("id").autoIncrement()
    val text = varchar("text", 100)
    val completed = bool("completed").default(false)

    //    val usersId = integer("users_id").references(Users.id, onDelete = ReferenceOption.CASCADE).nullable()
    override val primaryKey = PrimaryKey(Users.id)
}

fun ResultRow.toModel(): Todo {
    return Todo(
        id = this[Todos.id],
        text = this[Todos.text],
        completed = this[Todos.completed],
        user = null
    )
}

fun InsertStatement<Number>.toModel(): Todo {
    return Todo(
        id = this[Todos.id],
        text = this[Todos.text],
        completed = this[Todos.completed],
        user = null
    )
}