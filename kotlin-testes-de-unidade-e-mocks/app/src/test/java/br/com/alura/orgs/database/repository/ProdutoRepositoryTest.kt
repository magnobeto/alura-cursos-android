package br.com.alura.orgs.database.repository

import br.com.alura.orgs.database.dao.ProdutoDao
import br.com.alura.orgs.model.Produto
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.Test
import java.math.BigDecimal

class ProdutoRepositoryTest {

    @Test
    fun salva() {
        val dao = mockk<ProdutoDao>()
        val produtoRepository = ProdutoRepository(dao)
        val produto = Produto(
            nome = "Banana",
            descricao = "Banana Prata",
            valor = BigDecimal("6.99")
        )

        every {
            dao.salva(produto)
        }.returns(Unit)

        produtoRepository.salva(produto)

        verify {
            dao.salva(produto)
        }
    }
}