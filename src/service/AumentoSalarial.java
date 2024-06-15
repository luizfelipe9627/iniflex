package service;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.List;
import model.Funcionario;

public class AumentoSalarial {
    private static final DecimalFormat df = new DecimalFormat("#0.00");
    private static final List<Funcionario> funcionarios = service.Funcionario.puxarFuncionarios();

    private static final String TABELA_CABECALHO = """
            ---------------- FUNCIONÁRIOS COM AUMENTO SALARIAL -------------------
            | Nome           | Data Nascimento   | Salário     | Função          |
            ----------------------------------------------------------------------""";
    private static final String TABELA_RODAPE = "----------------------------------------------------------------------";

    public static void setAplicarAumento(int aumentoPercentual) {
        if (aumentoPercentual < 0) {
            throw new IllegalArgumentException("O aumento percentual deve ser positivo");
        } else if(funcionarios.isEmpty()) {
            throw new IllegalArgumentException("Nenhum funcionário encontrado.");
        }

        BigDecimal percentualDecimal = BigDecimal.valueOf(aumentoPercentual).divide(BigDecimal.valueOf(100));

        for (Funcionario funcionario : funcionarios) {
            BigDecimal salarioAtual = funcionario.getSalario();
            BigDecimal aumentoDecimal = salarioAtual.multiply(percentualDecimal);
            BigDecimal novoSalario = salarioAtual.add(aumentoDecimal);
            funcionario.setSalario(novoSalario);
        }

        System.out.println("\nAumento salarial aplicado com sucesso!");
    }

    public static void getAplicarAumento() {
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
