package main;

import model.Aluguel;
import model.Cliente;
import model.Horario;
import model.SistemaAluguelRepository;
import controller.AluguelController;
import view.SistemaView;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        SistemaAluguelRepository repository = new SistemaAluguelRepository();
        AluguelController controller = new AluguelController(repository);
        SistemaView view = new SistemaView();

        try {
            Cliente c1 = controller.cadastrarCliente("João Silva", "99999-1234");
            view.exibirClienteCadastrado(c1);

            Cliente c2 = controller.cadastrarCliente("Maria Santos", "88888-5678");
            view.exibirClienteCadastrado(c2);

            Horario h1 = controller.cadastrarHorario(14, 100.00);
            Horario h2 = controller.cadastrarHorario(15, 100.00);
            Horario h3 = controller.cadastrarHorario(16, 120.00);
            view.exibirMensagem("Horários cadastrados: " + h1.getDescricao() + ", " + h2.getDescricao() + ", " + h3.getDescricao());

            LocalDate hoje = LocalDate.now();
            List<Horario> horariosJoao = Arrays.asList(h1, h2);
            Aluguel a1 = controller.registrarAluguel(c1, horariosJoao, hoje);
            view.exibirAluguelRegistrado(a1);

            List<Horario> horariosMaria = Arrays.asList(h1);
            controller.registrarAluguel(c2, horariosMaria, hoje);
        } catch (IllegalArgumentException e) {
            view.exibirErro(e.getMessage());
        }

        List<Aluguel> alugueisHoje = controller.consultarAlugueisPorData(LocalDate.now());
        view.exibirListaAlugueis(alugueisHoje);
    }
}