package application;

import entities.Account;
import entities.BusinessAccount;
import entities.SavingsAccount;

public class ProgramExemplo2 {

	public static void main(String[] args) {

		Account acc = new Account(1001, "Alex", 0.0);
		BusinessAccount bacc = new BusinessAccount(1002, "Maria", 0.0, 500.00);

		// UPCASTING
		// Note que não dá nenhum erro, porque Herança é uma relação do tipo "é um",
		// nesse caso BusinesseAccount é uma Account, então o upcasting é possível sem
		// erros.

		Account acc1 = bacc;
		Account acc2 = new BusinessAccount(1003, "Bob", 0.0, 200.0);
		Account acc3 = new SavingsAccount(1004, "Anna", 0.0, 0.01);

		// DOWNCASTING
		// Nesse caso eu tenho que indicar o tipo de conta entre parenteses, pois acc2
		// foi criada como sendo um "Accout" mesmo ela sendo instanciada como Businesse
		// Account o compilador não reconhece isso sem que o informemeos.

		BusinessAccount acc4 = (BusinessAccount) acc2;

		// Na operação abaixo tentamos fazer o mesmo procedimento de downcasting, o
		// pré-compilador não acusa o problema, mas acc3 é uma "savingsAccount"
		// subclasse de Account e não de businessAccount, o pré-compilador não consegue
		// enxergar esse problema, mas em tempo de execuçao o erro ocorrerá!
		
		//BusinessAccount acc5 = (BusinessAccount) acc3;
		
		//Erro ocasionado pela instrução acima.
		//Exception in thread "main" java.lang.ClassCastException: class entities.SavingsAccount cannot be cast to class entities.BusinessAccount (entities.SavingsAccount and entities.BusinessAccount are in unnamed module of loader 'app')
		//at application.ProgramExemplo2.main(ProgramExemplo2.java:35)
		
		//Para evitar o problema acima, devemos testa-lo, conforme abaixo:
		
		if (acc3 instanceof BusinessAccount) {
			BusinessAccount acc5 = (BusinessAccount) acc3;
			acc5 = (BusinessAccount) acc3;
			acc5.loan(200.0);
			System.out.println("Loan!");
		}
		
		if (acc3 instanceof SavingsAccount) {
			SavingsAccount acc5 = (SavingsAccount)acc3;
			acc5.updateBalance();
			System.out.println("Update!");
		}
	}

}
