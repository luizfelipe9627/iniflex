package service;
import java.util.List;
import model.Funcionario;

public class RemoverFuncionario {
    private static final List<Funcionario> funcionarios = service.Funcionario.puxarFuncionarios();

    public static void setRemoverFuncionario(String nome) {
        if (nome == null || nome.isEmpty()) {
            System.out.println("\nFuncionário " + nome + " não encontrado.\n");
            return;
        } else if(funcionarios.isEmpty()) {
            throw new IllegalArgumentException("Nenhum funcionário encontrado.");
        }

        Funcionario nomeFuncionario = null;

        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getNome().equals(nome)) {
                nomeFuncionario = funcionario;
                break;
            }
        }

        funcionarios.remove(nomeFuncionario);
        System.out.println("\nFuncionário " + nome + " removido com sucesso!\n");
    }
}
