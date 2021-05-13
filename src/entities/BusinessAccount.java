package entities;

public class BusinessAccount extends Account {

	private double loanLimit;

	// Deixaremos agora a palavra super(), pois se houver alguma lógica implementada
	// no construtor da super classe, também herdaremos essa lógica, já que estamos
	// trabalhando com herança "extends
	public BusinessAccount() {
		super();
	}

	public BusinessAccount(Integer number, String holder, Double balance, double loanLimit) {
		super(number, holder, balance);
		this.loanLimit = loanLimit;
	}

	public double getLoanLimit() {
		return loanLimit;
	}

	public void setLoanLimit(double loanLimit) {
		this.loanLimit = loanLimit;
	}

	public void loan(double amount) {
		if (amount <= loanLimit) {
			balance -= amount - 10;
		}
	}

}
