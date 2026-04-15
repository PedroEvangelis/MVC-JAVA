public class Livro {
    private int id;
    private String titulo;
    private String autor;
    private int quantidadeDisponivel;

    public Livro(int id, String titulo, String autor, int quantidadeDisponivel) {
        if (titulo == null || titulo.trim().isEmpty()) {
            throw new IllegalArgumentException("Título não pode ser vazio");
        }
        if (quantidadeDisponivel < 0) {
            throw new IllegalArgumentException("Quantidade não pode ser negativa");
        }
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.quantidadeDisponivel = quantidadeDisponivel;
    }

    public int getId() { return id; }
    public String getTitulo() { return titulo; }
    public String getAutor() { return autor; }
    public int getQuantidadeDisponivel() { return quantidadeDisponivel; }
    public void setQuantidadeDisponivel(int quantidadeDisponivel) { this.quantidadeDisponivel = quantidadeDisponivel; }
}
