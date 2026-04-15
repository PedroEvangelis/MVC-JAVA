package view;

import model.Aluguel;
import model.Cliente;
import model.Horario;
import java.util.List;

public class SistemaView {
    
    public void exibirMensagem(String mensagem) {
        System.out.println(mensagem);
    }

    public void exibirClienteCadastrado(Cliente cliente) {
        System.out.println("Cliente cadastrado: " + cliente.getNome());
    }

    public void exibirHorarioCadastrado(Horario horario) {
        System.out.println("Horário cadastrado: " + horario.getDescricao());
    }

    public void exibirAluguelRegistrado(Aluguel aluguel) {
        System.out.println("Aluguel registrado para " + aluguel.getCliente().getNome() + 
            " no valor de R$ " + aluguel.getValorTotal());
    }

    public void exibirErro(String erro) {
        System.out.println("Erro: " + erro);
    }

    public void exibirListaAlugueis(List<Aluguel> alugueis) {
        System.out.println("\n--- Aluguéis ---");
        for (Aluguel a : alugueis) {
            System.out.println(a.getCliente().getNome() + " - " + 
                a.getHorarios().size() + " horário(s) - R$ " + a.getValorTotal());
        }
    }
}