package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Pessoa;
import entities.PessoaFisica;
import entities.PessoaJuridica;

public class ProgramExercicioFixacao2 {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Pessoa> list = new ArrayList<>();
		
		System.out.print("Enter the number of tax payers: ");
		int n = sc.nextInt();
		
		for (int i = 1; i <= n; i++) {
			System.out.println("Tax payer #" + i + " data:");
			System.out.print("Individual or Company (i/c) ? ");
			char ch = sc.next().charAt(0);
			System.out.print("Name: ");
			String nome = sc.next();
			System.out.print("Anual Income: ");
			double rendaAnual = sc.nextDouble();
			if (ch == 'i') {
				System.out.print("Helth Expenditures: ");
				double gastosSaude = sc.nextDouble();
				list.add(new PessoaFisica(nome, rendaAnual, gastosSaude));
			} else {
				System.out.print("Number of Employees: ");
				int qtdeFuncionarios = sc.nextInt();
				list.add(new PessoaJuridica(nome, rendaAnual, qtdeFuncionarios));
			}
		}
		
		System.out.println();
		System.out.println("TAXES PAID: ");
		for (Pessoa pessoa : list) {
			System.out.println(pessoa.getNome() + " $ " + String.format("%.2f", pessoa.impostoPago()));
		}
		
		sc.close();
		
	}

}
