package id.yuana.auth

import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm

open class SimpleJWT(val secret: String) {
    private val alg = Algorithm.HMAC256(secret)
    val verifier = JWT.require(alg).build()
    fun sign(name: String): String = JWT.create().withClaim("name", name).sign(alg)
}