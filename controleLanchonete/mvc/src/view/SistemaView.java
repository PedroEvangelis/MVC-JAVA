package view;

import model.Pedido;
import model.Produto;
import java.util.List;

public class SistemaView {
    
    public void exibirMensagem(String mensagem) {
        System.out.println(mensagem);
    }

    public void exibirProdutoCadastrado(Produto produto) {
        System.out.println("Produto cadastrado: " + produto.getNome() + " - R$ " + produto.getPreco());
    }

    public void exibirPedidoFinalizado(Pedido pedido) {
        System.out.println("Pedido " + pedido.getId() + " finalizado - Total: R$ " + pedido.getValorTotal());
    }

    public void exibirErro(String erro) {
        System.out.println("Erro: " + erro);
    }

    public void exibirListaPedidos(List<Pedido> pedidos) {
        System.out.println("\n--- Pedidos ---");
        for (Pedido p : pedidos) {
            System.out.println("Pedido " + p.getId() + ": " + p.getProdutos().size() + " produto(s) - R$ " + p.getValorTotal());
        }
    }

    public void exibirFaturamento(double valor) {
        System.out.println("\n--- Faturamento ---");
        System.out.println("Total: R$ " + valor);
    }
}
