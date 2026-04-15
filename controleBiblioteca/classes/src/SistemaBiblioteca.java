import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SistemaBiblioteca {
    private List<Livro> livros;
    private List<Aluno> alunos;
    private List<Emprestimo> emprestimos;
    private int nextLivroId = 1;
    private int nextAlunoId = 1;
    private int nextEmprestimoId = 1;

    public SistemaBiblioteca() {
        this.livros = new ArrayList<>();
        this.alunos = new ArrayList<>();
        this.emprestimos = new ArrayList<>();
    }

    public Livro cadastrarLivro(String titulo, String autor, int quantidade) {
        if (titulo == null || titulo.trim().isEmpty()) {
            throw new IllegalArgumentException("Título não pode ser vazio");
        }
        if (quantidade < 0) {
            throw new IllegalArgumentException("Quantidade não pode ser negativa");
        }
        Livro livro = new Livro(nextLivroId++, titulo, autor, quantidade);
        livros.add(livro);
        return livro;
    }

    public Aluno cadastrarAluno(String nome, String telefone) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome não pode ser vazio");
        }
        Aluno aluno = new Aluno(nextAlunoId++, nome, telefone);
        alunos.add(aluno);
        return aluno;
    }

    public Emprestimo registrarEmprestimo(Livro livro, Aluno aluno, LocalDate data) {
        if (livro.getQuantidadeDisponivel() <= 0) {
            throw new IllegalArgumentException("Não há exemplares disponíveis para empréstimo");
        }
        livro.setQuantidadeDisponivel(livro.getQuantidadeDisponivel() - 1);
        Emprestimo emprestimo = new Emprestimo(nextEmprestimoId++, livro, aluno, data);
        emprestimos.add(emprestimo);
        return emprestimo;
    }

    public void registrarDevolucao(Emprestimo emprestimo, LocalDate dataDevolucao) {
        emprestimo.setDataDevolucao(dataDevolucao);
        emprestimo.setDevolvido(true);
        emprestimo.getLivro().setQuantidadeDisponivel(emprestimo.getLivro().getQuantidadeDisponivel() + 1);
    }

    public List<Emprestimo> getLivrosEmprestados() {
        return emprestimos.stream()
            .filter(e -> !e.isDevolvido())
            .collect(Collectors.toList());
    }

    public List<Aluno> getAlunosComLivrosEmAberto() {
        return emprestimos.stream()
            .filter(e -> !e.isDevolvido())
            .map(Emprestimo::getAluno)
            .distinct()
            .collect(Collectors.toList());
    }

    public List<Livro> getLivros() { return livros; }
    public List<Aluno> getAlunos() { return alunos; }
    public List<Emprestimo> getEmprestimos() { return emprestimos; }
}
