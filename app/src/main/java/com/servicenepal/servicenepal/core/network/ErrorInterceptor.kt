import okhttp3.Interceptor
import okhttp3.Response
import org.json.JSONObject
import java.io.IOException

class ErrorInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val response = chain.proceed(request)

        if (!response.isSuccessful) {
            val errorBody = response.body?.string() ?: "Unknown error"
            val errorMessage = extractErrorMessage(errorBody)
            throw IOException("Error ${response.code}: $errorMessage")
        }

        return response
    }

    private fun extractErrorMessage(body: String): String {
        return try {
            val json = JSONObject(body)
            json.getString("message")
        } catch (e: Exception) {
            "Unexpected error"
        }
    }
}
