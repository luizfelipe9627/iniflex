package service;
import java.text.DecimalFormat;
import java.util.List;
import model.Funcionario;

public class MostrarFuncionarios {
    private static final DecimalFormat df = new DecimalFormat("#0.00");
    private static final List<Funcionario> funcionarios = service.Funcionario.puxarFuncionarios();

    private static final String TABELA_CABECALHO = """
                    --------------------------- FUNCIONÁRIOS -----------------------------
                    | Nome           | Data Nascimento   | Salário     | Função          |
                    ----------------------------------------------------------------------""";
    private static final String TABELA_RODAPE = "----------------------------------------------------------------------";

    public static void getFuncionarios() {
        if(funcionarios.isEmpty()) {
            throw new IllegalArgumentException("Nenhum funcionário encontrado.");
        }

        System.out.println(TABELA_CABECALHO);

        for (model.Funcionario funcionario : funcionarios) {
            String salarioFormatado = df.format(funcionario.getSalario());

            String linhaTabela = String.format("| %-14s | %-17s | %-11s | %-15s |",
            funcionario.getNome(),
            funcionario.getDataNascimentoFormatado(),
            salarioFormatado,
            funcionario.getFuncao());
            System.out.println(linhaTabela);
        }

        System.out.println(TABELA_RODAPE);
    }
}
