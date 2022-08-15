package io.github.aag.core.domain.repositories

import io.github.aag.core.domain.OperationResult
import io.github.aag.core.domain.models.UserType

interface AuthRepository {
    suspend fun <T> login(username: String, password: String): OperationResult<T>

    suspend fun <T> register(
        username: String,
        password: String,
        name: String,
        userType: UserType
    ): OperationResult<T>

    suspend fun enterGuestMode(): Boolean
}
