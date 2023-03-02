package br.com.alura.orgs.database.repository

import br.com.alura.orgs.database.AppDatabase
import org.junit.Test

class ProdutoRepositoryTest {

    @Test
    fun salva() {
        ProdutoRepository(AppDatabase.instancia("necessita contexto"))
    }
}