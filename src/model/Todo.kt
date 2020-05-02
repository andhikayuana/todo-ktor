package id.yuana.model

data class Todo(
    val id: Int? = null,
    val text: String,
    val completed: Boolean,
    val user: User? = null
)