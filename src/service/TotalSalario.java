package service;
import java.math.BigDecimal;
import java.util.List;

public class TotalSalario {
    private static BigDecimal totalSalarios = BigDecimal.ZERO;
    private static final List<model.Funcionario> funcionarios = service.Funcionario.puxarFuncionarios();

    private static final String TABELA_CABECALHO = "----------------------- TOTAL DE SALÁRIOS " + "----------------------------";
    private static final String TABELA_RODAPE = "----------------------------------------------------------------------";

    public static void setSomarSalarios() {
        for (model.Funcionario funcionario : funcionarios) {
            BigDecimal salario = funcionario.getSalario();
            totalSalarios = totalSalarios.add(salario);
        }

        System.out.println("\nSoma do salário de todos os funcionários feita com sucesso!");
    }

    public static void getSomarSalarios() {
        if(funcionarios.isEmpty()) {
            throw new IllegalArgumentException("Nenhum funcionário encontrado.");
        }

        System.out.println(TABELA_CABECALHO);
        System.out.println("Total:" + " " + totalSalarios);
        System.out.println(TABELA_RODAPE);
    }
}
