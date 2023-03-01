package br.com.alura.orgs

import br.com.alura.orgs.model.Produto
import org.junit.Assert
import org.junit.Test
import java.math.BigDecimal

class TestaProduto {

    @Test
    fun `GIVEN a valid product WHEN user is registering a new product THEN validate it`() {
        val produtoValido = Produto(
            nome = "Maçã",
            descricao = "Maçã Gala",
            valor = BigDecimal("5.59")
        )

        val valorEhValido = produtoValido.valorValido

        Assert.assertEquals(true, valorEhValido)
    }

    @Test
    fun `GIVEN a product with invalid value price WHEN user is registering a product THEN a error occurs during validation`() {
        val produtoInvalido = Produto(
            nome = "Banana",
            descricao = "Prata",
            valor = BigDecimal("105.59")
        )

        val valorEhValido = produtoInvalido.valorValido

        Assert.assertEquals(false, valorEhValido)
    }
}