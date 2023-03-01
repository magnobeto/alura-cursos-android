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

    @Test
    fun `GIVEN a user with invalid email WHEN user is registering itself THEN a error occurs during validation` () {
        val usuarioInvalido = Usuario(
            id = "Magno",
            email = "magno.com",
            senha = "123456"
        )

        val usuarioEhValido = usuarioInvalido.ehValido()

        Assert.assertEquals(false, usuarioEhValido)
    }

    @Test
    fun `GIVEN a user with password with less than six chars WHEN user is registering itself THEN a error occurs during validation` () {
        val usuarioInvalido = Usuario(
            id = "Magno",
            email = "magno@gmail.com",
            senha = "1256"
        )

        val usuarioEhValido = usuarioInvalido.ehValido()

        Assert.assertEquals(false, usuarioEhValido)
    }
}