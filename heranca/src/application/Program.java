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
		// Isso é possível, porque as subclasses também são do tipo da superclasse
		Account acc1 = bacc;
		Account acc2 = new BusinessAccount(1003, "Bob", 0.0, 200.0);
		Account acc3 = new SavingsAccount(1004, "Anna", 0.0, 0.01);

		// DOWNCASTING:
		// O oposto só é possível se forçar a conversão por DOWNCASTING.
		// Caso contrário, ocorrerá um erro de conversão, mesmo que acc1 tenha herdado
		// de BusinessAccount, mas ela é uma Account
		BusinessAccount acc4 = (BusinessAccount) acc1;
		acc4.loan(100.0);

		// Embora o compilador não dê erro nessa linha, mas isso dará um erro
		// em tempo de execução, pois embora acc3 também seja do tipo conta,
		// mas ela é uma subclasse (SavingsAccount) e não a Superclasse.
		// -> BusinessAccount acc5 = (BusinessAccount) acc3;

		// Para não dar erro, preciso primeiro testar se ac3 é uma instância de
		// BusinessAccount,
		// de forma que o DOWNCASTING possa ser seguro
		if (acc3 instanceof BusinessAccount) {
			// Isso não será executado
			BusinessAccount acc5 = (BusinessAccount) acc3;
			acc5.loan(200.0);
			System.out.println("Loan!");
		}

		// Fazendo o mesmo com uma que passará no teste
		if (acc3 instanceof SavingsAccount) {
			// Isso será executado
			SavingsAccount acc5 = (SavingsAccount) acc3;
			acc5.updateBalance();
			System.out.println("Update!");
		}
		
		System.out.println("-------");

		// Exemplo de sobreposição
		Account contaCorrente = new Account(3000, "Daniel", 1000.0);
		Account contaPoupanca = new SavingsAccount(3000, "Daniel", 1000.0, 0.03);
		Account contaPJ = new BusinessAccount(3000, "Daniel", 1000.0, 500.0);
		// Sacando de cada conta o mesmo valor
		contaCorrente.withdraw(200.0);
		contaPoupanca.withdraw(200.0);
		contaPJ.withdraw(200.0);
		System.out.printf("Conta Corrente: R$ %.2f\n", contaCorrente.getBalance());
		// Aqui não terá tido desconto, por causa da sobreposição do método withdraw
		System.out.printf("Conta Poupança: R$ %.2f\n", contaPoupanca.getBalance());
		// Aqui será obtido um desconto maior, por causa da sobreposição do método withdraw
		System.out.printf("Conta PJ......: R$ %.2f\n", contaPJ.getBalance());

	}

}
