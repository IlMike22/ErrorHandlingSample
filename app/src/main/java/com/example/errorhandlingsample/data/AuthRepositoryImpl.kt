package com.example.errorhandlingsample.data

import com.example.errorhandlingsample.domain.AuthRepository
import com.example.errorhandlingsample.domain.DataError
import com.example.errorhandlingsample.domain.Result
import com.example.errorhandlingsample.domain.User
import retrofit2.HttpException
import java.io.IOException

class AuthRepositoryImpl : AuthRepository {
    override suspend fun register(password: String): Result<User, DataError.Network> {
        // API call logic
        return try {
            val user = User("dummy", "blubb", "helo")
            Result.Success(user)
        } catch (e: HttpException) {
            when (e.code()) {
                408 -> Result.Error(DataError.Network.REQUEST_TIMEOUT)
                413 -> Result.Error(DataError.Network.PAYLOAD_TOO_LARGE)
                else -> Result.Error(DataError.Network.UNKNOWN)
            }
        } catch (e: IOException) {
            Result.Error(DataError.Network.NO_INTERNET)
        }
    }
}