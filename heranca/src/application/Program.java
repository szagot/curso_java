package application;

import entities.Account;
import entities.BusinessAccount;
import entities.SavingsAccount;

public class Program {

	public static void main(String[] args) {

		Account acc = new Account(1001, "Alex", 0.0);
		BusinessAccount bacc = new BusinessAccount(1002, "Maria", 0.0, 500.0);

		// UPCASTING:
		// Fazendo um objeto do tipo Superclasse
		// recebendo um objeto do tipo Subclasse.
		// Isso � poss�vel, porque as subclasses tamb�m s�o do tipo da superclasse
		Account acc1 = bacc;
		Account acc2 = new BusinessAccount(1003, "Bob", 0.0, 200.0);
		Account acc3 = new SavingsAccount(1004, "Anna", 0.0, 0.01);

		// DOWNCASTING:
		// O oposto s� � poss�vel se for�ar a convers�o por DOWNCASTING.
		// Caso contr�rio, ocorrer� um erro de convers�o, mesmo que acc1 tenha herdado
		// de BusinessAccount, mas ela � uma Account
		BusinessAccount acc4 = (BusinessAccount) acc1;
		acc4.loan(100.0);

		// Embora o compilador n�o d� erro nessa linha, mas isso dar� um erro
		// em tempo de execu��o, pois embora acc3 tamb�m seja do tipo conta,
		// mas ela � uma subclasse (SavingsAccount) e n�o a Superclasse.
		// -> BusinessAccount acc5 = (BusinessAccount) acc3;

		// Para n�o dar erro, preciso primeiro testar se ac3 � uma inst�ncia de
		// BusinessAccount,
		// de forma que o DOWNCASTING possa ser seguro
		if (acc3 instanceof BusinessAccount) {
			// Isso n�o ser� executado
			BusinessAccount acc5 = (BusinessAccount) acc3;
			acc5.loan(200.0);
			System.out.println("Loan!");
		}

		// Fazendo o mesmo com uma que passar� no teste
		if (acc3 instanceof SavingsAccount) {
			// Isso ser� executado
			SavingsAccount acc5 = (SavingsAccount) acc3;
			acc5.updateBalance();
			System.out.println("Update!");
		}
		
		System.out.println("-------");

		// Exemplo de sobreposi��o
		Account contaCorrente = new Account(3000, "Daniel", 1000.0);
		Account contaPoupanca = new SavingsAccount(3000, "Daniel", 1000.0, 0.03);
		Account contaPJ = new BusinessAccount(3000, "Daniel", 1000.0, 500.0);
		// Sacando de cada conta o mesmo valor
		contaCorrente.withdraw(200.0);
		contaPoupanca.withdraw(200.0);
		contaPJ.withdraw(200.0);
		System.out.printf("Conta Corrente: R$ %.2f\n", contaCorrente.getBalance());
		// Aqui n�o ter� tido desconto, por causa da sobreposi��o do m�todo withdraw
		System.out.printf("Conta Poupan�a: R$ %.2f\n", contaPoupanca.getBalance());
		// Aqui ser� obtido um desconto maior, por causa da sobreposi��o do m�todo withdraw
		System.out.printf("Conta PJ......: R$ %.2f\n", contaPJ.getBalance());

	}

}
