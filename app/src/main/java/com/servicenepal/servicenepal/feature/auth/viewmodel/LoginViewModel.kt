import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import okio.IOException

class LoginViewModel(private val authRepository: AuthRepository) : ViewModel() {

    fun login(email: String, password: String) {
        viewModelScope.launch {
            try {
                val response = authRepository.login(email, password)
            } catch (e: IOException) {
            }
        }
    }
}
