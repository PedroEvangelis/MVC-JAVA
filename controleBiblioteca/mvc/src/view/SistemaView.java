package view;

import model.Aluno;
import model.Emprestimo;
import model.Livro;
import java.util.List;

public class SistemaView {
    
    public void exibirMensagem(String mensagem) {
        System.out.println(mensagem);
    }

    public void exibirLivroCadastrado(Livro livro) {
        System.out.println("Livro cadastrado: " + livro.getTitulo() + " - " + livro.getQuantidadeDisponivel() + " disponível(s)");
    }

    public void exibirAlunoCadastrado(Aluno aluno) {
        System.out.println("Aluno cadastrado: " + aluno.getNome());
    }

    public void exibirEmprestimoRegistrado(Emprestimo emprestimo) {
        System.out.println("Empréstimo registrado: " + emprestimo.getAluno().getNome() + " pegou \"" + emprestimo.getLivro().getTitulo() + "\"");
    }

    public void exibirDevolucaoRegistrada(Emprestimo emprestimo) {
        System.out.println("Devolução registrada para " + emprestimo.getAluno().getNome());
    }

    public void exibirErro(String erro) {
        System.out.println("Erro: " + erro);
    }

    public void exibirLivrosEmprestados(List<Emprestimo> emprestimos) {
        System.out.println("\n--- Livros emprestados ---");
        for (Emprestimo e : emprestimos) {
            System.out.println("\"" + e.getLivro().getTitulo() + "\" - " + e.getAluno().getNome());
        }
    }

    public void exibirAlunosComLivrosEmAberto(List<Aluno> alunos) {
        System.out.println("\n--- Alunos com livros em aberto ---");
        for (Aluno a : alunos) {
            System.out.println(a.getNome());
        }
    }
}
