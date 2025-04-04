package com.roger.apisenatiretrofit.ui.theme.view



import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.roger.apisenatiretrofit.ui.theme.viewmodel.PersonaViewModel
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme

//import com.roger.apisenatiretrofit


@Composable
fun PersonaScreem(viewModel: PersonaViewModel = viewModel()){
    var nombre by remember { mutableStateOf("") }
    var apellido by remember { mutableStateOf("") }

    LaunchedEffect(Unit) {
        viewModel.cargarPersonas()
    }
    val personas by viewModel.personas.collectAsState()
    Column( modifier = Modifier.padding(16.dp)) {
        TextField(
            value = nombre,
            onValueChange = {nombre = it},
            label = { Text("nombre")}
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = apellido,
            onValueChange = {apellido = it},
            label = { Text("apellido")}
        )
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = {
            viewModel.agregarPersona(nombre, apellido)
            nombre = ""
            apellido = ""
        }) {
            Text("Agregar Persona")
        }
        Spacer(modifier = Modifier.height(16.dp))


        if (personas.isEmpty()) {
            Text("No hay personas registradas.", style =
                MaterialTheme.typography.bodyLarge)
        } else {
            LazyColumn {
                items(personas) { persona ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp),
                        elevation =
                            CardDefaults.cardElevation(defaultElevation = 4.dp)
                    ) {
                        Column(modifier = Modifier.padding(16.dp)) {
                            Text(text = "Nombre: ${persona.nombre}", style =
                                MaterialTheme.typography.bodyLarge)
                            Text(text = "Apellido: ${persona.apellido}",
                                style = MaterialTheme.typography.bodyLarge)
                        }
                    }
                }
            }
        }



    }


}