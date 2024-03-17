package com.example.errorhandlingsample.domain

interface AuthRepository {
    suspend fun register(password: String): Result<User, DataError.Network>
}

data class User(
    val name: String,
    val token: String,
    val email: String
)