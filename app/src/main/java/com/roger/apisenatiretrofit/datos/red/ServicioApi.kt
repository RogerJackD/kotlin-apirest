package com.roger.apisenatiretrofit.datos.red

import com.roger.apisenatiretrofit.datos.modelos.Persona
import com.roger.apisenatiretrofit.datos.modelos.PersonaResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ServicioApi {
    @GET("invitados")
    suspend fun obtenerPersonas(): PersonaResponse

    @POST("invitado")
    suspend fun agregarPersona(@Body persona: Persona): Response<Persona>
}