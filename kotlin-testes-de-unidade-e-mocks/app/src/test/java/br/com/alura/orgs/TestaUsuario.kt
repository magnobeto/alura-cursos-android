package br.com.alura.orgs

import br.com.alura.orgs.model.Usuario
import org.junit.Assert
import org.junit.Test

class TestaUsuario {

    @Test
    fun `GIVEN a valid user WHEN user is registering itself THEN validate it`() {
        val usuarioValido = Usuario(
            id = "Magno",
            email = "magno@gmail.com",
            senha = "123456"
        )

        val usuarioEhValido = usuarioValido.ehValido()

        Assert.assertEquals(true, usuarioEhValido)
    }
}