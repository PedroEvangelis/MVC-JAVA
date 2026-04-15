package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SistemaLanchoneteRepository {
    private List<Produto> produtos;
    private List<Pedido> pedidos;
    private int nextProdutoId = 1;
    private int nextPedidoId = 1;

    public SistemaLanchoneteRepository() {
        this.produtos = new ArrayList<>();
        this.pedidos = new ArrayList<>();
    }

    public Produto cadastrarProduto(String nome, String descricao, double preco) {
        Produto produto = new Produto(nextProdutoId++, nome, descricao, preco);
        produtos.add(produto);
        return produto;
    }

    public Pedido criarPedido(LocalDate data) {
        Pedido pedido = new Pedido(nextPedidoId++, data);
        pedidos.add(pedido);
        return pedido;
    }

    public Pedido finalizarPedido(Pedido pedido) {
        pedido.finalizar();
        return pedido;
    }

    public List<Pedido> consultarPedidosPorData(LocalDate data) {
        return pedidos.stream()
            .filter(p -> p.getData().equals(data))
            .collect(Collectors.toList());
    }

    public double calcularFaturamento(List<Pedido> pedidos) {
        return pedidos.stream()
            .filter(Pedido::isFinalizado)
            .mapToDouble(Pedido::getValorTotal)
            .sum();
    }

    public List<Produto> getProdutos() { return produtos; }
    public List<Pedido> getPedidos() { return pedidos; }
}
