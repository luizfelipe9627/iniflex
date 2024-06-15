package service;
import java.time.LocalDate;
import java.util.List;
import model.Funcionario;

public class MaiorIdade {
    private static final List<Funcionario> funcionarios = service.Funcionario.puxarFuncionarios();
    private static Funcionario funcionarioMaisAntigo = null;

    private static final String TABELA_CABECALHO = "-------------------- FUNCIONÁRIO COM MAIOR IDADE ---------------------";
    private static final String TABELA_RODAPE = "----------------------------------------------------------------------";

    public static void setMaiorIdade() {
        if(funcionarios.isEmpty()) {
            throw new IllegalArgumentException("Nenhum funcionário encontrado.");
        }

        int anoMaisAntigo = Integer.MAX_VALUE;

        for (Funcionario funcionario : funcionarios) {
            int anoNascimento = funcionario.getDataNascimento().getYear();

            if (anoNascimento < anoMaisAntigo) {
                anoMaisAntigo = anoNascimento;
                funcionarioMaisAntigo = funcionario;
            }
        }

        System.out.println("\nProcura pelo funcionário com maior idade concluída!");
    }

    public static void getMaiorIdade() {
        if(funcionarioMaisAntigo == null) {
            throw new IllegalArgumentException("Primeiro faça a busca do funcionários com maior idade, para depois imprimir a tabela.");
        }

        int anoAtual = LocalDate.now().getYear();

        if (funcionarioMaisAntigo != null) {
            System.out.println(TABELA_CABECALHO);
            System.out.println("Nome: " + funcionarioMaisAntigo.getNome());
            System.out.println("Idade: " + (anoAtual - funcionarioMaisAntigo.getDataNascimento().getYear()));
            System.out.println(TABELA_RODAPE);
        }
    }
}
