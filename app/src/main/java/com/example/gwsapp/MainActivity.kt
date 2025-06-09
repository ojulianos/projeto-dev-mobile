import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.ViewModelProvider
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import com.example.gwsapp.data.factory.UsuarioViewModelFactory
import com.example.gwsapp.data.repository.UsuarioRepository
import com.example.gwsapp.ui.theme.GWSAppTheme
import com.example.gwsapp.ui.viewmodel.UsuarioViewModel
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import com.example.gwsapp.ui.components.AppContent

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val usuarioRepository = UsuarioRepository()
        val usuarioViewModel = ViewModelProvider(this, UsuarioViewModelFactory(usuarioRepository))[UsuarioViewModel::class.java]

        setContent {
            GWSAppTheme {
                AppContent(usuarioViewModel)
            }
        }
    }
}

