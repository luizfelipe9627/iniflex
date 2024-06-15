package service;
import java.util.ArrayList;
import java.util.List;

public class Funcionario {
    private static final List<model.Funcionario> funcionarios = new ArrayList<>();

    public static List<model.Funcionario> puxarFuncionarios() {
        return funcionarios;
    }

    public static void criarFuncionarios() {
        CriarFuncionarios.setFuncionarios();
    }

    public static void removerFuncionario(String nome) {
        RemoverFuncionario.setRemoverFuncionario(nome);
    }

    public static void aplicarAumento(int aumentoPercentual) {
        AumentoSalarial.setAplicarAumento(aumentoPercentual);
        AumentoSalarial.getAplicarAumento();
    }

    public static void mostrarFuncionarios() {
       MostrarFuncionarios.getFuncionarios();
    }

    public static void mostrarFuncionariosFuncao() {
        FuncionariosPorFuncao.getOrdenarPorFuncao();
    }

    public static void ordenarFuncionariosFuncao() {
        FuncionariosPorFuncao.setOrdenarPorFuncao();
    }

    public static void mostrarPorMesversario(Integer mes) {
        Mesversario.setMesversario();
        Mesversario.getMesversario(mes);
    }

    public static void mostrarMaiorIdade() {
       MaiorIdade.setMaiorIdade();
       MaiorIdade.getMaiorIdade();
    }

    public static void mostrarFuncionariosOrdenados() {
       FuncionariosPorAlfabeto.setOrdenarPorAlfabeto();
       FuncionariosPorAlfabeto.getOrdenarPorAlfabeto();
    }

    public static void mostrarTotalSalarios() {
        TotalSalario.setSomarSalarios();
        TotalSalario.getSomarSalarios();
    }

    public static void mostrarMediaSalarial() {
        SalariosMinimos.setMediaSalarial();
        SalariosMinimos.getMediaSalarial();
    }
}
