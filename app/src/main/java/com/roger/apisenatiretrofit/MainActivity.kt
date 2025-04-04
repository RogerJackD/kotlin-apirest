package com.roger.apisenatiretrofit
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.roger.apisenatiretrofit.ui.theme.ApiSenatiRetrofitTheme
import com.roger.apisenatiretrofit.ui.theme.view.PersonaScreem
import com.roger.apisenatiretrofit.ui.theme.viewmodel.PersonaViewModel

class MainActivity : ComponentActivity() {

    private val viewModel: PersonaViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PersonaScreem(viewModel)
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ApiSenatiRetrofitTheme {
        Greeting("Android")
    }
}