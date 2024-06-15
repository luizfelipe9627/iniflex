package service;
import java.text.DecimalFormat;
import java.util.Comparator;
import java.util.List;
import model.Funcionario;

public class FuncionariosPorAlfabeto {
    private static final DecimalFormat df = new DecimalFormat("#0.00");
    private static final List<Funcionario> funcionarios = service.Funcionario.puxarFuncionarios();

    private static final String TABELA_CABECALHO = """
            --------------- FUNCIONÁRIOS POR ORDEM ALFABÉTICA  -------------------
            | Nome           | Data Nascimento   | Salário     | Função          |
            ----------------------------------------------------------------------""";
    private static final String TABELA_RODAPE = "----------------------------------------------------------------------";

    public static void setOrdenarPorAlfabeto() {
        funcionarios.sort(Comparator.comparing(Funcionario::getNome));
        System.out.println("\nFuncionários ordenados por ordem alfabética com sucesso!");
    }

    public static void getOrdenarPorAlfabeto() {
        if(funcionarios.isEmpty()) {
            throw new IllegalArgumentException("Nenhum funcionário encontrado.");
        }

        System.out.println(TABELA_CABECALHO);

        for (Funcionario funcionario : funcionarios) {
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
