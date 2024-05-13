package aplicacao;

import entidades.Funcionario;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Programa {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<Funcionario> lista = new ArrayList<>();

        //Cadastrando funcionarios
        System.out.println(":::::: CADASTRO DE FUNCIONÁRIOS ::::::");
        System.out.println("Quantos funcionários irá cadastrar? ");
        int quant = sc.nextInt();

        //Informaçoes dos funcionarios
        for (int i = 1; i <= quant; i++) {
            sc.nextLine();
            System.out.println("Funcionário #" + i + ":");
            System.out.println("Nome: ");
            String nome = sc.nextLine();

            while(temNome(lista,nome)) {
				System.out.println("Nome ja registrado, Digite Novamente: ");
				nome = sc.nextLine();
			}


            System.out.println("Salário: ");
            double salario = sc.nextDouble();

            lista.add(new Funcionario(nome, salario));
        }








        sc.close();
    }

    //Método para controle de duplicidade
    public static boolean temNome(List<Funcionario> lista, String nome) {
		Funcionario emp = lista.stream().filter(x -> x.getNome() == nome).findFirst().orElse(null);
		return emp != null;
	}

}
