import java.time.LocalDate;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        SistemaLanchonete sistema = new SistemaLanchonete();

        Produto p1 = sistema.cadastrarProduto("X-Burger", "Hamburguer artesanal", 15.00);
        System.out.println("Produto cadastrado: " + p1.getNome() + " - R$ " + p1.getPreco());

        Produto p2 = sistema.cadastrarProduto("X-Salada", "Hamburguer com salada", 18.00);
        System.out.println("Produto cadastrado: " + p2.getNome() + " - R$ " + p2.getPreco());

        Produto p3 = sistema.cadastrarProduto("Refrigerante", "Coca-Cola 350ml", 5.00);
        System.out.println("Produto cadastrado: " + p3.getNome() + " - R$ " + p3.getPreco());

        LocalDate hoje = LocalDate.now();
        Pedido pedido1 = sistema.criarPedido(hoje);
        pedido1.adicionarProduto(p1);
        pedido1.adicionarProduto(p3);
        sistema.finalizarPedido(pedido1);
        System.out.println("Pedido " + pedido1.getId() + " finalizado - Total: R$ " + pedido1.getValorTotal());

        Pedido pedido2 = sistema.criarPedido(hoje);
        pedido2.adicionarProduto(p2);
        pedido2.adicionarProduto(p2);
        pedido2.adicionarProduto(p3);
        sistema.finalizarPedido(pedido2);
        System.out.println("Pedido " + pedido2.getId() + " finalizado - Total: R$ " + pedido2.getValorTotal());

        try {
            Pedido pedidoVazio = sistema.criarPedido(hoje);
            sistema.finalizarPedido(pedidoVazio);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao finalizar pedido: " + e.getMessage());
        }

        System.out.println("\n--- Pedidos de hoje ---");
        for (Pedido p : sistema.consultarPedidosPorData(hoje)) {
            System.out.println("Pedido " + p.getId() + ": " + p.getProdutos().size() + " produto(s) - R$ " + p.getValorTotal());
        }

        System.out.println("\n--- Faturamento de hoje ---");
        System.out.println("Total: R$ " + sistema.calcularFaturamento(sistema.consultarPedidosPorData(hoje)));
    }
}
