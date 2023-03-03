package br.com.alura.orgs.database.repository

import br.com.alura.orgs.database.dao.UsuarioDao
import br.com.alura.orgs.model.Usuario
import io.mockk.*
import kotlinx.coroutines.test.runTest
import org.junit.Test

class UsuarioRepositoryTest {

    private val dao = mockk<UsuarioDao>()
    private val usuarioRepository = UsuarioRepository(dao)

    @Test
    fun salva() = runTest {
        val usuario = Usuario(
            id = "Beto",
            email = "magno@gmail.com",
            senha = "123456"
        )

        coEvery {
            dao.salva(usuario)
        }.returns(Unit)

        usuarioRepository.salva(usuario)

        coVerify {
            dao.salva(usuario)
        }
    }

    @Test
    fun autentica() = runTest {
        val usuario = Usuario(
            id = "Beto",
            email = "magno@gmail.com",
            senha = "123456"
        )

        coEvery {
            dao.autentica(
                usuarioId = usuario.id,
                senha = usuario.senha
            )
        }.returns(usuario)

        usuarioRepository.autentica(
            usuarioId = usuario.id,
            senha = usuario.senha
        )

        coVerify {
            dao.autentica(
                usuarioId = usuario.id,
                senha = usuario.senha
            )
        }
    }
}