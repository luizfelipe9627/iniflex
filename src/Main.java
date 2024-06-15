import service.Funcionario;

public class Main {
    public static void main(String[] args) {
        Funcionario.criarFuncionarios(); // Inserir todos os funcionários, na mesma ordem e informações da tabela acima.
        Funcionario.removerFuncionario("João"); // Remover o funcionário “João” da lista.
        Funcionario.mostrarFuncionarios(); // Imprimir todos os funcionários com todas suas informações.
        Funcionario.aplicarAumento(10); // Os funcionários receberam 10% de aumento de salário, atualizar a lista de funcionários com novo valor.
        Funcionario.ordenarFuncionariosFuncao(); // Agrupar os funcionários por função em um MAP, sendo a chave a “função” e o valor a “lista de funcionários”.
        Funcionario.mostrarFuncionariosFuncao(); // Imprimir os funcionários, agrupados por função.
        Funcionario.mostrarPorMesversario(10); // Imprimir os funcionários que fazem aniversário no mês 10.
        Funcionario.mostrarPorMesversario(12); // Imprimir os funcionários que fazem aniversário no mês 12.
        Funcionario.mostrarMaiorIdade(); // Imprimir o funcionário com a maior idade, exibir os atributos: nome e idade.
        Funcionario.mostrarFuncionariosOrdenados(); // Imprimir a lista de funcionários por ordem alfabética.
        Funcionario.mostrarTotalSalarios(); // Imprimir o total dos salários dos funcionários.
        Funcionario.mostrarMediaSalarial(); // Imprimir quantos salários mínimos ganha cada funcionário, considerando que o salário mínimo é R$1212.00.
    }
}
