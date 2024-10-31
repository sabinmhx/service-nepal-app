data class LoginResponseModel(
    val success: Boolean,
    val message: String,
    val statusCode: Long,
    val data: Data,
)

data class Data(
    val email: String,
    val token: String,
)



