package main;

import model.Aluno;
import model.Emprestimo;
import model.Livro;
import model.SistemaBibliotecaRepository;
import controller.BibliotecaController;
import view.SistemaView;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        SistemaBibliotecaRepository repository = new SistemaBibliotecaRepository();
        BibliotecaController controller = new BibliotecaController(repository);
        SistemaView view = new SistemaView();

        try {
            Livro l1 = controller.cadastrarLivro("Dom Casmurro", "Machado de Assis", 3);
            view.exibirLivroCadastrado(l1);

            Livro l2 = controller.cadastrarLivro("1984", "George Orwell", 2);
            view.exibirLivroCadastrado(l2);

            Aluno a1 = controller.cadastrarAluno("Pedro Silva", "99999-1111");
            view.exibirAlunoCadastrado(a1);

            Aluno a2 = controller.cadastrarAluno("Ana Costa", "88888-2222");
            view.exibirAlunoCadastrado(a2);

            LocalDate hoje = LocalDate.now();
            Emprestimo e1 = controller.registrarEmprestimo(l1, a1, hoje);
            view.exibirEmprestimoRegistrado(e1);

            Emprestimo e2 = controller.registrarEmprestimo(l1, a2, hoje);
            view.exibirEmprestimoRegistrado(e2);

            Emprestimo e3 = controller.registrarEmprestimo(l1, a1, hoje);
            view.exibirEmprestimoRegistrado(e3);

            controller.registrarEmprestimo(l1, a2, hoje);
        } catch (IllegalArgumentException e) {
            view.exibirErro(e.getMessage());
        }

        view.exibirLivrosEmprestados(controller.getLivrosEmprestados());

        java.util.Optional<Emprestimo> primeiroEmprestimo = controller.getLivrosEmprestados().stream().findFirst();
        if (primeiroEmprestimo.isPresent()) {
            controller.registrarDevolucao(primeiroEmprestimo.get(), LocalDate.now());
            view.exibirDevolucaoRegistrada(primeiroEmprestimo.get());
        }

        view.exibirAlunosComLivrosEmAberto(controller.getAlunosComLivrosEmAberto());
    }
}
