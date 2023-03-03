package br.com.alura.orgs.database.repository

import br.com.alura.orgs.database.dao.UsuarioDao
import br.com.alura.orgs.model.Usuario

class UsuarioRepository(
    private val dao: UsuarioDao
) {
    fun salva(usuario: Usuario) = dao.salva(usuario)

    fun autentica(usuarioId: String, senha: String) = dao.autentica(usuarioId, senha)

    suspend fun buscaPorId(usuarioId: String) = dao.buscaPorId(usuarioId)
}