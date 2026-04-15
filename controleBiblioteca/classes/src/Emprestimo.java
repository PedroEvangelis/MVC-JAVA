import java.time.LocalDate;

public class Emprestimo {
    private int id;
    private Livro livro;
    private Aluno aluno;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;
    private boolean devolvido;

    public Emprestimo(int id, Livro livro, Aluno aluno, LocalDate dataEmprestimo) {
        this.id = id;
        this.livro = livro;
        this.aluno = aluno;
        this.dataEmprestimo = dataEmprestimo;
        this.devolvido = false;
    }

    public int getId() { return id; }
    public Livro getLivro() { return livro; }
    public Aluno getAluno() { return aluno; }
    public LocalDate getDataEmprestimo() { return dataEmprestimo; }
    public LocalDate getDataDevolucao() { return dataDevolucao; }
    public boolean isDevolvido() { return devolvido; }
    public void setDataDevolucao(LocalDate dataDevolucao) { this.dataDevolucao = dataDevolucao; }
    public void setDevolvido(boolean devolvido) { this.devolvido = devolvido; }
}
