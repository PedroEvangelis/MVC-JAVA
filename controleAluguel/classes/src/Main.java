import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        SistemaAluguel sistema = new SistemaAluguel();

        Cliente c1 = sistema.cadastrarCliente("João Silva", "99999-1234");
        System.out.println("Cliente cadastrado: " + c1.getNome());

        Cliente c2 = sistema.cadastrarCliente("Maria Santos", "88888-5678");
        System.out.println("Cliente cadastrado: " + c2.getNome());

        Horario h1 = sistema.cadastrarHorario(14, 100.00);
        Horario h2 = sistema.cadastrarHorario(15, 100.00);
        Horario h3 = sistema.cadastrarHorario(16, 120.00);
        System.out.println("Horários cadastrados: " + h1.getDescricao() + ", " + h2.getDescricao() + ", " + h3.getDescricao());

        LocalDate hoje = LocalDate.now();
        List<Horario> horariosJoao = Arrays.asList(h1, h2);
        Aluguel a1 = sistema.registrarAluguel(c1, horariosJoao, hoje);
        System.out.println("Aluguel registrado para " + c1.getNome() + " no valor de R$ " + a1.getValorTotal());

        try {
            List<Horario> horariosMaria = Arrays.asList(h1);
            sistema.registrarAluguel(c2, horariosMaria, hoje);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao alugar: " + e.getMessage());
        }

        System.out.println("\n--- Aluguéis de hoje ---");
        for (Aluguel a : sistema.consultarAlugueisPorData(hoje)) {
            System.out.println(a.getCliente().getNome() + " - " + a.getHorarios().size() + " horário(s) - R$ " + a.getValorTotal());
        }
    }
}