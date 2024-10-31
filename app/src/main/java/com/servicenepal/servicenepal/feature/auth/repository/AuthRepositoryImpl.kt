import okio.IOException

class AuthRepositoryImpl(private val authService: AuthService) : AuthRepository {

    override suspend fun login(email: String, password: String): LoginResponseModel {
        val request = LoginRequestModel(email, password)
        val response = authService.login(request)

        if (response.isSuccessful) {
            return response.body() ?: throw IOException("Login failed: No response body")
        } else {
            throw IOException("Error ${response.code()}: ${response.message()}")
        }
    }
}
