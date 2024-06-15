package service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Mesversario {
    private static final String TABELA_RODAPE = "----------------------------------------------------------------------";
    private static final Map<String, List<model.Funcionario>> funcionariosPorMesversario = new HashMap<>();
    private static final List<model.Funcionario> funcionarios = Funcionario.puxarFuncionarios();


    public static void setMesversario() {
        if(funcionarios.isEmpty()) {
            throw new IllegalArgumentException("Nenhum funcionário encontrado.");
        }

        for (model.Funcionario funcionario : funcionarios) {
            String mesString = String.format("%02d", funcionario.getDataNascimento().getMonthValue());
            List<model.Funcionario> listaFuncionarios = funcionariosPorMesversario.getOrDefault(mesString, new ArrayList<>());
            listaFuncionarios.add(funcionario);
            funcionariosPorMesversario.put(mesString, listaFuncionarios);
        }

        System.out.println("\nBusca de funcionário por mês de aniversário concluída!");
    }

    public static void getMesversario(Integer mes) {
        String mesString = String.format("%02d", mes);

        if(funcionariosPorMesversario.isEmpty()) {
            throw new IllegalArgumentException("Primeiro faça a busca de funcionários que fazem aniversário no mês passado, para depois imprimir a tabela.");
        } else if(mes > 12 || mes < 0) {
            throw new IllegalArgumentException("O mês selecionado não é válido.");
        }

        System.out.println("--------------- FUNCIONÁRIOS COM ANIVERSÁRIO NO MÊS ------------------" + mes);

        List<model.Funcionario> funcionariosNoMes = funcionariosPorMesversario.get(mesString);

        if (funcionariosNoMes != null) {
            for (model.Funcionario funcionario : funcionariosNoMes) {
                System.out.println(funcionario.getNome());
            }
        } else {
            System.out.println("Nenhum funcionário faz aniversário no mês definido.");
        }

        System.out.println(TABELA_RODAPE);
    }


}
