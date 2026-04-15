package controller;

import model.Aluno;
import model.Emprestimo;
import model.Livro;
import model.SistemaBibliotecaRepository;
import java.time.LocalDate;
import java.util.List;

public class BibliotecaController {
    private SistemaBibliotecaRepository repository;

    public BibliotecaController(SistemaBibliotecaRepository repository) {
        this.repository = repository;
    }

    public Livro cadastrarLivro(String titulo, String autor, int quantidade) {
        if (titulo == null || titulo.trim().isEmpty()) {
            throw new IllegalArgumentException("Título não pode ser vazio");
        }
        if (quantidade < 0) {
            throw new IllegalArgumentException("Quantidade não pode ser negativa");
        }
        return repository.cadastrarLivro(titulo, autor, quantidade);
    }

    public Aluno cadastrarAluno(String nome, String telefone) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome não pode ser vazio");
        }
        return repository.cadastrarAluno(nome, telefone);
    }

    public Emprestimo registrarEmprestimo(Livro livro, Aluno aluno, LocalDate data) {
        if (livro.getQuantidadeDisponivel() <= 0) {
            throw new IllegalArgumentException("Não há exemplares disponíveis para empréstimo");
        }
        return repository.registrarEmprestimo(livro, aluno, data);
    }

    public void registrarDevolucao(Emprestimo emprestimo, LocalDate dataDevolucao) {
        repository.registrarDevolucao(emprestimo, dataDevolucao);
    }

    public List<Emprestimo> getLivrosEmprestados() {
        return repository.getLivrosEmprestados();
    }

    public List<Aluno> getAlunosComLivrosEmAberto() {
        return repository.getAlunosComLivrosEmAberto();
    }
}
