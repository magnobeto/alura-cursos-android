package br.com.alura.orgs.database.repository

import android.content.Context
import br.com.alura.orgs.database.AppDatabase
import io.mockk.mockk
import org.junit.Test

class ProdutoRepositoryTest {

    @Test
    fun salva() {
        val context = mockk<Context>()
        ProdutoRepository(AppDatabase.instancia(context).produtoDao())
    }
}