package service;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import model.Funcionario;


public class SalariosMinimos {
    private static final DecimalFormat df = new DecimalFormat("#0.00");
    private static final List<Funcionario> funcionarios = service.Funcionario.puxarFuncionarios();
    private static final BigDecimal salarioMinimo = new BigDecimal("1212.00");
    private static final Map<Funcionario, BigDecimal> salariosMinimosPorFuncionario = new HashMap<>();

    private static final String TABELA_CABECALHO = "------------------ QUANTIDADE SALÁRIOS MÍNIMOS  ----------------------";
    private static final String TABELA_RODAPE = "----------------------------------------------------------------------";

    public static void setMediaSalarial() {
        if(funcionarios.isEmpty()) {
            throw new IllegalArgumentException("Nenhum funcionário encontrado.");
        }

        for (Funcionario funcionario : funcionarios) {
            BigDecimal salariosMinimos = funcionario.getSalario().divide(salarioMinimo, 2, RoundingMode.HALF_UP);
            salariosMinimosPorFuncionario.put(funcionario, salariosMinimos);
        }

        System.out.println("\nA quantidade de salários mínimos foi calculada com sucesso!");
    }

    public static void getMediaSalarial() {
        if(funcionarios.isEmpty()) {
            throw new IllegalArgumentException("Nenhum funcionário encontrado.");
        }

        System.out.println(TABELA_CABECALHO);

        for (Funcionario funcionario : funcionarios) {
            String salarioFormatado = df.format(funcionario.getSalario());
            BigDecimal salariosMinimos = salariosMinimosPorFuncionario.get(funcionario);

            System.out.println("Funcionário: " + funcionario.getNome() + " - Salário: " + salarioFormatado + " - Salários Mínimos: " + salariosMinimos);
        }

        System.out.println(TABELA_RODAPE);
    }
}
