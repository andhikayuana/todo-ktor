package id.yuana.db

import id.yuana.db.table.Todos
import id.yuana.db.table.Users
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction

class DatabaseFactory {

    init {
        connect()
        createTables()
        insertDummyData()
    }

    private fun connect() {
        print("connect")
        Database.connect("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1", driver = "org.h2.Driver")
    }

    private fun createTables() {
        transaction {
            addLogger(StdOutSqlLogger)
            SchemaUtils.create(Users, Todos)
            print("createTables")
        }
    }

    private fun insertDummyData() {
        transaction {
            val id1 = Todos.insert {
                it[text] = "Membuat Mie Rebus"
            }
            print("inserted id : $id1")
            val id2 = Todos.insert {
                it[text] = "Membuat Mie Goreng Telor Ceplok"
            }
            print("inserted id : $id1")
        }
    }

}