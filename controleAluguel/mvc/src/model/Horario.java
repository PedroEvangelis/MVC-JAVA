package model;

public class Horario {
    private int id;
    private int hora;
    private double valor;

    public Horario(int id, int hora, double valor) {
        if (valor < 0) {
            throw new IllegalArgumentException("Valor não pode ser negativo");
        }
        if (hora < 0 || hora > 23) {
            throw new IllegalArgumentException("Hora inválida");
        }
        this.id = id;
        this.hora = hora;
        this.valor = valor;
    }

    public int getId() { return id; }
    public int getHora() { return hora; }
    public double getValor() { return valor; }
    public void setValor(double valor) { this.valor = valor; }

    public String getDescricao() {
        return String.format("%02d:00", hora);
    }
}