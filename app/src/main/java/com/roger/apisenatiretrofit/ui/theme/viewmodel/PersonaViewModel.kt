package com.roger.apisenatiretrofit.ui.theme.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.roger.apisenatiretrofit.datos.modelos.Persona
import com.roger.apisenatiretrofit.repositorio.PersonaRepositorio
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch


class PersonaViewModel: ViewModel() {
    private val repository = PersonaRepositorio()
    private val _personas = MutableStateFlow<List<Persona>>(emptyList())
    val personas: StateFlow<List<Persona>> = _personas

    fun cargarPersonas() {
        viewModelScope.launch {
            try {
                val response = repository.obtenerPersonas()
                _personas.value= response.invitados
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun agregarPersona(nombre: String, apellido: String) {
        viewModelScope.launch {
            val persona = Persona(nombre  = nombre, apellido = apellido)
            val resultado = repository.agregarPersona(persona)

            if(resultado==true){
                cargarPersonas()
            }
        }

    }
}