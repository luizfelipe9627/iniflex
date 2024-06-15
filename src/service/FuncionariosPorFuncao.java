package service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.Funcionario;

public class FuncionariosPorFuncao {
    private static final Map<String, List<Funcionario>> funcionariosPorFuncao = new HashMap<>();
    private static final List<Funcionario> funcionarios = service.Funcionario.puxarFuncionarios();

    private static final String TABELA_CABECALHO = "----------------- FUNCIONÁRIOS AGRUPADOS POR FUNÇÃO " +
            "------------------";
    private static final String TABELA_RODAPE = "----------------------------------------------------------------------";

    public static void setOrdenarPorFuncao() {
        if(funcionarios.isEmpty()) {
            throw new IllegalArgumentException("Nenhum funcionário encontrado.");
        }

        for (Funcionario funcionario : funcionarios) {
            String funcao = funcionario.getFuncao();
            List<Funcionario> listaFuncionarios = funcionariosPorFuncao.getOrDefault(funcao, new ArrayList<>());
            listaFuncionarios.add(funcionario);
            funcionariosPorFuncao.put(funcao, listaFuncionarios);
        }

        System.out.println("\nFuncionários agrupados por função com sucesso!");
    }

    public static void getOrdenarPorFuncao() {
        if(funcionariosPorFuncao.isEmpty()) {
            throw new IllegalArgumentException("Primeiro ordene os funcionários, para depois imprimir a tabela.");
        }

        System.out.println(TABELA_CABECALHO);

        for (Map.Entry<String, List<Funcionario>> entry : funcionariosPorFuncao.entrySet()) {
            System.out.println("Função: " + entry.getKey());
            for (Funcionario funcionario : entry.getValue()) {
                System.out.println("  " + funcionario.getNome());
            }
        }

        System.out.println(TABELA_RODAPE);
    }
}
