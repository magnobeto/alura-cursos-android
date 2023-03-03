package br.com.alura.orgs.database.repository

import br.com.alura.orgs.database.dao.UsuarioDao
import br.com.alura.orgs.model.Usuario
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.Test

class UsuarioRepositoryTest {

    private val dao = mockk<UsuarioDao>()
    private val usuarioRepository = UsuarioRepository(dao)

    @Test
    fun salva() {
        val usuario = Usuario(
            id = "Beto",
            email = "magno@gmail.com",
            senha = "123456"
        )

        every {
            dao.salva(usuario)
        }.returns(Unit)

        usuarioRepository.salva(usuario)

        verify {
            dao.salva(usuario)
        }
    }

    @Test
    fun autentica() {
        val usuario = Usuario(
            id = "Beto",
            email = "magno@gmail.com",
            senha = "123456"
        )


        every {
            dao.autentica(
                usuarioId = usuario.id,
                senha = usuario.senha
            )
        }.returns(usuario)

        usuarioRepository.autentica(
            usuarioId = usuario.id,
            senha = usuario.senha
        )

        verify {
            dao.autentica(
                usuarioId = usuario.id,
                senha = usuario.senha
            )        }
    }
}