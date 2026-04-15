package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SistemaAluguelRepository {
    private List<Cliente> clientes;
    private List<Horario> horarios;
    private List<Aluguel> alugueis;
    private int nextClienteId = 1;
    private int nextHorarioId = 1;
    private int nextAluguelId = 1;

    public SistemaAluguelRepository() {
        this.clientes = new ArrayList<>();
        this.horarios = new ArrayList<>();
        this.alugueis = new ArrayList<>();
    }

    public Cliente cadastrarCliente(String nome, String telefone) {
        Cliente cliente = new Cliente(nextClienteId++, nome, telefone);
        clientes.add(cliente);
        return cliente;
    }

    public Horario cadastrarHorario(int hora, double valor) {
        Horario horario = new Horario(nextHorarioId++, hora, valor);
        horarios.add(horario);
        return horario;
    }

    public Aluguel registrarAluguel(Cliente cliente, List<Horario> horariosSelecionados, LocalDate data) {
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