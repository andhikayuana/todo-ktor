package id.yuana.db.table

import org.jetbrains.exposed.sql.Table

object Users : Table() {
    val id = integer("id").autoIncrement()
    val username = varchar("username", 50)
    val password = varchar("password", 200)
    val avatar = varchar("avatar", 200)

    override val primaryKey = PrimaryKey(id)
}