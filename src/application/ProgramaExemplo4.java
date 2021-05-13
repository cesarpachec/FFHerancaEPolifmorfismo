package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import entities.AbstractAccount;
import entities.BusinessAccountExtAbstract;
import entities.SavingsAccountExtAbstract;

public class ProgramaExemplo4 {

	public static void main(String[] args) {

		
		Locale.setDefault(Locale.US);
		// AbstractAccount acc1 = new AbstractAccount(1001, "Alex", 1000.0);
		// Exemplo de erro acima, uma classe abstrata não pode ser instanciada.

		AbstractAccount acc2 = new SavingsAccountExtAbstract(1002, "Maria", 1000.0, 0.01);
		AbstractAccount acc3 = new BusinessAccountExtAbstract(1003, "Bob", 1000.0, 500.00);

		// Continuando o exercício, abaixo a demonstração de funcionamento do
		// polimorfismo. Independente do tipo de conta, a função getbalance funciona
		// normalmente.

		List<AbstractAccount> list = new ArrayList<>();
		list.add(new SavingsAccountExtAbstract(1001, "Alex", 500.0, 0.01));
		list.add(new BusinessAccountExtAbstract(1002, "Maria", 1000.0, 400.00));
		list.add(new SavingsAccountExtAbstract(1004, "Bob", 300.0, 0.01));
		list.add(new BusinessAccountExtAbstract(1005, "Anna", 500.0, 500.00));

		double sum = 0.0;
		for (AbstractAccount abstractAccount : list) {
			sum += abstractAccount.getBalance();
			System.out.printf("Valores somados %.2f%n", abstractAccount.getBalance());
		}

		System.out.printf("Total balance: %.2f%n", sum);

		// Abaixo mais uma demonstração do polimorfismo, vamos somar 10 reais no balance
		// de cada uma das contas e depois demonstrar o resultado final, note que o
		// deposito também funciona independente do tipo de conta.

		for (AbstractAccount abstractAccount : list) {
			abstractAccount.deposit(10.0);
			System.out.printf("Updated balance for account %d: %.2f%n", abstractAccount.getNumber(),
					abstractAccount.getBalance());
		}

	}

}
