import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SistemaAluguel {
    private List<Cliente> clientes;
    private List<Horario> horarios;
    private List<Aluguel> alugueis;
    private int nextClienteId = 1;
    private int nextHorarioId = 1;
    private int nextAluguelId = 1;

    public SistemaAluguel() {
        this.clientes = new ArrayList<>();
        this.horarios = new ArrayList<>();
        this.alugueis = new ArrayList<>();
    }

    public Cliente cadastrarCliente(String nome, String telefone) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome não pode ser vazio");
        }
        Cliente cliente = new Cliente(nextClienteId++, nome, telefone);
        clientes.add(cliente);
        return cliente;
    }

    public Horario cadastrarHorario(int hora, double valor) {
        if (valor < 0) {
            throw new IllegalArgumentException("Valor não pode ser negativo");
        }
        Horario horario = new Horario(nextHorarioId++, hora, valor);
        horarios.add(horario);
        return horario;
    }

    public Aluguel registrarAluguel(Cliente cliente, List<Horario> horariosSelecionados, LocalDate data) {
        for (Horario h : horariosSelecionados) {
            boolean ocupado = isHorarioOcupado(h, data);
            if (ocupado) {
                throw new IllegalArgumentException("Horário já está ocupado: " + h.getDescricao());
            }
        }

        Aluguel aluguel = new Aluguel(nextAluguelId++, cliente, horariosSelecionados, data);
        alugueis.add(aluguel);
        return aluguel;
    }

    public boolean isHorarioOcupado(Horario horario, LocalDate data) {
        return alugueis.stream()
            .filter(a -> a.getData().equals(data))
            .anyMatch(a -> a.getHorarios().contains(horario));
    }

    public List<Aluguel> consultarAlugueisPorData(LocalDate data) {
        return alugueis.stream()
            .filter(a -> a.getData().equals(data))
            .collect(Collectors.toList());
    }

    public List<Cliente> getClientes() { return clientes; }
    public List<Horario> getHorarios() { return horarios; }
    public List<Aluguel> getAlugueis() { return alugueis; }
}