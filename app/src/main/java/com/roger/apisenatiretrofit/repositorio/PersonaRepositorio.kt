package com.roger.apisenatiretrofit.repositorio

import com.roger.apisenatiretrofit.datos.modelos.Persona
import com.roger.apisenatiretrofit.datos.modelos.PersonaResponse
import com.roger.apisenatiretrofit.datos.red.ClienteRetrofit

class PersonaRepositorio {
    private val api = ClienteRetrofit.apiService

    suspend fun obtenerPersonas(): PersonaResponse {

        val respuesta: PersonaResponse

        try {
            respuesta= api.obtenerPersonas()
        } catch (e: Exception) {
            return PersonaResponse(emptyList())
        }

        return respuesta
    }

    suspend fun agregarPersona(persona: Persona): Boolean{
        return try {
            val response = api.agregarPersona(persona)
            response.isSuccessful
        } catch (e: Exception){
            false
        }

    }
}