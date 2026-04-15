package controller;

import model.Pedido;
import model.Produto;
import model.SistemaLanchoneteRepository;
import java.time.LocalDate;
import java.util.List;

public class LanchoneteController {
    private SistemaLanchoneteRepository repository;

    public LanchoneteController(SistemaLanchoneteRepository repository) {
        this.repository = repository;
    }

    public Produto cadastrarProduto(String nome, String descricao, double preco) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome não pode ser vazio");
        }
        if (preco < 0) {
            throw new IllegalArgumentException("Preço não pode ser negativo");
        }
        return repository.cadastrarProduto(nome, descricao, preco);
    }

    public Pedido criarPedido(LocalDate data) {
        return repository.criarPedido(data);
    }

    public void adicionarProdutoAoPedido(Pedido pedido, Produto produto) {
        if (pedido.isFinalizado()) {
            throw new IllegalArgumentException("Pedido já está finalizado");
        }
        pedido.adicionarProduto(produto);
    }

    public Pedido finalizarPedido(Pedido pedido) {
        if (pedido.getProdutos().isEmpty()) {
            throw new IllegalArgumentException("Pedido deve ter pelo menos um produto");
        }
        return repository.finalizarPedido(pedido);
    }

    public List<Pedido> consultarPedidosPorData(LocalDate data) {
        return repository.consultarPedidosPorData(data);
    }

    public double calcularFaturamento(List<Pedido> pedidos) {
        return repository.calcularFaturamento(pedidos);
    }
}
