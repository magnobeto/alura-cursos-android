package br.com.alura.orgs.database.repository

import br.com.alura.orgs.database.dao.ProdutoDao
import br.com.alura.orgs.model.Produto
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Test
import java.math.BigDecimal

class ProdutoRepositoryTest {

    @Test
    fun salva() = runTest {
        val dao = mockk<ProdutoDao>()
        val produtoRepository = ProdutoRepository(dao)
        val produto = Produto(
            nome = "Banana",
            descricao = "Banana Prata",
            valor = BigDecimal("6.99")
        )

        coEvery {
            dao.salva(produto)
        }.returns(Unit)

        produtoRepository.salva(produto)

        coVerify {
            dao.salva(produto)
        }
    }
}