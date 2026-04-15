package main;

import model.Pedido;
import model.Produto;
import model.SistemaLanchoneteRepository;
import controller.LanchoneteController;
import view.SistemaView;
import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        SistemaLanchoneteRepository repository = new SistemaLanchoneteRepository();
        LanchoneteController controller = new LanchoneteController(repository);
        SistemaView view = new SistemaView();

        try {
            Produto p1 = controller.cadastrarProduto("X-Burger", "Hamburguer artesanal", 15.00);
            view.exibirProdutoCadastrado(p1);

            Produto p2 = controller.cadastrarProduto("X-Salada", "Hamburguer com salada", 18.00);
            view.exibirProdutoCadastrado(p2);

            Produto p3 = controller.cadastrarProduto("Refrigerante", "Coca-Cola 350ml", 5.00);
            view.exibirProdutoCadastrado(p3);

            LocalDate hoje = LocalDate.now();
            Pedido pedido1 = controller.criarPedido(hoje);
            controller.adicionarProdutoAoPedido(pedido1, p1);
            controller.adicionarProdutoAoPedido(pedido1, p3);
            controller.finalizarPedido(pedido1);
            view.exibirPedidoFinalizado(pedido1);

            Pedido pedido2 = controller.criarPedido(hoje);
            controller.adicionarProdutoAoPedido(pedido2, p2);
            controller.adicionarProdutoAoPedido(pedido2, p2);
            controller.adicionarProdutoAoPedido(pedido2, p3);
            controller.finalizarPedido(pedido2);
            view.exibirPedidoFinalizado(pedido2);

            Pedido pedidoVazio = controller.criarPedido(hoje);
            controller.finalizarPedido(pedidoVazio);
        } catch (IllegalArgumentException e) {
            view.exibirErro(e.getMessage());
        }

        LocalDate hoje = LocalDate.now();
        List<Pedido> pedidosHoje = controller.consultarPedidosPorData(hoje);
        view.exibirListaPedidos(pedidosHoje);

        double faturamento = controller.calcularFaturamento(pedidosHoje);
        view.exibirFaturamento(faturamento);
    }
}
