import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private int id;
    private List<Produto> produtos;
    private LocalDate data;
    private boolean finalizado;

    public Pedido(int id, LocalDate data) {
        this.id = id;
        this.produtos = new ArrayList<>();
        this.data = data;
        this.finalizado = false;
    }

    public void adicionarProduto(Produto produto) {
        if (finalizado) {
            throw new IllegalArgumentException("Pedido já está finalizado");
        }
        produtos.add(produto);
    }

    public double getValorTotal() {
        return produtos.stream().mapToDouble(Produto::getPreco).sum();
    }

    public void finalizar() {
        if (produtos.isEmpty()) {
            throw new IllegalArgumentException("Pedido deve ter pelo menos um produto");
        }
        this.finalizado = true;
    }

    public int getId() { return id; }
    public List<Produto> getProdutos() { return produtos; }
    public LocalDate getData() { return data; }
    public boolean isFinalizado() { return finalizado; }
}
