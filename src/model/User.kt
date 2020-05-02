package id.yuana.model

data class User(
    val id: Int? = null,
    val username: String,
    val password: String? = null,
    val avatar: String
)