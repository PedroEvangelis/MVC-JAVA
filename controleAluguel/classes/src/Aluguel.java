import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Aluguel {
    private int id;
    private Cliente cliente;
    private List<Horario> horarios;
    private LocalDate data;
    private boolean pago;

    public Aluguel(int id, Cliente cliente, List<Horario> horarios, LocalDate data) {
        if (cliente == null) {
            throw new IllegalArgumentException("Cliente não pode ser null");
        }
        if (horarios == null || horarios.isEmpty()) {
            throw new IllegalArgumentException("Deve ter pelo menos um horário");
        }
        this.id = id;
        this.cliente = cliente;
        this.horarios = new ArrayList<>(horarios);
        this.data = data;
        this.pago = false;
    }

    public double getValorTotal() {
        return horarios.stream().mapToDouble(Horario::getValor).sum();
    }

    public int getId() { return id; }
    public Cliente getCliente() { return cliente; }
    public List<Horario> getHorarios() { return horarios; }
    public LocalDate getData() { return data; }
    public boolean isPago() { return pago; }
    public void setPago(boolean pago) { this.pago = pago; }
}