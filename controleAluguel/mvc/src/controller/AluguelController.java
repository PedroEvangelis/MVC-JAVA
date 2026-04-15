package controller;

import model.Aluguel;
import model.Cliente;
import model.Horario;
import model.SistemaAluguelRepository;
import java.time.LocalDate;
import java.util.List;

public class AluguelController {
    private SistemaAluguelRepository repository;

    public AluguelController(SistemaAluguelRepository repository) {
        this.repository = repository;
    }

    public Cliente cadastrarCliente(String nome, String telefone) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome não pode ser vazio");
        }
        return repository.cadastrarCliente(nome, telefone);
    }

    public Horario cadastrarHorario(int hora, double valor) {
        if (valor < 0) {
            throw new IllegalArgumentException("Valor não pode ser negativo");
        }
        if (hora < 0 || hora > 23) {
            throw new IllegalArgumentException("Hora inválida");
        }
        return repository.cadastrarHorario(hora, valor);
    }

    public Aluguel registrarAluguel(Cliente cliente, List<Horario> horariosSelecionados, LocalDate data) {
        for (Horario h : horariosSelecionados) {
            if (repository.isHorarioOcupado(h, data)) {
                throw new IllegalArgumentException("Horário já está ocupado: " + h.getDescricao());
            }
        }
        return repository.registrarAluguel(cliente, horariosSelecionados, data);
    }

    public List<Aluguel> consultarAlugueisPorData(LocalDate data) {
        return repository.consultarAlugueisPorData(data);
    }
}