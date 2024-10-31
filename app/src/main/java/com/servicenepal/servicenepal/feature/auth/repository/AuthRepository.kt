interface AuthRepository {
    suspend fun login(email: String, password: String): LoginResponseModel
}
