import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        SistemaBiblioteca sistema = new SistemaBiblioteca();

        Livro l1 = sistema.cadastrarLivro("Dom Casmurro", "Machado de Assis", 3);
        System.out.println("Livro cadastrado: " + l1.getTitulo() + " - " + l1.getQuantidadeDisponivel() + " disponível(s)");

        Livro l2 = sistema.cadastrarLivro("1984", "George Orwell", 2);
        System.out.println("Livro cadastrado: " + l2.getTitulo() + " - " + l2.getQuantidadeDisponivel() + " disponível(s)");

        Aluno a1 = sistema.cadastrarAluno("Pedro Silva", "99999-1111");
        System.out.println("Aluno cadastrado: " + a1.getNome());

        Aluno a2 = sistema.cadastrarAluno("Ana Costa", "88888-2222");
        System.out.println("Aluno cadastrado: " + a2.getNome());

        LocalDate hoje = LocalDate.now();
        Emprestimo e1 = sistema.registrarEmprestimo(l1, a1, hoje);
        System.out.println("Empréstimo registrado: " + a1.getNome() + " pegou \"" + l1.getTitulo() + "\"");

        Emprestimo e2 = sistema.registrarEmprestimo(l1, a2, hoje);
        System.out.println("Empréstimo registrado: " + a2.getNome() + " pegou \"" + l1.getTitulo() + "\"");

        Emprestimo e3 = sistema.registrarEmprestimo(l1, a1, hoje);
        System.out.println("Empréstimo registrado: " + a1.getNome() + " pegou \"" + l1.getTitulo() + "\"");

        try {
            sistema.registrarEmprestimo(l1, a2, hoje);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao emprestar: " + e.getMessage());
        }

        System.out.println("\n--- Livros emprestados ---");
        for (Emprestimo e : sistema.getLivrosEmprestados()) {
            System.out.println("\"" + e.getLivro().getTitulo() + "\" - " + e.getAluno().getNome());
        }

        sistema.registrarDevolucao(e1, hoje);
        System.out.println("\nDevolução registrada para " + e1.getAluno().getNome());

        System.out.println("\n--- Alunos com livros em aberto ---");
        for (Aluno aluno : sistema.getAlunosComLivrosEmAberto()) {
            System.out.println(aluno.getNome());
        }
    }
}
